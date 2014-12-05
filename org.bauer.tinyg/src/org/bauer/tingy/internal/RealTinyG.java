package org.bauer.tingy.internal;

import org.bauer.tingy.ITinyG;
import org.bauer.tingy.ITinyGActionListener;
import org.bauer.tingy.TinyGAction;

public class RealTinyG implements ITinyG {
	private SerialDriver serialDriver = SerialDriver.getInstance();

	private TinygDriver tg = TinygDriver.getInstance();

	public void init() {
		Thread serialWriterThread = new Thread(tg.serialWriter);
		serialWriterThread.setName("Serial Writer");
		serialWriterThread.setDaemon(true);
		serialWriterThread.start();

		Thread threadResponseParser = new Thread(tg.resParse);
		threadResponseParser.setDaemon(true);
		threadResponseParser.setName("Response Parser");
		threadResponseParser.start();
	}

	@Override
	public String[] getPorts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(String serialPortName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getConnectedPort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String runReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(ITinyGActionListener listener,
			TinyGAction... actions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(ITinyGActionListener listener) {
		// TODO Auto-generated method stub
		
	}

}
