package org.bauer.tinyg.cmd;

public interface ICommand {
	public String getTrigger();

	public void exec(String[] args, ICommandContext context) throws InvalidCommandException;

	public String getDescription();
}
