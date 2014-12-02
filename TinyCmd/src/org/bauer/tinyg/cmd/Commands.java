package org.bauer.tinyg.cmd;

import java.util.HashMap;
import java.util.Map;

import org.bauer.tinyg.cmd.commands.Connect;
import org.bauer.tinyg.cmd.commands.Disconnect;
import org.bauer.tinyg.cmd.commands.ExitCommand;
import org.bauer.tinyg.cmd.commands.Help;
import org.bauer.tinyg.cmd.commands.Jog;
import org.bauer.tinyg.cmd.commands.ListPorts;

public class Commands {
	private Map<String, ICommand> commands = new HashMap<>();
	
	public Commands() {
		add(new ExitCommand());
		add(new ListPorts());
		add(new Help());
		add(new Connect());
		add(new Disconnect());
		add(new Jog());
	}
	
	public void add(ICommand cmd) {
		commands.put(cmd.getTrigger().toLowerCase(), cmd);
	}
	
	public Map<String, ICommand> getCommands() {
		return commands;
	}
	
	public void execCommand(String commandLine, ICommandContext ctx) throws InvalidCommandException {
		if (commandLine.trim().equals("")) {
			return;
		}
		
		// Split the arguments
		String[] args = commandLine.split(" ");
		
		// The first part of the command line is the trigger
		String trigger = args[0].toLowerCase();
		
		ICommand cmd = commands.get(trigger);
		if (cmd == null) {
			throw new InvalidCommandException("No command : " + trigger);
		} 
		
		cmd.exec(args, ctx);
	}

	public ICommand get(String trigger) {
		return commands.get(trigger.toLowerCase());
	}
}
