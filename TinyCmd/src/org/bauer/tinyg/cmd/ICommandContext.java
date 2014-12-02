package org.bauer.tinyg.cmd;

import java.io.PrintStream;

public interface ICommandContext {
	public PrintStream getOutputStream();
	
	public void getInputStream();
	
}
