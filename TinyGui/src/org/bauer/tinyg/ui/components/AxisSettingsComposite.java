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

public class AxisSettingsComposite extends Composite {

	private Control cmbMapping;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AxisSettingsComposite(Composite parent, int style) {
		super(parent, style);
		setBackgroundImage(Images.BG2.getImage());
		GridLayout layout = new GridLayout(5, false);
		layout.horizontalSpacing = 25;
		setLayout(layout);
		
		// Axis Mode
		Label lMapping = Resources.mLabel(this, "Axis Mode");
		lMapping.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		CCombo cmbMapping = Resources.mCcombo(this, 0, "Normal");
		cmbMapping.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Resources.createLabel(this, "");
		
		// Switch Mode Min
		Label lMicrosteps = Resources.mLabel(this, "Switch Mode Min");
		lMicrosteps.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		CCombo cmbMicrosteps = Resources.mCcombo(this, 0, "Disabled", "Homing-only", "limit-only", "homing-and-limit (XYZA only)");
		cmbMicrosteps.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		
		// Velocity Maximum
		Label lVelocityMaximum = Resources.mLabel(this, "Velocity Maximum");
		lVelocityMaximum.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtVelocityMax = Resources.mText(this, "");
		txtVelocityMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Resources.createLabel(this, "");
		
		// Swich Mode Max
		Label lSwitchModeMax = Resources.mLabel(this, "Swich Mode Max");
		lSwitchModeMax.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		CCombo cmbSwitchModeMax = Resources.mCcombo(this, 0, "Disabled", "Homing-only", "limit-only", "homing-and-limit (XYZA only)");
		cmbSwitchModeMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		
		// FeedRate Maximum
		Label lFeedRateMax = Resources.mLabel(this, "Feedrate Maximum");
		lFeedRateMax.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtFeedRateMax= Resources.mText(this, "");
		txtFeedRateMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Resources.createLabel(this, "");
		
		// Search Velocity
		Label lSearchVelocity = Resources.mLabel(this, "Search Velocity");
		lSearchVelocity.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtSearchVelocity = Resources.mText(this, "");
		txtSearchVelocity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		// Travel Maximum
		Label lTravelMax = Resources.mLabel(this, "Travel Maximum");
		lTravelMax.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtTravelMax= Resources.mText(this, "");
		txtTravelMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Resources.createLabel(this, "");
		
		// Latch Velocity
		Label lLatchVelocty = Resources.mLabel(this, "Latch Velocity");
		lLatchVelocty.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtLatchVelocity = Resources.mText(this, "");
		txtLatchVelocity.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				
		// Maximum Jerk
		Label lMaxJerk = Resources.mLabel(this, "Maximum Jerk");
		lMaxJerk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtMaxJerk= Resources.mText(this, "");
		txtMaxJerk.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Resources.createLabel(this, "");
				
		// Latch Backoff
		Label lLatchBackoff = Resources.mLabel(this, "Latch Backoff");
		lLatchBackoff.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtLatchBackoff = Resources.mText(this, "");
		txtLatchBackoff.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		// Junction Deviation
		Label lJunctionDeviation = Resources.mLabel(this, "Junction Deviation");
		lJunctionDeviation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtJunctionDeviation= Resources.mText(this, "");
		txtJunctionDeviation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Resources.createLabel(this, "");
				
		// Zero Backoff
		Label lZeroBackoff = Resources.mLabel(this, "Zero Backoff");
		lZeroBackoff.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		
		Text txtZeroBackoff = Resources.mText(this, "");
		txtZeroBackoff.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
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
