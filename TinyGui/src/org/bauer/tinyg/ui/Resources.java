package org.bauer.tinyg.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class Resources {
	private static Font largeBold;
	private static Color fontForeground;
	private static Color buttonForeground;
	
	public static Font LargeBold() {
		return largeBold;
	}
	
	public static Color fontForeground() {
		return fontForeground;
	}
	
	public static Color buttonForeground() {
		return buttonForeground;
	}
	
	public static void init(Display d) {
		fontForeground = d.getSystemColor(SWT.COLOR_WHITE);
		buttonForeground = d.getSystemColor(SWT.COLOR_GRAY);
				
		// Create Fonts
		FontData largeData = new FontData("Calibri", 22, SWT.NORMAL);
		largeBold = new Font(d, largeData); 
	}
}
