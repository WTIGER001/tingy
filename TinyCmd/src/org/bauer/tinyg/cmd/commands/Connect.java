package org.bauer.tinyg.cmd.commands;

import java.io.PrintStream;

import org.bauer.tingy.TinyG;
import org.bauer.tinyg.cmd.ICommand;
import org.bauer.tinyg.cmd.ICommandContext;
import org.bauer.tinyg.cmd.InvalidCommandException;

public class Connect implements ICommand{

	@Override
	public String getTrigger() {
		return "connect";
	}

	@Override
	public String getDescription() {
		return "Connect to the provided Serial Port";
	}
	
	@Override
	public void exec(String[] args, ICommandContext context) throws InvalidCommandException {
		if (args.length != 2) {
			throw new InvalidCommandException("Expecting a single port");
		}
		PrintStream out = context.getOutputStream();
		String port = args[1];
		try {
			TinyG.instance().connect(port);
			out.println(">>> Connected to " + port);
			out.flush();
		} catch (Exception e) {
			throw new InvalidCommandException(e.getMessage());
		}
	}
 
}
