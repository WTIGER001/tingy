package org.bauer.tingy;

import com.sun.istack.internal.NotNull;

/**
 * Public interface to the Tiny G. This interface is used to abstract all the
 * particulars of calling the TinyG and interacting. Also this interface allows
 * for alternate implementations in cases such as unit testing
 */
public interface ITinyG {
	
	public void init();

	public void addListener(ITinyGActionListener listener, TinyGAction ... actions);
	
	public void removeListener(ITinyGActionListener listener);
	
	/**
	 * Get the available serial ports. The user is expected to know which one of
	 * these ports is connected to a TinyG
	 * 
	 * @return Array of the ports found. An empty array is passed when there are
	 *         no ports found
	 */
	public String[] getPorts();

	/**
	 * Connects the TinyG to the named serial port (that should have been
	 * retrieved using {@link #getPorts()}.
	 * 
	 * @param serialPortName
	 * 
	 * @throws TinyGException
	 *             When there is a connection error. Often this will be trigger
	 *             by calling connect when there is already an active connection.
	 */
	public void connect(String serialPortName);
	
	/**
	 * Disconnects from the current connection.
	 */
	public void disconnect();
	
	/**
	 * Returns the port that we are currently connected to
	 * 
	 * @return The port name or null if there is no connection
	 */
	public String getConnectedPort();
	
	/**
	 * Runs a status report
	 * @return The report, formatted in JSON
	 */
	public String runReport();

	
}
