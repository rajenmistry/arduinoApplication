/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.model;

import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *http://enos.itcollege.ee/~jpoial/docs/tutorial/essential/threads/timer.html
 * @author rajen
 */
public class PollingArduino extends TimerTask {

    private Arduino arduino;

    public PollingArduino(Arduino arduino) {
        this.arduino = arduino;
    }

    @Override
    public void run() {
        try {
            arduino.write("5");
            Thread.sleep(1000);
            String message = arduino.read();
            System.out.println(message);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PollingArduino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
