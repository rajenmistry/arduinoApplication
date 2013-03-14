/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.controller;

import com.rbm.arduino.model.Arduino;
import com.rbm.arduino.view.CheckBoxPanel;
import com.rbm.arduino.view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

/**
 *
 * @author rajen
 */
public class Controller {

    private Arduino arduino;
    private MainWindow mainWindow;
    private CheckBoxPanel checkBoxPanel;

    public Controller(Arduino arduino, MainWindow mainWindow, CheckBoxPanel checkBoxPanel) {
        this.arduino = arduino;
        this.mainWindow = mainWindow;
        this.checkBoxPanel = checkBoxPanel;
    }

    void initialise() {
        arduino.initialize();
        mainWindow.addWindowListener(new WndwListener(arduino));
        JCheckBox[] boxes = checkBoxPanel.getBoxes();
        for (JCheckBox jCheckBox : boxes) {
            jCheckBox.addActionListener(new ChckListener(arduino));
        }

        /**
         * Add actionListerner to temperature button
         * Assign checkPanel text area to a textArea
         */
        JButton temperature = checkBoxPanel.getTempertureGetter();
        JTextArea textArea = checkBoxPanel.getText();
        temperature.addActionListener(new TemperatureListener(arduino, textArea)); //pass the text area and arduino to temperature Listener

        
        /**
         * Set up temperature polling
         */
        JTextArea logArea = checkBoxPanel.getLogArea();
        JToggleButton startPolling = checkBoxPanel.getTemperaturelogger();
        startPolling.addItemListener(new StartPollingListener(arduino, logArea));
        

        mainWindow.CreateGui();
        mainWindow.add(checkBoxPanel);
        mainWindow.setVisible(true);


    }
}
