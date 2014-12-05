package org.bauer.tinyg.ui.pages;

import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.components.PrettyButton;
import org.bauer.tinyg.ui.graphics.Images;
import org.bauer.tinyg.ui.graphics.Images2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ReportsPage extends Composite implements IPage {

	@Override
	public Image image() {
		return Images.Document.getImage();
	}
	
	@Override
	public String name() {
		return "Reports";
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ReportsPage(Composite parent, int style) {
		super(parent, style);

		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 15;
		layout.marginBottom = 15;
		layout.horizontalSpacing = 25;
		
		setLayout(layout);
		
		Label lConsole = Resources.lLabel(this, "Console");
		lConsole.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		Label lActions = Resources.lLabel(this, "Actions");
		lActions.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		
		Text t =  new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI  | SWT.V_SCROLL);
		t.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		t.setForeground(Resources.fontForeground());
		t.setFont(Resources.mediumFont());
		t.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		t.setText("Report will go here");
		
		GridLayout blayout = new GridLayout(1, false);
		blayout.marginWidth = 0;
		blayout.marginBottom = 0;
		blayout.verticalSpacing = 15;
		
		Composite buttons = new Composite(this, SWT.NULL);
		buttons.setLayout(blayout);
		buttons.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));

		PrettyButton btnRunReport = new PrettyButton(buttons, SWT.NULL);
		btnRunReport.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnRunReport.setText("Run Report");
		
		PrettyButton btnRunQueueReport = new PrettyButton(buttons, SWT.NULL);
		btnRunQueueReport.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnRunQueueReport.setText("Queue Report");
		
		PrettyButton btnFlush = new PrettyButton(buttons, SWT.NULL);
		btnFlush.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnFlush.setText("Flush Planner");
		
		PrettyButton btnDisableMotors = new PrettyButton(buttons, SWT.NULL);
		btnDisableMotors.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnDisableMotors.setText("Disable Motors");
		
		PrettyButton btnEnergizeMotors = new PrettyButton(buttons, SWT.NULL);
		btnEnergizeMotors.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnEnergizeMotors.setText("Energize Motors");
		
		PrettyButton btnTests = new PrettyButton(buttons, SWT.NULL);
		btnTests.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnTests.setText("Invoke Self Tests");
		
		PrettyButton btnReset = new PrettyButton(buttons, SWT.NULL);
		btnReset.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnReset.setText("Reset To Factory Defaults");
		
		PrettyButton btnHelp = new PrettyButton(buttons, SWT.NULL);
		btnHelp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnHelp.setText("Help");
		
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
