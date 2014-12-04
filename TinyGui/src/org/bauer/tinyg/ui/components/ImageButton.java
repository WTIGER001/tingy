package org.bauer.tinyg.ui.components;

import java.util.concurrent.atomic.AtomicBoolean;

import org.bauer.tinyg.ui.Resources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;

public class ImageButton extends Label {
	Image hoverImage;
	Image image;
	AtomicBoolean mouseo = new AtomicBoolean();
	AtomicBoolean mousedown = new AtomicBoolean();
	float scale = 1.0f;
	
	public ImageButton(Composite arg0, int arg1) {
		super(arg0, arg1);
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				if (mousedown.get() == true ) {
					e.gc.setBackground(Resources.buttonForeground());
					e.gc.fillRectangle(0, 0, getBounds().width, getBounds().height);
				}
				
				Image img = getImage();
//				if (mouseo.get() == true && hoverImage != null) {
//					img = hoverImage;
//				}
				int w = (int) (image.getBounds().width*scale);
				int h = (int) (image.getBounds().height*scale);
				
				
				int x = (getBounds().width - w) / 2;
				int y = (getBounds().height - h) / 2;
				
//				e.gc.drawImage(img, x, y);
				e.gc.drawImage(img, 0, 0, img.getBounds().width, img.getBounds().height, x, y, w, h);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				if (mousedown.compareAndSet(false, true)) {
					redraw();
				}	
			}
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				if (mousedown.compareAndSet(true, false)) {
					redraw();
				}	
				
				Event e = new Event();
				e.widget = ImageButton.this;
				e.type = SWT.Selection;
				
				notifyListeners(SWT.Selection, e);
			}
			
		});
		addMouseMoveListener(new MouseMoveListener() {
			
			@Override
			public void mouseMove(MouseEvent arg0) {
				
			}
		});
		addMouseTrackListener(new MouseTrackListener() {
			
			@Override
			public void mouseHover(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExit(MouseEvent arg0) {
				if (mouseo.compareAndSet(true, false)) {
					redraw();
				}
			}
			
			@Override
			public void mouseEnter(MouseEvent arg0) {
				if (mouseo.compareAndSet(false, true)) {
					redraw();
				}
			}
		});
	}
	
	@Override
	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
	public Image getImage() {
		return image;
	}
	
	@Override
	public Point computeSize(int xHint, int yHint, boolean redo) {
		int x = (int) (image.getBounds().width*scale);
		int y = (int) (image.getBounds().height*scale);
		return new Point(x, y);
	}
	
	public void setHoverImage(Image hoverImage) {
		this.hoverImage = hoverImage;
	}
	
	public Image getHoverImage() {
		return hoverImage;
	}
	
	@Override
	protected void checkSubclass() {
		
	}
	
	public void setScale(float scale) {
		this.scale = scale;
	}

}
