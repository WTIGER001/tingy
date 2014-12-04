package org.bauer.tinyg.ui.components;

import org.bauer.tinyg.ui.Resources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class JogComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public JogComposite(Composite parent, int style) {
		super(parent, style);
		
		setLayout(new GridLayout(1,  false));
		
		// JOG Controls
		Composite jogControls = new Composite(this, SWT.NULL);
		jogControls.setLayout(new GridLayout(1, true));
		jogControls.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		LinearJog xJog = new LinearJog(jogControls, SWT.NULL);
		xJog.setAxis("X");
		
		LinearJog yJog = new LinearJog(jogControls, SWT.NULL);
		yJog.setAxis("Y");
		
		LinearJog zJog = new LinearJog(jogControls, SWT.NULL);
		zJog.setAxis("Z");

		
		// Buttons
		Composite buttonArea = new Composite(this, SWT.NULL);
		buttonArea.setLayout(new GridLayout(3,  true));
		buttonArea.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		PrettyButton btnZero = new PrettyButton(buttonArea, SWT.NULL);
		btnZero.setFont(Resources.LargeBold());
		btnZero.setText("Zero All");
		btnZero.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		PrettyButton btnHome = new PrettyButton(buttonArea, SWT.NULL);
		btnHome.setFont(Resources.LargeBold());
		btnHome.setText("Home");
		btnHome.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
	
		PrettyButton btnSeek = new PrettyButton(buttonArea, SWT.NULL);
		btnSeek.setFont(Resources.LargeBold());
		btnSeek.setText("Seek");
		btnSeek.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		// Settings
		Composite settingsArea = new Composite(this, SWT.NULL);
		settingsArea.setLayout(new GridLayout(2,  false));
		settingsArea.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label lSteps = Resources.createLabel(settingsArea, "Steps per Increment   ");
		lSteps.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		
		CCombo cmbSteps = new CCombo(settingsArea, SWT.DROP_DOWN | SWT.READ_ONLY);
		cmbSteps.setItems(new String[] {"1", "10", "50", "100", "250", "500"});
		cmbSteps.select(1);
		cmbSteps.setFont(Resources.LargeBold());
		cmbSteps.setBackground(Resources.selectionBackground());
		cmbSteps.setForeground(Resources.fontForeground());
		cmbSteps.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		Label lStepMode = Resources.createLabel(settingsArea, "Step Mode");
		lStepMode.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		
		CCombo cmbStepMode = new CCombo(settingsArea, SWT.DROP_DOWN | SWT.READ_ONLY);
		cmbStepMode.setItems(new String[] {"Absolute", "Relative"});
		cmbStepMode.select(0);
		cmbStepMode.setFont(Resources.LargeBold());
		cmbStepMode.setBackground(Resources.selectionBackground());
		cmbStepMode.setForeground(Resources.fontForeground());
		cmbStepMode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Controls controls = new Controls(this, SWT.NULL);
		controls.setLayoutData(new GridData(SWT.CENTER, SWT.BOTTOM, false, true));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
