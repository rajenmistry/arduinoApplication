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
public class Arduino {

    SerialPort serialPort;
    private OutputStream output;
    // private BufferedReader input;
    private Scanner input;
    private static String PORT_NAMES[] = {"/dev/ttyACM0", "COM3"};
    private static final int TIME_OUT = 2000;

    public void initialize() {
        /*
         * https://lists.ubuntu.com/archives/universe-bugs/2009-April/081981.html
         */

        System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

            for (String port : PORT_NAMES) {//iterate over the the ports to find port
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
            /**
             * Set up the serial port (9600 kbps, 8 data bits, 1 stop bit,
             * partity none)
             */
            serialPort = (SerialPort) portId.open("/dev/ttyACM0", TIME_OUT);
            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            output = serialPort.getOutputStream();

        } catch (UnsupportedCommOperationException | IOException | PortInUseException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method writes text to Arduino
     *
     * @param message text to send to Arduino
     * @throws IOException
     * @throws InterruptedException
     */
    public void write(String message) throws IOException, InterruptedException {
        byte[] b = message.getBytes();
        output.write(b);
        output.flush();

    }

    /**
     * Closes the connection
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.close();
        }
    }

    /**
     * Read data from Arduino
     *
     * @return String read from Arduino
     * @throws IOException
     */
    public String read() throws IOException {
        input = new Scanner(serialPort.getInputStream());
        return input.nextLine();

    }
}
