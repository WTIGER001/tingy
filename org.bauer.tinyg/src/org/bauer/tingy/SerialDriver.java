/*
 * Copyright (C) 2013-2014 Synthetos LLC. All Rights reserved.
 * http://www.synthetos.com
 */
package org.bauer.tingy;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;

//import gnu.io.*;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

import org.apache.log4j.Logger;

/**
 *
 * @author ril3y
 */
public class SerialDriver implements SerialPortEventListener {
	// Logger used to record actions 
	private static Logger logger = Logger.getLogger(SerialWriter.class);
	
	// Flag to record if we are connected to the serial port. 
	private boolean connectionState = false;
	
	// Array of available ports
	public String portArray[] = null;
	
	// Serial port that we are connected to
	public SerialPort serialPort;
	
	// Stream for receiving data
	public InputStream input;
	
	// Stream for sending data
	public OutputStream output;
	
	private static byte[] lineBuffer = new byte[1024];
		
	private static int lineIdx = 0;
	
	public ArrayList<String> lastRes = new ArrayList<String>();
	
	public double offsetPointer = 0;

	/**
	 * private constructor since this is a singleton
	 */
	private SerialDriver() {
	}

	public static SerialDriver getInstance() {
		return SerialDriver.SerialDriverHolder.INSTANCE;
	}

	/**
	 * Write a String to the serial port. 
	 * @param str
	 */
	// TODO synchronized??
	public void write(String str) {
		try {
			serialPort.writeBytes(str.getBytes());
			// this.output.write(str.getBytes());
			logger.debug("Wrote Line: " + str);
		} catch (Exception ex) {
			logger.error("Error in SerialDriver Write");
			logger.error("\t" + ex.getMessage());
		}
	}

	/**
	 * Write a String to the serial port. Currently this is the same as write
	 * @param str
	 */
	// TODO synchronized??
	public void priorityWrite(String str) throws Exception {
		serialPort.writeBytes(str.getBytes());
	}

	/**
	 * Send a single byte to the serial port
	 * @param b
	 * @throws Exception
	 */
	// TODO synchronized??
	public void priorityWrite(Byte b) throws Exception {
		logger.debug("[*] Priority Write Sent\n");
		serialPort.writeByte(b);
	}

	/**
	 * Disconnect from the port
	 * @throws SerialPortException
	 */
	public synchronized void disconnect() throws SerialPortException {
		if (serialPort != null && serialPort.isOpened()) {
			try {
				serialPort.closePort();
			} finally {
				setConnected(false); // Set our disconnected state
			}
		}
	}

	public void setConnected(boolean c) {
		this.connectionState = c;
	}

	public boolean isConnected() {
		return this.connectionState;
	}

	@Override
	public void serialEvent(SerialPortEvent event) {
		if (event.isRXCHAR()) {
			byte[] tmpBuffer = null;
			int bytesToRead = event.getEventValue();
			try {
				tmpBuffer = serialPort.readBytes(bytesToRead, serialPort.getInputBufferBytesCount());
				//TODO Fix non-optimal code
				for (int i = 0; i < bytesToRead; i++) {
					if (tmpBuffer[i] == 0xA) { // inbuffer[i] is a \n
						String f = new String(lineBuffer, 0, lineIdx);
						if (!f.equals("")) { // Do not add "" to the jsonQueue..
							TinygDriver.getInstance().appendJsonQueue(f);
						}
						lineIdx = 0;
					} else {
						lineBuffer[lineIdx++] = tmpBuffer[i];
					}
				}
			} catch (SerialPortException | SerialPortTimeoutException ex) {
				logger.error("Error reading serial port", ex);
			}
		}
	}

	public static String[] listSerialPorts() {
		String[] ports = jssc.SerialPortList.getPortNames();
		ArrayList<String> portList = new ArrayList<String>();

		for (String port : ports) {
			SerialPort _tmpPort = new SerialPort(port);
			if (!_tmpPort.getPortName().contains("Bluetooth")) {

			}
			// Go ahead and add the ports that made it though the logic above
			portList.add(_tmpPort.getPortName()); 
		}

		String portArray[] = (String[]) portList.toArray(new String[0]);
		return portArray;
	}

	public boolean initialize(String port, int DATA_RATE)
			throws SerialPortException {

		if (isConnected()) {
			String returnMsg = "[*] Port Already Connected.\n";
			logger.info(returnMsg);
			return (true);
		}
	
		// set port parameters
		serialPort = new SerialPort(port);
		serialPort.openPort();
		serialPort.setParams(DATA_RATE, SerialPort.DATABITS_8,
				SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		// open the streams
		// input = serialPort.getInputBufferBytesCount;
		// output = serialPort.getOutputStream();
		serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN
				| SerialPort.FLOWCONTROL_RTSCTS_OUT);
		serialPort.setRTS(true);

		// add event listeners
		serialPort.addEventListener(this);
		// serialPort.addEventListener(this);notifyOnDataAvailable(true);

		logger.debug("[+]Opened " + port + " successfully.");
		setConnected(true); // Register that this is connectionState.

		return true;
	}

	/**
	 * singleton helper class.
	 */
	private static class SerialDriverHolder {
		private static final SerialDriver INSTANCE = new SerialDriver();
	}
}
