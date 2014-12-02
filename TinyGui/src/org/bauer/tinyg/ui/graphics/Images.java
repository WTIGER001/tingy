package org.bauer.tinyg.ui.graphics;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;

public enum Images {
	CARBON_BACKROUND("carbon.png"),
	USB("ic_action_usb.png"),
	
	;
	private String name;
	private Image image = null;
	private Images(String name) {
		this.name = name;
	}
	
	public Image getImage() {
		if (image == null || image.isDisposed()) {
			ImageData data  = new ImageLoader().load(getClass().getResourceAsStream(name))[0];
			image = new Image(Display.getCurrent(), data);
		}
		return image;
	}
}
