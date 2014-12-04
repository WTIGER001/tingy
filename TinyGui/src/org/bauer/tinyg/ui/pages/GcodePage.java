package org.bauer.tinyg.ui.pages;

import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.components.GCodeControls;
import org.bauer.tinyg.ui.components.ImageButton;
import org.bauer.tinyg.ui.graphics.Images2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

public class GcodePage extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GcodePage(Composite parent, int style) {
		super(parent, style);
		
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 15;
		layout.marginBottom = 15;
		layout.horizontalSpacing = 15;
		setLayout(layout);
		
		// G Code Label
		Composite gCodeLabelComp = new Composite(this, SWT.NULL);
		GridLayout gCodeLabelCompLayout = new GridLayout(3, false);
		gCodeLabelCompLayout.marginWidth = 0;
		gCodeLabelCompLayout.marginHeight = 0;
		gCodeLabelComp.setLayout(gCodeLabelCompLayout);
		gCodeLabelComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		Label lGcode = Resources.createLabel(gCodeLabelComp, "G Code");
		lGcode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		ImageButton btnLoadGcode = new ImageButton(gCodeLabelComp, SWT.NULL);
		btnLoadGcode.setImage(Images2.download.getMdpi());
		btnLoadGcode.setToolTipText("Load GCode");
		
		ImageButton btnClear = new ImageButton(gCodeLabelComp, SWT.NULL);
		btnClear.setImage(Images2.discard.getMdpi());
		btnClear.setToolTipText("Clear Gcode");
		
		// X-Y Area Display Label
		Label lGCode = Resources.createLabel(this, "X-Y Area Display");
		
		Table gcode = new Table(this, SWT.BORDER);
		gcode.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		
		Canvas area = new Canvas(this, SWT.BORDER);
		area.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		
		GCodeControls ctrls = new GCodeControls(this, SWT.NULL);
		ctrls.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	
	
}
