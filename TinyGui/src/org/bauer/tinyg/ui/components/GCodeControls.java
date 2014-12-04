package org.bauer.tinyg.ui.components;

import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.graphics.Images2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class GCodeControls extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GCodeControls(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));
		
		Composite left = new Composite(composite, SWT.NULL);
		left.setLayout(new GridLayout(1, false));
		left.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		
		Composite right = new Composite(composite, SWT.NULL);
		right.setLayout(new GridLayout(1, false));
		right.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		
		ImageButton btnPlay = new ImageButton(left, SWT.NULL);
		btnPlay.setImage(Images2.play.getxxHdpi());
		btnPlay.setToolTipText("Run GCode");
		
		ImageButton btnPause = new ImageButton(left, SWT.NULL);
		btnPause.setImage(Images2.pause.getxxHdpi());
		btnPause.setToolTipText("Pause Exectuion of GCode");
		
		ImageButton btnStop = new ImageButton(right, SWT.NULL);
		btnStop.setToolTipText("Emergency Stop");
		btnStop.setImage(Images2.error.getxxHdpi());
		btnStop.setScale(2.0f);
		btnStop.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, false, false));
		
		Label l = new Label(right, SWT.NULL);
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
