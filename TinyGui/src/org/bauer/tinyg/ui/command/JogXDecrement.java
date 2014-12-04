package org.bauer.tinyg.ui.command;

import org.eclipse.swt.widgets.Event;

public class JogXDecrement implements ICommand {

	public JogXDecrement() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Commands getCommand() {
		return Commands.JogXDecrement;
	}
	
	@Override
	public void run(Event e) {
		System.out.println("JOG ");
	}

}
