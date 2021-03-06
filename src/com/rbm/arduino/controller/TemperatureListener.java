/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.controller;

import com.rbm.arduino.model.Arduino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author rajen
 */
class TemperatureListener implements ActionListener {

    private Arduino arduino;
    private JTextArea textBox;
    private String oldTemperature;
    private JTextArea debug;

    public void setOldTemperature(String oldTemperature) {
        this.oldTemperature = oldTemperature;
    }

    public String getOldTemperature() {
        return oldTemperature;
    }

    /**
     * Create ActionListener that takes Arduino and JTextArea
     *
     * @param arduino
     * @param textBox
     */
    public TemperatureListener(Arduino arduino, JTextArea textBox) {
        this.arduino = arduino;
        this.textBox = textBox;
        oldTemperature = "Fail";
    }

    /**
     * Method to get Temperature data from Arduino
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            JButton temp = (JButton) e.getSource(); //cast the source into Jbutton
            temp.setEnabled(false);
            arduino.write("5");
            String message = arduino.read();
            Thread.sleep(500);

            if (message.equals("")) {
                textBox.setText("Fail");
            } else {
                textBox.setText(message);
            }

            temp.setEnabled(true);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(TemperatureListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
