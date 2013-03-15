/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.view.javafx;

import com.rbm.arduino.controller.LightButtonHandler;
import com.rbm.arduino.model.Arduino;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.EllipseBuilder;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Basic JavaFx UI
 *
 * @author rajen
 */
public class FxUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Arduino ard = new Arduino();
        ard.initialize();
        Button button = new Button("Lights");
        button.setId("Red Light");
        button.setFont(javafx.scene.text.Font.font(Font.SERIF, 16));

        Circle small = new Circle();
        small.setCenterX(100.0f);
        small.setCenterY(100.0f);
        small.setRadius(50.0f);
        small.setFill(Color.WHITE);
        
        
        LightButtonHandler a = new LightButtonHandler(ard, small);
        button.setOnAction(a);

        StackPane root = new StackPane();
        root.getChildren().add(small);
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
