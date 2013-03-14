/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.model;

import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 * http://enos.itcollege.ee/~jpoial/docs/tutorial/essential/threads/timer.html
 *
 * @author rajen
 */
public class PollingArduino extends TimerTask {

    private Arduino arduino;
    private JTextArea logArea;

  
    public PollingArduino(Arduino arduino, JTextArea logArea) {
        this.arduino = arduino;
        this.logArea = logArea;
    }

    @Override
    public void run() {
        try {
            arduino.write("5");
            Thread.sleep(1000);
            String message = arduino.read();
            System.out.println(message);
            logArea.setText(message);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PollingArduino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
