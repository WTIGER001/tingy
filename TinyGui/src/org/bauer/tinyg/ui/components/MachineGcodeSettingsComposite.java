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

public class MachineGcodeSettingsComposite extends Composite {

	private Control cmbMapping;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MachineGcodeSettingsComposite(Composite parent, int style) {
		super(parent, style);

		setBackgroundImage(Images.BG2.getImage());
		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 25;
		setLayout(layout);
		
		
		// Frequency
		Label lFrequency = Resources.lLabel(this, "Frequency");
		lFrequency.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtFrequency = Resources.lText(this, "");
		txtFrequency.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		// Clockwise Speed Low
		Label lClockwiseSpeedLow = Resources.lLabel(this, "Clockwise Speed Low");
		lClockwiseSpeedLow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtClockwiseSpeedLow = Resources.lText(this, "");
		txtClockwiseSpeedLow.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		// Clockwise Speed High
		Label lClockwiseSpeedHigh = Resources.lLabel(this, "Clockwise Speed High");
		lClockwiseSpeedHigh.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtClockwiseSpeedHigh = Resources.lText(this, "");
		txtClockwiseSpeedHigh.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		// Clockwise Speed Low
		Label lCounterClockwiseSpeedLow = Resources.lLabel(this, "Counter Clockwise Speed Low");
		lCounterClockwiseSpeedLow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtCounterClockwiseSpeedLow = Resources.lText(this, "");
		txtCounterClockwiseSpeedLow.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		// Clockwise Speed High
		Label lCounterClockwiseSpeedHigh = Resources.lLabel(this, "Counter Clockwise Speed High");
		lCounterClockwiseSpeedHigh.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtCounterClockwiseSpeedHigh = Resources.lText(this, "");
		txtCounterClockwiseSpeedHigh.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
 
		
		Label lPhaseOff= Resources.lLabel(this, "Phase Off");
		lPhaseOff.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtPhaseOff = Resources.lText(this, "");
		txtPhaseOff.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		// Clockwise Phase Low
		Label lClockwisePhaseLow = Resources.lLabel(this, "Clockwise Phase Low");
		lClockwisePhaseLow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtClockwisePhaseLow = Resources.lText(this, "");
		txtClockwisePhaseLow.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// Clockwise Phase High
		Label lClockwisePhaseHigh = Resources.lLabel(this, "Clockwise Phase High");
		lClockwisePhaseHigh.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtClockwisePhaseHigh = Resources.lText(this, "");
		txtClockwisePhaseHigh.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		
		// Counter Clockwise Phase Low
		Label lCounterClockwisePhaseLow = Resources.lLabel(this, "Counter Clockwise Phase Low");
		lCounterClockwisePhaseLow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtCounterClockwisePhaseLow = Resources.lText(this, "");
		txtCounterClockwisePhaseLow.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// Counter Clockwise Phase High
		Label lCounterClockwisePhaseHigh = Resources.lLabel(this, "Counter Clockwise Phase High");
		lCounterClockwisePhaseHigh.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtCounterClockwisePhaseHigh = Resources.lText(this, "");
		txtCounterClockwisePhaseHigh.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				
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
