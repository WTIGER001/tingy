package org.bauer.tingy;

import org.bauer.tingy.internal.RealTinyG;
import org.bauer.tingy.mock.MockTinyG;

public class TinyG {
	private static Holder instanceHolder = new Holder();
	public TinyG() {
		// TODO Auto-generated constructor stub
	}

	public static ITinyG instance() {
		return instanceHolder.INSTANCE;
	}
	
	
	private static class Holder {
		private ITinyG INSTANCE;
		
		private Holder() {
			boolean mock = System.getProperties().containsKey("org.bauer.tinyg.MOCK");;
			if (mock) {
				INSTANCE = new MockTinyG();
			} else {
				INSTANCE = new RealTinyG();
			}
			INSTANCE.init();
		}
	}
}
