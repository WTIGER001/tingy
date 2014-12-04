package org.bauer.tinyg.ui;

import org.bauer.tinyg.ui.graphics.Images;
import org.bauer.tinyg.ui.pages.ConnectPage;
import org.bauer.tinyg.ui.pages.JogPage;
import org.bauer.tinyg.ui.pages.MainView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Application {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Application window = new Application();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		new KeyHandler(display);
		Resources.init(display);
		createContents();
		shell.open();
//		shell.setBackgroundImage(Images.CARBON_BACKROUND.getImage());
//		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		
				
		shell.layout();
		shell.setFullScreen(true);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		
		shell = new Shell();
		shell.setSize(1024, 800);
		shell.setText("TinyGUi");
		shell.setLayout(new FillLayout());
		
		MainView main = new MainView(shell, SWT.NULL);
//		
//		
//		
//		StackLayout stack = new StackLayout();
//		
//		shell.setLayout(stack);
//		
//		Composite connectPage = new ConnectPage(shell, SWT.NONE);
//		Composite jogPage = new JogPage(shell, SWT.NULL);
////		comp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
//		
//		stack.topControl = jogPage;
		
	}
	
	

}
