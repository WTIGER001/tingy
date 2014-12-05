package org.bauer.tinyg.ui.command;

public class CommandEvent {
	public CommandEvent(int state, Commands cmd, String data) {
		this.state = state;
		this.cmd = cmd;
		this.data = data;
	}
	public final int state; // Before 
	public final Commands cmd;
	public final String data;
}
