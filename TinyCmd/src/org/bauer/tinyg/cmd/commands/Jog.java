package org.bauer.tinyg.cmd.commands;

import java.io.IOException;

import org.bauer.tingy.TinyG;
import org.bauer.tinyg.cmd.ICommand;
import org.bauer.tinyg.cmd.ICommandContext;
import org.bauer.tinyg.cmd.InvalidCommandException;

public class Jog implements ICommand{

	@Override
	public String getTrigger() {
		return "jog";
	}

	@Override
	public String getDescription() {
		return "Enter Jog Mode - Use the Arrows and pgup / pg down to control the axis";
	}
	
	@Override
	public void exec(String[] args, ICommandContext context) throws InvalidCommandException {
		if (TinyG.instance().getConnectedPort() != null) {
			throw new InvalidCommandException("Must be connected to a TinyG Serial Port");
		}
		
		while (true) {
			int code;
			try {
				code = System.in.read();
			} catch (IOException e) {
				throw new InvalidCommandException(e);
			}
			System.out.println("CODE : " + code);
			if (code == 27 || code == 113 || code == 81) {
				return;
			}
		}
		
	}
 
}
