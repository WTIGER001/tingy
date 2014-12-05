package org.bauer.tinyg.ui.pages;

import org.bauer.tingy.TinyG;
import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.command.Commands;
import org.bauer.tinyg.ui.components.PrettyButton;
import org.bauer.tinyg.ui.graphics.Images;
import org.bauer.tinyg.ui.graphics.Images2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class ConnectPage extends Composite implements IPage {
	Composite area ;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ConnectPage(Composite parent, int style) {
		super(parent, style);
		setLayout( new GridLayout());
		
		area = new Composite(this, SWT.NULL);
		area.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		area.setLayout(new GridLayout());
		
		build();
	}	
	
	@Override
	public Image image() {
		return Images2.usb.getxHdpi();
	}
	
	@Override
	public String name() {
		return "Connect to TinyG";
	}
	
	private void build() {
		// Dispose all the children of area
		area.setRedraw(false);
		
		Control[] children = area.getChildren();
		for (Control child : children) {
			child.dispose();
		}
		
		String[] ports = getPorts();
		
		createHeader(area);
		for (String port : ports) {
			createPortButton(port, area);
		}
		createFooter(area, ports.length == 0);
		
		area.setRedraw(true);
		area.layout();
	}
	
	private String[] getPorts() {
		return TinyG.instance().getPorts();
	}
	
	private void createPortButton(String port, Composite area) {
		final PrettyButton btnNewButton = new PrettyButton(area, SWT.PUSH);
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		btnNewButton.setAlignment(SWT.LEFT);
		btnNewButton.setImage(null);
		GridData gd_btnNewButton = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_btnNewButton.widthHint = 424;
		gd_btnNewButton.heightHint = 75;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText(port);
		btnNewButton.bind(Commands.Connect, port);
	}
	
	private void createHeader(Composite area) {
		Label label = new Label(area, SWT.NONE);
		label.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label.setImage(Images2.usb.getxxHdpi());
	}
	
	private void createFooter(Composite area, boolean empty) {
			
		Label lblNewLabel = new Label(area, SWT.WRAP | SWT.CENTER);
		GridData gd_lblNewLabel = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 441;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setForeground(Resources.fontForeground());
		lblNewLabel.setFont(Resources.LargeBold());
		if (empty == true) {
			lblNewLabel.setText("Please Connect the TinyG using the USB Cable.");
		} else {
			lblNewLabel.setText("Please Connect to the TinyG. Select the Serial Port that the TinyG is connected to.");
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
