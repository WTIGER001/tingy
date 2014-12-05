package org.bauer.tinyg.ui.pages;

import org.bauer.tingy.ITinyGActionListener;
import org.bauer.tingy.TinyG;
import org.bauer.tingy.TinyGAction;
import org.bauer.tinyg.ui.Resources;
import org.bauer.tinyg.ui.components.ImageButton;
import org.bauer.tinyg.ui.graphics.Images;
import org.bauer.tinyg.ui.graphics.Images2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;


/**
 * The main composite that is at the top level of the application. This includes the following components:
 * 1.) A button Bar (that may be hidden) that has all the different views and global actions
 * 2.) A composite to display each page. 
 * 
 * @author John.Bauer
 *
 */
public class MainView extends Composite {
	private Buttons buttons;
	private StackLayout stack;
	private Composite pageHolder;
	private ConnectPage connectPage;
	private JogPage jogPage;
	private GcodePage gcodePage;
	private SettingsPage settingsPage;
	private ReportsPage reportsPage;


	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainView(Composite parent, int style) {
		super(parent, style);

		setBackgroundImage(Images.CARBON_BACKROUND.getImage());
		setBackgroundMode(SWT.INHERIT_FORCE);
		
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 15;
		layout.marginBottom = 15;
		
		setLayout(layout);
		
		// Buttons at top
		buttons = new Buttons(this, SWT.NULL);
		buttons.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
		
		pageHolder = new Composite(this, SWT.NULL);
		pageHolder.setLayoutData(new GridData(SWT.FILL,  SWT.FILL, true, true));
		stack = new StackLayout();
		pageHolder.setLayout(stack);
		
		// Create the pages
		connectPage = new ConnectPage(pageHolder, SWT.NONE);
		jogPage = new JogPage(pageHolder, SWT.NONE);
		gcodePage = new GcodePage(pageHolder, SWT.NONE);
		reportsPage = new ReportsPage(pageHolder, SWT.NONE);
		settingsPage = new SettingsPage(pageHolder, SWT.NULL);
		
		showPage(connectPage);
		
		buttons.btnDisconnect.setVisible(false);
		buttons.btnGCode.setVisible(false);
		buttons.btnJog.setVisible(false);
		buttons.btnReports.setVisible(false);
		buttons.btnSettings.setVisible(false);
		
		TinyG.instance().addListener(new HandleConnectDisconnect(), TinyGAction.Connect, TinyGAction.Disconnect);
		
	}

	private void showPage(IPage page) {
		buttons.title.setText(page.name());
		stack.topControl = (Control) page;
		pageHolder.layout();
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	
	class Buttons extends Composite {

		private Label title;
		private ImageButton btnExit;
		private ImageButton btnFullScreen;
		private ImageButton btnDisconnect;
		private ImageButton btnSettings;
		private ImageButton btnReports;
		private ImageButton btnJog;
		private ImageButton btnGCode;

		/**
		 * Create the composite.
		 * @param parent
		 * @param style
		 */
		public Buttons(Composite parent, int style) {
			super(parent, style);
			GridLayout gdWhole = new GridLayout(2, false);
			gdWhole.marginHeight = 0;
			gdWhole.marginWidth = 0;
			
			title = new Label(this, SWT.NULL);
			title.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			title.setFont(Resources.title());
			title.setForeground(Resources.fontForeground());
			title.setText("Manual Controls");
			
			GridLayout gdInner = new GridLayout(7, false);
			gdInner.marginHeight = 0;
			gdInner.marginWidth = 0;

			setLayout(gdWhole);
			
			Composite composite = new Composite(this, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
			composite.setLayout(gdInner);
			
			btnGCode = new ImageButton(composite, SWT.NULL);
			btnGCode.setImage(Images2.cast.getxHdpi());
			btnGCode.setToolTipText("G-Code");
			
			btnJog = new ImageButton(composite, SWT.NULL);
			btnJog.setImage(Images2.gamepad.getxHdpi());
			btnJog.setToolTipText("Manual Control");
			
			btnReports = new ImageButton(composite, SWT.NULL);
			btnReports.setImage(Images.Document.getImage());
			btnReports.setToolTipText("Reports");
			
			
			btnSettings = new ImageButton(composite, SWT.NULL);
			btnSettings.setImage(Images2.settings.getxHdpi());
			btnSettings.setToolTipText("Settings");
			
			btnDisconnect = new ImageButton(composite, SWT.NULL);
			btnDisconnect.setImage(Images2.usb.getxHdpi());
			btnDisconnect.setToolTipText("Disconnect");
			
			btnFullScreen = new ImageButton(composite, SWT.NULL);
			if (getShell().getFullScreen()) {
				btnFullScreen.setImage(Images2.full_screen.getxHdpi());
				btnFullScreen.setToolTipText("Full Screen");
			} else {
				btnFullScreen.setImage(Images2.return_from_full_screen.getxHdpi());
				btnFullScreen.setToolTipText("Return from Full Screen");
			}
			
			
			btnExit = new ImageButton(composite, SWT.NULL);
			btnExit.setImage(Images2.cancel.getxHdpi());
			btnExit.setToolTipText("Exit");
			
			btnExit.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {
					System.exit(0);
				}
			});
			
			btnDisconnect.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {
					TinyG.instance().disconnect();
				}
			});
			
			btnJog.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {
					title.setText("Manual Controls");
					stack.topControl = jogPage;
					pageHolder.layout();
					showPage(jogPage);
				}
			});
			
			btnGCode.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {
					showPage(gcodePage);
				}
			});
			
			btnSettings.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {
					showPage(settingsPage);
				}
			});			
			
			btnReports.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {
					showPage(reportsPage);
				}
			});		
			
			btnFullScreen.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {
					Shell sh = getShell();
					if (sh.getFullScreen()) {
						sh.setFullScreen(false);
						btnFullScreen.setImage(Images2.full_screen.getxHdpi());
						btnFullScreen.setToolTipText("Full Screen");
					} else {
						sh.setFullScreen(true);
						btnFullScreen.setImage(Images2.return_from_full_screen.getxHdpi());
						btnFullScreen.setToolTipText("Return from Full Screen");
					}
				}
			});
			
		}

		@Override
		protected void checkSubclass() {
			// Disable the check that prevents subclassing of SWT components
		}
	}
	
	class HandleConnectDisconnect implements ITinyGActionListener {

		@Override
		public void actionPerformed(TinyGAction action, Object data) {
			if (action == TinyGAction.Connect) {
				buttons.btnDisconnect.setVisible(true);
				buttons.btnGCode.setVisible(true);
				buttons.btnJog.setVisible(true);
				buttons.btnReports.setVisible(true);
				buttons.btnSettings.setVisible(true);
				
				showPage(jogPage);
				
			} else if (action == TinyGAction.Disconnect) {
				buttons.btnDisconnect.setVisible(false);
				buttons.btnGCode.setVisible(false);
				buttons.btnJog.setVisible(false);
				buttons.btnReports.setVisible(false);
				buttons.btnSettings.setVisible(false);
				
				showPage(connectPage);
			}
		}
		
	}
	
}
