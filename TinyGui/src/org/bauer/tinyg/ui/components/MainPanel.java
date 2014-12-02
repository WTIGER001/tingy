package org.bauer.tinyg.ui.components;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;

/**
 * Represents tabs in android look and feel
 */
public class MainPanel extends Composite {
	private int selection = 0;
	private StackLayout stack;
	private int tabPadding = 6;
	private List<String> labels = new ArrayList<>();
	
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainPanel(Composite parent, int style) {
		super(parent, style);
		
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				//
				
				
				
				
				
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				super.mouseDown(e);
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				super.mouseUp(e);
			}
		});
	}
	
	public void addTab(String label, Composite contents) {
		
	}
	
	@Override
	public void setFont(Font font) {
		super.setFont(font);
		updateMetrics();
	}
	
	
	
	
	private void updateMetrics() {
		
	}

	@Override
	protected void checkSubclass() {
		
	}

}
