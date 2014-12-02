package org.bauer.tinyg.ui.components;

import org.bauer.tinyg.ui.graphics.Images;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class PrettyButton extends Button {
	private boolean down = false;
	
	public PrettyButton(Composite arg0, int arg1) {
		super(arg0, arg1);
		
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				Image img = getImage();
				int textPostionX = 2;
				if (img != null) {
					textPostionX += img.getBounds().width + 10;
				} else {
					int width = e.gc.stringExtent(getText()).x;
					textPostionX = (getBounds().width - width)/ 2;
				}
				int textPostionY = (getBounds().height - e.gc.getFontMetrics().getHeight())/ 2;
				
				if (down == false) {
					setBackground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
					org.eclipse.swt.graphics.Pattern pattern;
					pattern = new org.eclipse.swt.graphics.Pattern(e.gc
							.getDevice(), 0, 0, 0, 100, e.gc.getDevice()
							.getSystemColor(SWT.COLOR_GRAY), 230, e.gc
							.getDevice().getSystemColor(SWT.COLOR_BLACK), 230);
//					e.gc.setBackgroundPattern(pattern);
//					e.gc.fillGradientRectangle(0, 0, getBounds().width,
//							getBounds().height, true);
					
					e.gc.fillRectangle(0, 0, getBounds().width,getBounds().height);
//					e.gc.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
					e.gc.drawString(getText(), textPostionX,textPostionY, true);
				} else {
					setBackground(getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
					org.eclipse.swt.graphics.Pattern pattern;
					pattern = new org.eclipse.swt.graphics.Pattern(e.gc
							.getDevice(), 0, 0, 0, 100, e.gc.getDevice()
							.getSystemColor(SWT.COLOR_GRAY), 230, e.gc
							.getDevice().getSystemColor(SWT.COLOR_GRAY), 230);
					e.gc.setBackgroundPattern(pattern);
					e.gc.fillGradientRectangle(0, 0, getBounds().width,
							getBounds().height, true);
					
//					e.gc.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
					e.gc.drawString(getText(), textPostionX,textPostionY, true);
				}
				if (img != null) {
					e.gc.drawImage(img, 10, (getBounds().height - img.getBounds().height )/ 2  );
				}
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				down = true;
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				down = false;
			}
		});
	}
	
	@Override
	protected void checkSubclass() {
		
	}

}
