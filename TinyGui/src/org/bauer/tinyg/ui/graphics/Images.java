package org.bauer.tinyg.ui.graphics;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;

public enum Images {
	CARBON_BACKROUND("carbon.png"),
	BG1("bg1.png"),
	BG2("bg2.png"),
	PAPER_BACKROUND("background.jpg"),
	USB("ic_action_usb.png"),
	UP("up.png"),
	LEFT("left.png"),
	DOWN("down.png"),
	RIGHT("right.png"),
	PLUS("plus.png"),
	MINUS("minus.png"),
	Document("ic_action_document.png")
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
