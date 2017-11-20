/* 
 *  Copyright (C) Jan Adamczyk (j_adamczyk@hotmail.com) 2017
 */
package emv_tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.swing.JOptionPane;

/**
 * Class to Handle Txt-File Logging of the Data
 *
 * @author Jan.Adamczyk
 */
public final class TxtLog implements Runnable {

    private final File file;
    private final PrintWriter writer;
    private String logLine;
    private boolean isFinished = false;
    private final Lock lock;
    private final Condition condition;

    @Override
    public void run() {
        while (!isFinished) // you will need to set some condition if you want to stop the thread in a certain time...
        {
            try {
                lock.lock();
                condition.await();
                //Code here
                writeOut(logLine);
            } catch (InterruptedException e) {
//                    e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     *
     * @param logLine
     * @param lock
     * @param condition
     * @throws FileNotFoundException
     */
    public TxtLog(String logLine, Lock lock, Condition condition) throws FileNotFoundException {
        String dateTime = LocalDateTime.now().toString().replaceAll(":", "-");
        dateTime = dateTime.replaceAll("T", "_Time_");
        this.file = new File("EMVTool_Logfile_" + dateTime + ".txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        writer = new PrintWriter(file);
        this.logLine = logLine;
        this.lock = lock;
        this.condition = condition;
    }

    /**
     *
     * @param line
     */
    public void writeOut(String line) {
        writer.println(line);
        writer.flush();
    }

    /**
     *
     */
    public void closeStream() {
        writer.flush();
        writer.close();
    }

    /**
     *
     */
    public void setFinished() {
        isFinished = true;
    }

    /**
     *
     * @param s
     */
    public void addToLogLine(String s) {
        logLine = logLine + s;
    }

    /**
     *
     * @param s
     */
    public void newLogLine(String s) {
        logLine = s;
    }
}
