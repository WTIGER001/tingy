package org.bauer.tingy;

import org.apache.log4j.Logger;


public class Logging {
	public static String OS = System.getProperty("os.name").toLowerCase();
	public static final String LOGLEVEL = "";
	static final Logger logger = Logger.getLogger(Logging.class);

	public static void print(String msg) {
		System.out.println(msg);
    }

	public static void postConsoleMessage(String string) {
		// TODO Auto-generated method stub
		
	}
}
