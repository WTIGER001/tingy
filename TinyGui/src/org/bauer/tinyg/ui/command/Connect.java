package org.bauer.tinyg.ui.command;

import org.bauer.tingy.TinyG;
import org.eclipse.swt.widgets.Event;

public class Connect implements ICommand {

	public Connect() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Commands getCommand() {
		return Commands.Connect;
	}
	
	@Override
	public void run(String data, Event e) {
		TinyG.instance().connect(data);
	}
}
