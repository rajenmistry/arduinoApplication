/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rbm.arduino.model;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajen
 */
public class Arduino{

    SerialPort serialPort;
    private OutputStream output;
   // private BufferedReader input;
    
    private Scanner input;
    
    private static String PORT_NAMES[] = {"/dev/ttyACM0"};
    private static final int TIME_OUT = 2000;

    public void initialize() {
        /*
         * https://lists.ubuntu.com/archives/universe-bugs/2009-April/081981.html
         */
        CommPortIdentifier portId = null;
        System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");



        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {

            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String port : PORT_NAMES) {
                if (currPortId.getName().equals(port)) {
                    portId = currPortId;

                    break;
                }// end if
            }// end for



        }//end while
        if (portId == null) {
            System.out.println("port not found");
            System.exit(1);
        }//end if



        try {

            serialPort = (SerialPort) portId.open("/dev/ttyACM0", TIME_OUT);
            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            output = serialPort.getOutputStream();

        } catch (UnsupportedCommOperationException | IOException | PortInUseException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    public void write(String message) throws IOException, InterruptedException {
        byte[] b = message.getBytes();
        output.write(b);
        output.flush();

    }

    public synchronized void close() {


        if (serialPort != null) {
            serialPort.close();

        }
    }

    public String read() throws IOException {
        input=new Scanner( serialPort.getInputStream());
       // input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
      
        return input.nextLine();



        //To change body of generated methods, choose Tools | Templates.
    }
}
