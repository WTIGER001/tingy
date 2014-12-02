package org.bauer.tinyg.ui.components;

import java.util.ArrayList;
import java.util.List;

import org.bauer.tinyg.ui.Resources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Main Panel for the controls. T
 */
public class MainPanel extends Composite {
	private int selection = 0;
	private StackLayout stack;
	private int tabPadding = 6;
	private List<String> labels = new ArrayList<>();
	
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainPanel(Composite parent, int style) {
		super(parent, style);
		
		setLayout(new GridLayout(1, true));
		
		// Buttons at top
		Buttons buttonBar = new Buttons(this, SWT.NULL);
		buttonBar.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		
		// Android Style Tabs
		TabStrip tabs = new TabStrip(this, SWT.NULL);
		tabs.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		tabs.setFont(Resources.LargeBold());
		tabs.setForeground(Resources.fontForeground());
		tabs.setTabs("Jog", "G Code");
		
		// Tab area
		Composite tabArea = new Composite(this, SWT.NULL);
		tabArea.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, false, false));
		StackLayout tabStack = new StackLayout();
		tabArea.setLayout(tabStack);
		
		// Jog Tab
		JogComposite jog = new JogComposite(tabArea, SWT.NULL);
		tabStack.topControl = jog;
		
		// Gcode Tab
		
		
		// Control Area
		Controls controls = new Controls(this, SWT.NULL);
		controls.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, false, false));
		
	}
	
	/**
	 * Creates the buttons
	 * @param parent
	 */
	private void createButtons(Composite parent) {
		
		
		
		
	}
	
	public void addTab(String label, Composite contents) {
		
	}
	
	@Override
	public void setFont(Font font) {
		super.setFont(font);
		updateMetrics();
	}
	
	
	
	
	private void updateMetrics() {
		
	}

	@Override
	protected void checkSubclass() {
		
	}

}
