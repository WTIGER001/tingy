package org.bauer.tinyg.ui.pages;

import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.components.JogComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Main Panel for the controls. T
 */
public class JogPage extends Composite {
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public JogPage(Composite parent, int style) {
		super(parent, style);
		
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 15;
		layout.marginBottom = 15;
		
		setLayout(layout);
		
	
		Label lJog = Resources.createLabel(this, "Axis Controls");
		Label lGCode = Resources.createLabel(this, "X-Y Area Display");
		
		
		// Jog Tab
		final JogComposite jog = new JogComposite(this, SWT.NULL);
		jog.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		
		// Gcode Tab
		Canvas area = new Canvas(this, SWT.BORDER);
		area.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
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
