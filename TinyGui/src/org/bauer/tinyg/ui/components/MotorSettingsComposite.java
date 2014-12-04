package org.bauer.tinyg.ui.components;

import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.graphics.Images;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MotorSettingsComposite extends Composite {

	private Control cmbMapping;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MotorSettingsComposite(Composite parent, int style) {
		super(parent, style);

		setBackgroundImage(Images.BG2.getImage());
		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 25;
		setLayout(layout);
		
		// Axis Mapping
		Label lMapping = Resources.lLabel(this, "Mapped to Axis");
		lMapping.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		CCombo cmbMapping = Resources.lCcombo(this, 0, "X", "Y", "Z", "A", "B", "C");
		cmbMapping.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		
		// MicroSteps
		Label lMicrosteps = Resources.lLabel(this, "Microsteps");
		lMicrosteps.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		CCombo cmbMicrosteps = Resources.lCcombo(this, 0, "1", "2", "4", "8");
		cmbMicrosteps.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		
		// Polarity
		Label lPolarity = Resources.lLabel(this, "Polarity");
		lPolarity.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		CCombo cmbPolarity= Resources.lCcombo(this, 0, "0=clockwise", "1=counterclockwise");
		cmbPolarity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// Power Management
		Label lPower = Resources.lLabel(this, "Power Management");
		lPower.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		CCombo cmbPower = Resources.lCcombo(this, 0, "0=motor disabled", "1=motor always on", "2=motor on when in cycle", "3=motor on when moving");
		cmbPower.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// Step Angle
		Label lAngle = Resources.lLabel(this, "Step Angles");
		lAngle.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtAngle = Resources.lText(this, "");
		txtAngle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// Travel per Rev
		Label lTravel = Resources.lLabel(this, "Travel per revolution");
		lTravel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtTravel = Resources.lText(this, "");
		txtTravel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

/*
etting	Description	Notes
$1ma	Motor mapping to axis	Configures the axis to which this motor is connected (for Cartesian machines) Typically: $1ma=0, $2ma=1, $3ma=2, $4ma=3 to map motors 1-4 to X,Y,Z,A, respectively
$1sa	Step angle	Motor parameter indicating the angle traveled per whole step. Typical setting is $1sa=1.8 for 1.8 degrees per step (200 steps per revolution)
$1tr	Travel per revolution	How far the mapped axis moves per motor revolution. E.g 2.54mm for a 10 TPI screw axis
$1mi	Microsteps	Microsteps per whole step. TinyG uses 1,2,4 and 8. Other values are accepted but warned
$1po	Polarity	Set polarity for proper movement of the axis. 0=clockwise rotation, 1=counterclockwise - although these are dependent on your motor wiring, and axis movement is dependent on the mechanical system.
$1pm	Power management mode	0=motor disabled, 1=motor always on, 2=motor on when in cycle, 3=motor on only when moving
$1pl	Power level (ARM only)	0.000=no power to steppers, 1.00=max power to steppers
 */
}
