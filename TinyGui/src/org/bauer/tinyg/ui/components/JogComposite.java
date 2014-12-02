package org.bauer.tinyg.ui.components;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class JogComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public JogComposite(Composite parent, int style) {
		super(parent, style);
		
		Label lblJog = new Label(this, SWT.NONE);
		lblJog.setBounds(215, 132, 55, 15);
		lblJog.setText("JOG");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
