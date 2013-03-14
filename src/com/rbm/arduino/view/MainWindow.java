/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.view;

import javax.swing.JFrame;

/**
 *
 * @author rajen
 */
public class MainWindow extends JFrame {
    
    public void CreateGui() {
        this.setTitle("Arduino Window");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocation(300, 300);
      
    }
}
