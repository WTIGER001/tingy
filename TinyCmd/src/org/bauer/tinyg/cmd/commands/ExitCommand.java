package org.bauer.tinyg.cmd.commands;

import org.bauer.tinyg.cmd.ICommand;
import org.bauer.tinyg.cmd.ICommandContext;
import org.bauer.tinyg.cmd.InvalidCommandException;

public class ExitCommand implements ICommand{

	@Override
	public String getTrigger() {
		return "exit";
	}

	@Override
	public String getDescription() {
		return "Quit and shutdown the TinyG";
	}
	
	@Override
	public void exec(String[] args, ICommandContext context) throws InvalidCommandException {
		context.getOutputStream().println("Goodbye!");
		System.exit(0);
	}
 
}
