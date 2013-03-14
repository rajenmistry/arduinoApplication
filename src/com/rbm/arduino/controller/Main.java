/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.controller;

import com.rbm.arduino.model.Arduino;
import com.rbm.arduino.view.CheckBoxPanel;
import com.rbm.arduino.view.MainWindow;
import javax.swing.JCheckBox;
import javax.swing.SwingUtilities;

/**
 *
 * @author rajen
 */
public class Main {

    private static Arduino arduino = new Arduino();
    private static MainWindow mainwindow= new MainWindow();
    private static CheckBoxPanel checkboxpanel =new CheckBoxPanel();

    public static void main(String[] args) {
       

    


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Controller controller = new Controller(arduino, mainwindow, checkboxpanel);
                controller.initialise();
                
                
              
                


           
                //To change body of generated methods, choose Tools | Templates.

            }
        });





    }
}