/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


/**
 *
 * @author rajen
 */
public class CheckBoxPanel extends JPanel {

    private JCheckBox[] boxes = {new JCheckBox("red"), new JCheckBox("green"), new JCheckBox("yellow")};
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

        /**
         * Add each check box to the panel
         */
        for (JCheckBox a : boxes) {
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
         logArea = new JTextArea("Temperature Log");
  
        bottomPanel.add(temperaturelogger);
        bottomPanel.add(logArea);
        this.add(bottomPanel);

    }

    public JCheckBox[] getBoxes() {
        return this.boxes;
    }

    public JTextArea getText() {
        return text;
    }

    public JButton getTempertureGetter() {
        return tempertureGetter;
    }

    
    public JTextArea getLogArea() {
        return logArea;
    }


    
    public JRadioButton getTemperaturelogger() {
        return temperaturelogger;
    }
}
