package org.bauer.tingy;



public class TinyG {
	
	private static SerialDriver serialDriver = SerialDriver.getInstance();
	
	private static TinygDriver tg = TinygDriver.getInstance();
	
	public static void init() {
		Thread serialWriterThread = new Thread(tg.serialWriter);
		serialWriterThread.setName("Serial Writer");
		serialWriterThread.setDaemon(true);
		serialWriterThread.start();
		
		Thread threadResponseParser = new Thread(tg.resParse);
		threadResponseParser.setDaemon(true);
		threadResponseParser.setName("Response Parser");
		threadResponseParser.start();
	}
	
	public static String[] listPorts() {
		return SerialDriver.listSerialPorts();
	}
	
	public static boolean connect(String port) throws Exception {
		return serialDriver.initialize(port, 115200);
	}
	
	public static void disconnect() throws Exception {
		serialDriver.disconnect();
	}
	
	public static void sendCmd(String cmd) throws Exception  {
		serialDriver.write(cmd);
	}

	public static String getPort() {
		return "TODO";
	}

	public static boolean isConnected() {
		return true;
	}
	
	
}
