package org.bauer.tinyg.ui.components;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;

public class Buttons extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Buttons(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(3, false));
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setImage(SWTResourceManager.getImage("C:\\Users\\John\\git\\tingy\\TinyGui\\src\\org\\bauer\\tinyg\\ui\\graphics\\holo_dark\\09_media_download\\drawable-xhdpi\\ic_action_download.png"));
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setImage(SWTResourceManager.getImage("C:\\Users\\John\\git\\tingy\\TinyGui\\src\\org\\bauer\\tinyg\\ui\\graphics\\holo_dark\\13_extra_actions_settings\\drawable-xhdpi\\ic_action_settings.png"));
		
		Label label = new Label(composite, SWT.NONE);
		label.setImage(SWTResourceManager.getImage("C:\\Users\\John\\git\\tingy\\TinyGui\\src\\org\\bauer\\tinyg\\ui\\graphics\\holo_dark\\01_core_overflow\\drawable-xhdpi\\ic_action_overflow.png"));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
