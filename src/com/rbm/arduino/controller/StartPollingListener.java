/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.controller;

import com.rbm.arduino.model.Arduino;
import com.rbm.arduino.model.PollingArduino;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JTextArea;
import java.util.Timer;

/**
 *http://enos.itcollege.ee/~jpoial/docs/tutorial/essential/threads/timer.html
 * @author rajen
 */
class StartPollingListener implements ItemListener {

    private Arduino arduino;
    private JTextArea logArea;
    private Timer timer;

    public StartPollingListener(Arduino arduino, JTextArea logArea) {
        this.arduino = arduino;
        this.logArea = logArea;

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new PollingArduino(arduino,logArea), 0, 2000);
            

        } else {
            timer.cancel();
        }
    }
}
