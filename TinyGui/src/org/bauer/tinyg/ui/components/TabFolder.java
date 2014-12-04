package org.bauer.tinyg.ui.components;

import org.bauer.tinyg.ui.Resources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class TabFolder extends Composite {
	String[] tabs;
	private TabStrip tabstrip;
	private Composite tabArea;
	private StackLayout tabStack;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TabFolder(Composite parent, int style) {
		super(parent, style);
		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		setLayout(layout);
		
		tabstrip = new TabStrip(this, SWT.NULL);
		tabstrip.setFont(Resources.LargeBold());
		tabstrip.setForeground(Resources.fontForeground());
		tabstrip.setTabs("Machine", "Motors", "Axis");
		tabstrip.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		tabArea = new Composite(this, SWT.NULL);
		tabArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	
		tabStack = new StackLayout();
		tabArea.setLayout(tabStack);
		
		tabstrip.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				int tab = tabstrip.getSelection();
				if (tab != -1) {
					Control[] children = tabArea.getChildren();
					tabStack.topControl = tabArea.getChildren()[tab];
					tabArea.layout();
				}
			}	
		});
		
	}

	public Composite getTabParent() {
		return tabArea;
	}
	
	public void setTabs(String ... tabs) {
		this.tabs = tabs;
		this.tabstrip.setTabs(tabs);
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void select(int tab) {
		if (tab != -1) {
			tabStack.topControl = tabArea.getChildren()[tab];
			tabArea.layout();
		}
	}

}
