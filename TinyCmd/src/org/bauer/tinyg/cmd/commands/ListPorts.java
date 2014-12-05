package org.bauer.tinyg.cmd.commands;

import java.io.PrintStream;

import org.bauer.tingy.TinyG;
import org.bauer.tinyg.cmd.ICommand;
import org.bauer.tinyg.cmd.ICommandContext;
import org.bauer.tinyg.cmd.InvalidCommandException;

public class ListPorts implements ICommand{

	@Override
	public String getTrigger() {
		return "list";
	}

	@Override
	public String getDescription() {
		return "List the available ports";
	}
	
	@Override
	public void exec(String[] args, ICommandContext context) throws InvalidCommandException {
		if (args.length > 1) {
			throw new InvalidCommandException("No arguments are supported");
		}
		
		PrintStream out = context.getOutputStream();
		String[] ports = TinyG.instance().getPorts();
		
		if (ports.length == 0 ) {
			out.println("There are no available Serial ports... Please see TinyG documentation to fix this");
		} else {
			out.println("Available Ports:");
			for (int i=0;i<ports.length;i++) { 
				out.println(ports[i]);
			}
		}
		out.flush();
	}
 
}
