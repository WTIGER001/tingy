package org.bauer.tingy.mock;

import java.util.Collection;

import org.bauer.tingy.ITinyG;
import org.bauer.tingy.ITinyGActionListener;
import org.bauer.tingy.TinyGAction;
import org.bauer.tingy.TinyGException;
import org.bauer.tingy.internal.util.ListenerMap;

public class MockTinyG implements ITinyG {
	private ListenerMap<ITinyGActionListener, TinyGAction> listeners = new ListenerMap<ITinyGActionListener, TinyGAction>();
	private String port;

	public MockTinyG() {
	}

	@Override
	public void init() {
		addListener(new ITinyGActionListener() {
			@Override
			public void actionPerformed(TinyGAction action, Object data) {
				System.out.println("ACTION: " + action.name() + " \t " + data);
			}
		}, TinyGAction.values());
	}

	@Override
	public String[] getPorts() {
		String[] ports = new String[] { "COM3", "MOCK 1"};
		notifyListeners(TinyGAction.ListPorts, null);
		return ports; 
	}

	@Override
	public void connect(String serialPortName) {
		if (this.port != null) {
			throw new TinyGException("Already connected to port " + port);
		}
		notifyListeners(TinyGAction.Connect, port);
		this.port = serialPortName;
	}

	@Override
	public void disconnect() {
		notifyListeners(TinyGAction.Disconnect, port);
		this.port = null;
	}

	@Override
	public String getConnectedPort() {
		return port;
	}

	@Override
	public String runReport() {
		notifyListeners(TinyGAction.RunReport, null);
		// TODO Auto-generated method stub
		return "GET SOME GOOD REPORT MOCKS";
	}

	private void notifyListeners(TinyGAction action, String data) {
		Collection<ITinyGActionListener> localListeners = listeners.getListeners(action);
		for (ITinyGActionListener l : localListeners) {
			l.actionPerformed(action, data);
		}
	}

	@Override
	public void addListener(ITinyGActionListener listener, TinyGAction... actions) {
		listeners.add(listener, actions);
	}

	@Override
	public void removeListener(ITinyGActionListener listener) {
		listeners.remove(listener);
	}
}
