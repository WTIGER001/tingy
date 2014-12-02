package org.bauer.tinyg.cmd.commands;

import java.util.TreeSet;

import org.bauer.tinyg.cmd.Commands;
import org.bauer.tinyg.cmd.ICommand;
import org.bauer.tinyg.cmd.ICommandContext;
import org.bauer.tinyg.cmd.InvalidCommandException;

public class Help implements ICommand{

	@Override
	public String getTrigger() {
		return "help";
	}
	
	@Override
	public String getDescription() {
		return "Print Help";
	}

	@Override
	public void exec(String[] args, ICommandContext context) throws InvalidCommandException {
		Commands cmds = new Commands();
		
		TreeSet<String> cmdsTriggers = new TreeSet<>();
		cmdsTriggers.addAll(cmds.getCommands().keySet());
		
		int max = 0;
		for (String cmdTrigger : cmdsTriggers) {
			max = Math.max(max, cmdTrigger.length());
		}
		context.getOutputStream().println("The available commands are:");
		for (String cmdTrigger : cmdsTriggers) {
			ICommand cmd = cmds.get(cmdTrigger);
			context.getOutputStream().printf("%-"+max+"s : %s\n", cmdTrigger, cmd.getDescription());
		}
		context.getOutputStream().flush();
	}
 
}
