package org.bauer.tinyg.ui.components;

import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.graphics.Images2;
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
		composite.setLayout(new GridLayout(1, false));
		
//		ImageButton btnReset = new ImageButton(composite, SWT.NULL);
//		btnReset.setImage(Images2.replay.getxxHdpi());
//		btnReset.setHoverImage(Images2.accept.getxxHdpi());
//		
//		ImageButton btnPlay = new ImageButton(composite, SWT.NULL);
//		btnPlay.setImage(Images2.play.getxxHdpi());
//		btnPlay.setHoverImage(Images2.accept.getxxHdpi());
//		
//		ImageButton btnPause = new ImageButton(composite, SWT.NULL);
//		btnPause.setImage(Images2.pause.getxxHdpi());
//		btnPause.setHoverImage(Images2.accept.getxxHdpi());
//		
//		ImageButton btnStop = new ImageButton(composite, SWT.NULL);
//		btnStop.setImage(Images2.stop.getxxHdpi());
//		btnStop.setHoverImage(Images2.accept.getxxHdpi());
		
		ImageButton btnStop = new ImageButton(composite, SWT.NULL);
		btnStop.setToolTipText("Emergency Stop");
		btnStop.setImage(Images2.error.getxxHdpi());
		btnStop.setScale(2.0f);
		btnStop.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, false, false));
		
		Label l = new Label(composite, SWT.NULL);
		l.setFont(Resources.mediumFont());
		l.setForeground(Resources.fontForeground());
		l.setText("Emergency Stop!");
		l.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, false, false));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
