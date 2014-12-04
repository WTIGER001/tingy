package org.bauer.tinyg.ui.command;

import org.eclipse.swt.SWT;

public enum Commands {
	Exit("Exit", 'q', "Exit"),
	JogXDecrement("Jog X - Down", SWT.ARROW_DOWN, "Jogs the X axis down by the current increment"),
		
	
	
	;
	String label;
	int triggerKey;
	String helpText;
	
	private Commands(String label, int triggerKey, String helpText) {
		this.label = label;
		this.triggerKey = triggerKey;
		this.helpText = helpText;
	}

	public String getHelpText() {
		return helpText;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int getTriggerKey() {
		return triggerKey;
	}
	
	public static Commands find(int keyCode, int statemask) {
		for (Commands c : Commands.values())  {
			if (c.getTriggerKey() == keyCode) {
				return c;
			}
		}
		return null;
	}
	
}
