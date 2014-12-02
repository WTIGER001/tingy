package org.bauer.tinyg.cmd.commands;

import java.io.PrintStream;



import org.bauer.tingy.TinyG;
import org.bauer.tinyg.cmd.ICommand;
import org.bauer.tinyg.cmd.ICommandContext;
import org.bauer.tinyg.cmd.InvalidCommandException;

public class Disconnect implements ICommand{

	@Override
	public String getTrigger() {
		return "disconnect";
	}

	@Override
	public String getDescription() {
		return "Disconnect from the current port";
	}
	
	@Override
	public void exec(String[] args, ICommandContext context) throws InvalidCommandException {
		
		PrintStream out = context.getOutputStream();
		try {
			String port = TinyG.getPort();
			TinyG.disconnect();
			out.println(">>> Disconnected from " + port);
			out.flush();
		} catch (Exception e) {
			throw new InvalidCommandException(e.getMessage());
		}
	}
 
}
