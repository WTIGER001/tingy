package org.bauer.tinyg.ui.components;

import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.graphics.Images;
import org.bauer.tinyg.ui.graphics.Images2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


/**
 * Controls a single linear axis
 */
public class LinearJog extends Composite {

	private Label axisLabel;
	private ImageButton decrement;
	private Label valueLabel;
	private ImageButton increment;
	private String axis;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public LinearJog(Composite parent, int style) {
		super(parent, style);
		
		GridLayout layout = new GridLayout(5, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		setLayout(layout);
			
		// Label
		axisLabel = new Label(this, SWT.NULL);
		axisLabel.setFont(Resources.LargeBold());
		axisLabel.setForeground(Resources.fontForeground());
		axisLabel.setText("              ");
		
		Label spacer = new Label(this, SWT.NULL);
		spacer.setText("              ");
		
		// Decrement
		decrement = new ImageButton(this, SWT.NULL);
		decrement.setImage(Images2.rewind.getxxHdpi());
		
		// Current Value
		valueLabel = new Label(this, SWT.BORDER);
		valueLabel.setFont(Resources.LargeBold());
		valueLabel.setForeground(Resources.fontForeground());
		valueLabel.setText("                  ");
		valueLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		//Increment
		increment = new ImageButton(this, SWT.NULL);
		increment.setImage(Images2.fast_forward.getxxHdpi());
		
	}
	
	public void setAxis(String axis) {
		this.axis = axis;
		
		axisLabel.setText(axis);
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
