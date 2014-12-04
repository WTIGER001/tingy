package org.bauer.tinyg.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Resources {
	private static Font title;
	private static Font largeBold;
	private static Font medium;
	private static Color fontForeground;
	private static Color buttonForeground;
	private static Color selectionBackground;
	
	public static Font LargeBold() {
		return largeBold;
	}
	
	public static Font title() {
		return title;
	}
	
	
	public static Color fontForeground() {
		return fontForeground;
	}
	
	public static Color buttonForeground() {
		return buttonForeground;
	}
	
	public static Font mediumFont() {
		return medium;
	}
	
	public static Color selectionBackground() {
		return selectionBackground;
	}
	
	public static void init(Display d) {
		fontForeground = d.getSystemColor(SWT.COLOR_WHITE);
		buttonForeground = d.getSystemColor(SWT.COLOR_GRAY);
		selectionBackground = new Color(d, 36, 36, 36);
				
		// Create Fonts
		FontData largeData = new FontData("Calibri", 22, SWT.NORMAL);
		largeBold = new Font(d, largeData); 
		
		FontData titleData = new FontData("Calibri", 32, SWT.NORMAL);
		title = new Font(d, titleData); 
		
		FontData mediumData = new FontData("Calibri", 16, SWT.NORMAL);
		medium = new Font(d, mediumData); 
	}
	
	public static Label createLabel(Composite parent, String text) {
		Label l = new Label(parent, SWT.NULL);
		l.setFont(largeBold);
		l.setForeground(fontForeground);
		l.setText(text);
		return l;
	}

	public static Label mLabel(Composite parent, String text) {
		Label l = new Label(parent, SWT.NULL);
		l.setFont(medium);
		l.setForeground(fontForeground);
		l.setText(text);
		return l;
	}

	public static CCombo mCcombo(Composite parent, int selection, String ... options) {
		CCombo cmb = new CCombo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		cmb.setItems(options);
		cmb.select(selection);
		cmb.setFont(medium);
		cmb.setBackground(Resources.selectionBackground());
		cmb.setForeground(Resources.fontForeground());
		return cmb;
	}

	public static Text mText(Composite parent, String text) {
		Text l = new Text(parent, SWT.BORDER);
		l.setFont(medium);
		l.setForeground(fontForeground);
		l.setText(text);
		return l;
	}
	
	public static Label lLabel(Composite parent, String text) {
		Label l = new Label(parent, SWT.NULL);
		l.setFont(largeBold);
		l.setForeground(fontForeground);
		l.setText(text);
		return l;
	}

	public static CCombo lCcombo(Composite parent, int selection, String ... options) {
		CCombo cmb = new CCombo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		cmb.setItems(options);
		cmb.select(selection);
		cmb.setFont(Resources.LargeBold());
		cmb.setBackground(Resources.selectionBackground());
		cmb.setForeground(Resources.fontForeground());
		return cmb;
	}

	public static Text lText(Composite parent, String text) {
		Text l = new Text(parent, SWT.BORDER);
		l.setFont(largeBold);
		l.setForeground(fontForeground);
		l.setText(text);
		return l;
	}
}
