/*
 * tgFX Socket Monitor Class
 * Copyright Synthetos.com
 */
package org.bauer.tingy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author ril3y
 */
public class SocketMonitor {

	private SerialDriver ser = SerialDriver.getInstance();
	private int LISTENER_PORT;
	private ServerSocket server;
	private int clientCount = 0;

	public SocketMonitor(String tmpport) {
		LISTENER_PORT = Integer.parseInt(tmpport);
		this.initServer();
		this.handleConnections();
	}

	int countClientConnections() {
		return (clientCount);
	}

	boolean initServer() {
		try {
			server = new ServerSocket(LISTENER_PORT);
			return (true);
		} catch (IOException e) {
			Logging.print("Could not listen on port: "
					+ String.valueOf(LISTENER_PORT));
			return (false);
		}
	}

	public void handleConnections() {
		Logging.print("[+]Remote Monitor Listening for Connections....");
		// while (ser.isConnected()) {
		try {
			final Socket socket = server.accept();
			ConnectionHandler connectionHandler = new ConnectionHandler(socket);
		} catch (IOException ex) {
			Logging.print("[!]Error: " + ex.getMessage());
		}
		// }
		Logging.print("[!]Socket Monitor Terminated...");

	}

	public SocketMonitor(ServerSocket server) {
		this.server = server;
	}
}

/*
 * New Class Here
 */

class ConnectionHandler implements Runnable, Observer {

	private boolean disconnect = false;
	public Socket socket;

	@Override
	public void update(Observable o, Object arg) {

		String[] MSG = (String[]) arg;

		if (MSG[0] == "JSON") {
			final String line = MSG[1];
			try {
				this.write(MSG[1] + "\n");
			} catch (IOException ex) {
				disconnect = true;
			} catch (Exception ex) {
				Logging.print("update(): " + ex.getMessage());
			}
		}
	}

	public ConnectionHandler(Socket socket) {
		this.socket = socket;

		SerialDriver ser = SerialDriver.getInstance();
		Logging.print("[+]Opening Remote Listener Socket");
		// ser.addObserver(this);
		Thread t = new Thread(this);
		// t.start();
	}

	private void write(String l) throws Exception {
		// Method for writing to the socket
		socket.getOutputStream().write(l.getBytes());
	}

	public void run() {
		try {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// Logging.print("GOT: " + stdIn.readLine());
			// try {
			// this.write("[+]Connected to tgFX\n");
			// } catch (Exception ex) {
			// }
			TinygDriver tg = TinygDriver.getInstance();
			String line = "";
			SerialDriver ser = SerialDriver.getInstance();
			while (ser.isConnected() && !disconnect) {
				try {
					line = stdIn.readLine() + "\n";
					tg.write(line);
					Thread.sleep(100);
				} catch (IOException ex) {
					disconnect = true;
				} catch (Exception ex) {
					Logging.print("run(): " + ex.getMessage());
					break;
				}
			}
			Logging.print("[+]Closing Remote Listener Socket");
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
