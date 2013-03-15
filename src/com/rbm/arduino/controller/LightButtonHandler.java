/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.controller;

import com.rbm.arduino.model.Arduino;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * JavaFx Button handler
 *
 * @author rajen
 */
public class LightButtonHandler implements EventHandler<ActionEvent> {
    
    private Arduino arduino;
    private Circle small;
private boolean red; 
    public LightButtonHandler(Arduino arduino, Circle small) {
        this.arduino = arduino;
        this.small = small;
        this.red=false;
    }
    
    @Override
    public void handle(ActionEvent t) {
        if(!red){
       small.setFill(Color.RED);
        }else{
            small.setFill(Color.WHITE);
        }red=!red;
        
        if(t.getSource().toString().contains("Red")){
            System.out.println("red button");
        }
        
 
        try {
            arduino.write("1");
            
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LightButtonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
