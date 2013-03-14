/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.controller;

import com.rbm.arduino.model.Arduino;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 * This class is a new ActionListener
 *
 * @author rajen
 */
public class ChckListener implements ActionListener {

    private Arduino ard;
    private final String[] lights = {
        "red", "yellow", "green"};
    private List<String> led;

    /**
     * Creates a ChckListener which detects if a check-box is checked
     *
     * @param ard Arduino object
     */
    public ChckListener(Arduino ard) {
        this.ard = ard;
        led = Arrays.asList(lights);
    }

    /**
     * Method to respond to check-box
     *
     * @param e Action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Integer number = (led.indexOf(e.getActionCommand())) + 1; //Use the action command to locate the position in the array
            //System.out.println("number: " + number.toString());
            ard.write(number.toString()); //Write this out to Arduino

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ChckListener.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
}
