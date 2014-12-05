package org.bauer.tinyg.ui.command;

import org.eclipse.swt.widgets.Event;

public interface ICommand {
	public Commands getCommand();
	public void run(String data, Event e);
}
