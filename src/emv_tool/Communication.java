/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emv_tool;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author michael.machate
 */
public class Communication extends java.util.Observable implements Runnable {

    private final SerialPort serialPort;
    private final String comport;
    private final int baudrate;
    private final int dataBits;
    private final int stopBits;
    private Boolean runFlag = true;

    private final int startFrequency;
    private final int endFrequency;
    private final double incrementStep;
    private final int restTime;     //time between two frequency blocks (no output)
    private final int dwellTime;    //length of a frequency block
    private TxtLog txtLog;
    private Thread txtLogThread;
    private ReentrantLock lock;
    private Condition condition;
    private double actualFrequency;

    @Override
    public void run() {
        actualFrequency = startFrequency;

        while (runFlag) {

            if (actualFrequency > endFrequency) {
                stopThread();
                break;
            }

            //Dwell Time
            try {
                serialPort.writeString("FREQuency " + actualFrequency + "\r" + "\n");
                serialPort.writeString("AM:STATe ON" + "\r" + "\n"); //Modulation
                setChanged();
                notifyObservers();
                txtLog.newLogLine(time() + "\t" + actualFrequency);

                lock.lock();
                try {
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }

            } catch (SerialPortException ex) {
//                Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                serialPort.writeString("OUTPut ON" + "\r" + "\n");
            } catch (SerialPortException ex) {
//                Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Thread.sleep(dwellTime);
            } catch (InterruptedException ex) {
//                Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Rest Time
            try {
                serialPort.writeString("OUTPut OFF" + "\r" + "\n");
            } catch (SerialPortException ex) {
//                Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(restTime);
            } catch (InterruptedException ex) {
//                Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            }

            actualFrequency += actualFrequency * (incrementStep / 100.0d);
        }
    }

    public Communication(String comport, int baudrate, int dataBits, int stopBits, int startFrequency,
            int endFrequency, double incrementStep, int dwellTime, int restTime) throws SerialPortException {
        this.comport = comport;
        this.baudrate = baudrate;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.startFrequency = startFrequency;
        this.endFrequency = endFrequency;
        this.incrementStep = incrementStep;
        this.restTime = restTime;
        this.dwellTime = dwellTime;

        serialPort = new SerialPort(comport);
        serialPort.openPort();//Open serial port
        serialPort.setParams(baudrate, dataBits, stopBits, 0);//Set params.
        int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR;//Prepare mask
        serialPort.setEventsMask(mask);//Set mask

        lock = new ReentrantLock();
        condition = lock.newCondition();
        try {
            txtLog = new TxtLog(comport, lock, condition);
            txtLogThread = new Thread(txtLog);
            txtLogThread.start();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void stopThread() {
        try {
            serialPort.writeString("OUTPut OFF" + "\r" + "\n");
        } catch (SerialPortException ex) {
//            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
//            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }

        setRunFlag();
        serialPortClose();

        txtLog.closeStream();
        txtLog.setFinished();
    }

    private void setRunFlag() {
        this.runFlag = false;
    }

    private void serialPortClose() {
        try {
            serialPort.closePort();
        } catch (SerialPortException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String time() {
//        return Instant.now().toString();
        LocalTime toLocalTime = getTime();
        return toLocalTime.toString();
    }

    LocalTime getTime() {
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.now(zone);
        return zdt.toLocalTime();
    }

    public double getActualFrequency() {
        return actualFrequency;
    }
}
