package org.bauer.tinyg.ui.components;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;

public class Controls extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Controls(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(4, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage("C:\\Users\\John\\git\\tingy\\TinyGui\\src\\org\\bauer\\tinyg\\ui\\graphics\\holo_dark\\09_media_replay\\drawable-xxhdpi\\ic_action_replay.png"));
		lblNewLabel.setBounds(0, 0, 55, 15);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setImage(SWTResourceManager.getImage("C:\\Users\\John\\git\\tingy\\TinyGui\\src\\org\\bauer\\tinyg\\ui\\graphics\\holo_dark\\09_media_play\\drawable-xxhdpi\\ic_action_play.png"));
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setImage(SWTResourceManager.getImage("C:\\Users\\John\\git\\tingy\\TinyGui\\src\\org\\bauer\\tinyg\\ui\\graphics\\holo_dark\\09_media_pause\\drawable-xxhdpi\\ic_action_pause.png"));
		
		Label label = new Label(composite, SWT.NONE);
		label.setImage(SWTResourceManager.getImage("C:\\Users\\John\\git\\tingy\\TinyGui\\src\\org\\bauer\\tinyg\\ui\\graphics\\holo_dark\\09_media_stop\\drawable-xxhdpi\\ic_action_stop.png"));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
