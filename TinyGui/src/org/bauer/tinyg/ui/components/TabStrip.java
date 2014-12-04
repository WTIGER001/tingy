package org.bauer.tinyg.ui.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

public class TabStrip extends Composite {
	
	private String[] tabs;
	private int selection = 0;
	private int spacing = 15;
	private int linewidth = 3;
	private int linespace = 3;
	
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TabStrip(Composite parent, int style) {
		super(parent, style);
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				int w = getBounds().width;
				int h = getBounds().height;
				int texth = spacing;
				int tabwidth = w / tabs.length;
				int liney =  getFont().getFontData()[0].getHeight() + spacing + spacing;
				
				for (int i=0; i<tabs.length; i++ ) {
					// Draw the tab
					int startx = i*tabwidth;
					int centerx = startx + tabwidth/ 2;
					
					Point extents = e.gc.stringExtent(tabs[i]);
					int tx = centerx  - extents.x/2;
					
					e.gc.drawString(tabs[i], tx, texth, true);
					
					if (selection == i) {
						e.gc.fillRectangle(startx, liney, tabwidth, linewidth);
					}
				}

			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent arg0) {
				int tabwidth = getBounds().width / tabs.length;
				int index = arg0.x /tabwidth;
				selection = index;
				redraw();
				
				Event e = new Event();
				e.widget = TabStrip.this;
				e.type = SWT.Selection;
				e.index = index;
				
				notifyListeners(SWT.Selection, e);
			}
		});
	}
	
	public void setTabs(String ... tabs) {
		this.tabs = tabs;
		this.redraw();
	}

	@Override
	public void setFont(Font font) {
		super.setFont(font);
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		int h = getFont().getFontData()[0].getHeight() + spacing + spacing + linewidth + linespace;
		int w = -1;
		
		return (new Point(w,h));
	}

	public int getSelection() {
		return selection;
	}
}
