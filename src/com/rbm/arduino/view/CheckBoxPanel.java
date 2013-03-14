/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author rajen
 */
public class CheckBoxPanel extends JPanel {

    private JCheckBox[] boxes = {new JCheckBox("red"), new JCheckBox("green"),
        new JCheckBox("yellow")};
    private JTextArea text, logArea;
    private JButton tempertureGetter;
    private JRadioButton temperaturelogger;

    /**
     * This class creates the GUI and is composed of 2 panels
     */
    public CheckBoxPanel() {
        this.setLayout(new GridLayout(3, 1));

        /**
         * Top panel, this is where the check boxes are
         */
        JPanel topPanel = new JPanel();
        for (JCheckBox a : boxes) { //add each check box to the panel
            topPanel.add(a);
        }
        this.add(topPanel);


        /**
         * Middle panel this is where the temperature button is
         */
        JPanel middlePanel = new JPanel();
        text = new JTextArea("Temperature");
        tempertureGetter = new JButton("Temperature");
        middlePanel.add(tempertureGetter);
        middlePanel.add(text);
        this.add(middlePanel);


        /**
         * Third panel; temperature logger
         */
        JPanel bottomPanel = new JPanel();
        temperaturelogger = new JRadioButton("Temperature Logging");
        logArea = new JTextArea("");
        logArea.setSize(100, 100);
        bottomPanel.add(temperaturelogger);
        bottomPanel.add(logArea);
        this.add(bottomPanel);

    }

    /**
     * Get the array of JCheckBoxes for lights
     *
     * @return array of check boxes
     */
    public JCheckBox[] getBoxes() {
        return this.boxes;
    }

    /**
     * Get TextArea for temperature data
     *
     * @return JTextArea
     *
     */
    public JTextArea getText() {
        return text;
    }

    /**
     * Get JButton that requests temperature
     *
     * @return JButton
     */
    public JButton getTempertureGetter() {
        return tempertureGetter;
    }

    /**
     * Get JTextArea for temperature logging
     *
     * @return JTextArea
     */
    public JTextArea getLogArea() {
        return logArea;
    }

    /**
     * Get JRadioButton to start/stop temperature logging
     *
     * @return
     */
    public JRadioButton getTemperaturelogger() {
        return temperaturelogger;
    }
}
