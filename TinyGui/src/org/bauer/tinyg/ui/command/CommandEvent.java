package org.bauer.tinyg.ui.command;

public class CommandEvent {
	public CommandEvent(int state, Commands cmd) {
		this.state = state;
		this.cmd = cmd;
	}
	public final int state; // Before 
	public final Commands cmd;
}
