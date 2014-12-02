package org.bauer.tinyg.cmd;

import java.io.PrintStream;


public class CommandContext implements ICommandContext{

	@Override
	public PrintStream getOutputStream() {
		return System.out;
	}

	@Override
	public void getInputStream() {
		
	}
	
}
