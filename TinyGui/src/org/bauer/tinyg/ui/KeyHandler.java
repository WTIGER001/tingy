package org.bauer.tinyg.ui;

import org.bauer.tinyg.ui.command.CommandService;
import org.bauer.tinyg.ui.command.Commands;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class KeyHandler {

	public KeyHandler(Display d) {
		
		d.addFilter(SWT.KeyDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				// Find the command
				Commands cmd = Commands.find(event.keyCode, event.stateMask);
				
				if (cmd != null) {
					CommandService.instance().runCommand(cmd, null,  event);
				}
			}
		});
		d.addFilter(SWT.KeyUp, new Listener() {
			@Override
			public void handleEvent(Event event) {
				
			}
		});
		
	}
	

}
