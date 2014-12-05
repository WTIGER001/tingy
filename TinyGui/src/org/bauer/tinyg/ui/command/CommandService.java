package org.bauer.tinyg.ui.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.eclipse.swt.widgets.Event;

public class CommandService extends Observable{
	private Map<Commands, ICommand> commandMap = new HashMap<Commands, ICommand>();
	public CommandService() {
		add(new JogXDecrement());
		add(new Connect());
	}
	
	private void add(ICommand cmd) {
		commandMap.put(cmd.getCommand(), cmd);
	}
	
	public void runCommand(Commands cmd, String data, Event e) {
		// Get the implementation
		ICommand cmdImpl = commandMap.get(cmd);
		
		if (cmdImpl == null) {
			throw new IllegalArgumentException("No Command Implementation for " + cmd.getLabel() + " exists");
		}
		
		notifyObservers( new CommandEvent(0, cmd, data));
		cmdImpl.run(data, e);
		notifyObservers( new CommandEvent(1, cmd, data));
	}
	
	public static CommandService instance() {
		return CommandServiceHolder.INSTANCE;
	}
	
	private static class CommandServiceHolder {
		private static final CommandService INSTANCE = new CommandService();
	}
	
}
