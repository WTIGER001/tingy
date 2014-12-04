package org.bauer.tinyg.ui.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.eclipse.swt.widgets.Event;

public class CommandService extends Observable{
	private Map<Commands, ICommand> commandMap = new HashMap<Commands, ICommand>();
	public CommandService() {
		add(new JogXDecrement());
	}
	
	private void add(ICommand cmd) {
		commandMap.put(cmd.getCommand(), cmd);
	}
	
	public void runCommand(Commands cmd, Event e) {
		// Get the implementation
		ICommand cmdImpl = commandMap.get(cmd);
		
		if (cmdImpl == null) {
			throw new IllegalArgumentException("No Command Implementation for " + cmd.getLabel() + " exists");
		}
		
		notifyObservers( new CommandEvent(0, cmd));
		cmdImpl.run(e);
		notifyObservers( new CommandEvent(1, cmd));
	}
	
	public static CommandService instance() {
		return CommandServiceHolder.INSTANCE;
	}
	
	private static class CommandServiceHolder {
		private static final CommandService INSTANCE = new CommandService();
	}
	
}
