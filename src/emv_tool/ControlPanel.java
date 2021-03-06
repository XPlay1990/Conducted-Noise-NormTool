/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emv_tool;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 *
 * @author michael.machate
 */
public class ControlPanel extends javax.swing.JFrame implements Observer {

    Communication communication;

    /**
     * Creates new form ControlPanel
     */
    public ControlPanel() {
        initComponents();
        initComports();
        this.setTitle("EMV_TOOL v1.2");
    }

    private void initComports() {
        String[] portNames = SerialPortList.getPortNames();
        if (portNames.length > 0) {
            jComboBoxComPort.setModel(new javax.swing.DefaultComboBoxModel<>(portNames));
        } else {
            jComboBoxComPort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"No active Port found"}));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelComPort1 = new javax.swing.JLabel();
        jButtonStop = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();
        jTextFieldStartFrequency = new javax.swing.JTextField();
        jTextFieldStopFrequency = new javax.swing.JTextField();
        jTextFieldStepFrequency = new javax.swing.JTextField();
        jTextFieldDwellTime = new javax.swing.JTextField();
        jLabelDwellTime = new javax.swing.JLabel();
        jLabeljLabelStepFrequency = new javax.swing.JLabel();
        jLabelStopFrequency = new javax.swing.JLabel();
        jLabelStartFrequency = new javax.swing.JLabel();
        jComboBoxComPort = new javax.swing.JComboBox();
        jLabelComPort = new javax.swing.JLabel();
        jTextFieldBaudRate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelComPortBaudRate = new javax.swing.JLabel();
        actualFrequency = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelRestTime = new javax.swing.JLabel();
        jTextFieldRestTime = new javax.swing.JTextField();

        jLabelComPort1.setText("COM Port");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jTextFieldStartFrequency.setText("150.000");

        jTextFieldStopFrequency.setText("80.000.000");

        jTextFieldStepFrequency.setText("1.0");
        jTextFieldStepFrequency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStepFrequencyActionPerformed(evt);
            }
        });

        jTextFieldDwellTime.setText("2.000");

        jLabelDwellTime.setText("Dwell Time [ms]");

        jLabeljLabelStepFrequency.setText("Step Frequency [%]");

        jLabelStopFrequency.setText("Stop Frequency [Hz]");

        jLabelStartFrequency.setText("Start Frequency [Hz]");

        jComboBoxComPort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelComPort.setText("COM Port");

        jTextFieldBaudRate.setText("115200");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emv_tool/logo.jpg"))); // NOI18N

        jLabelComPortBaudRate.setText("Baud Rate");

        actualFrequency.setEditable(false);
        actualFrequency.setText("0");
        actualFrequency.setEnabled(false);

        jLabel1.setText("ActualFrequency");

        jLabelRestTime.setText("Rest Time [ms]");

        jTextFieldRestTime.setText("1.000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelStartFrequency)
                            .addComponent(jLabelStopFrequency)
                            .addComponent(jLabeljLabelStepFrequency)
                            .addComponent(jTextFieldStepFrequency)
                            .addComponent(jTextFieldStartFrequency)
                            .addComponent(jTextFieldStopFrequency)
                            .addComponent(jLabelComPort)
                            .addComponent(jComboBoxComPort, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldBaudRate)
                                    .addComponent(jLabelComPortBaudRate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(actualFrequency, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldRestTime)
                            .addComponent(jLabelRestTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDwellTime)
                            .addComponent(jLabelDwellTime, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelStartFrequency)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStartFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelStopFrequency))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldStopFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabeljLabelStepFrequency)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStepFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelRestTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldRestTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDwellTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDwellTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelComPort)
                            .addComponent(jLabelComPortBaudRate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxComPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBaudRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonStart)
                            .addComponent(jButtonStop, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(actualFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        try {
            communication.stopThread();
        } catch (NullPointerException e) {

        }
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        try {

            communication = new Communication(jComboBoxComPort.getSelectedItem().toString(),
                    Integer.valueOf(jTextFieldBaudRate.getText()),
                    8,
                    1,
                    Integer.valueOf(jTextFieldStartFrequency.getText().replace(".", "")),
                    Integer.valueOf(jTextFieldStopFrequency.getText().replace(".", "")),
                    Double.valueOf(jTextFieldStepFrequency.getText()),
                    Integer.valueOf(jTextFieldDwellTime.getText().replace(".", "")),
                    Integer.valueOf(jTextFieldRestTime.getText().replace(".", ""))
            );
            communication.addObserver(this);
            Thread thread = new Thread(communication);
            thread.setPriority(Thread.MAX_PRIORITY - 2);
            thread.start();
        } catch (SerialPortException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        communication.stopThread();
    }//GEN-LAST:event_formWindowClosed

    private void jTextFieldStepFrequencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStepFrequencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStepFrequencyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actualFrequency;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JComboBox jComboBoxComPort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelComPort;
    private javax.swing.JLabel jLabelComPort1;
    private javax.swing.JLabel jLabelComPortBaudRate;
    private javax.swing.JLabel jLabelDwellTime;
    private javax.swing.JLabel jLabelRestTime;
    private javax.swing.JLabel jLabelStartFrequency;
    private javax.swing.JLabel jLabelStopFrequency;
    private javax.swing.JLabel jLabeljLabelStepFrequency;
    private javax.swing.JTextField jTextFieldBaudRate;
    private javax.swing.JTextField jTextFieldDwellTime;
    private javax.swing.JTextField jTextFieldRestTime;
    private javax.swing.JTextField jTextFieldStartFrequency;
    private javax.swing.JTextField jTextFieldStepFrequency;
    private javax.swing.JTextField jTextFieldStopFrequency;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        double activeFrequency = communication.getActualFrequency();
        String withSuffix = withSuffix(activeFrequency);
        this.actualFrequency.setText(withSuffix+"Hz");
    }

    public static String withSuffix(double count) {
        if (count < 1000) {
            return "" + count;
        }
        int exp = (int)(Math.log(count) / Math.log(1000));
        return String.format("%.3f %c",
                count / Math.pow(1000, exp),
                "kMGTPE".charAt((int)(exp - 1)));
    }
}
