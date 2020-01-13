package threadBased;

import java.io.IOException;
import java.net.*;

import server.ClientHandler;
import server.Statistics;

public class ThreadBasedServer implements Runnable {

	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;

	public ThreadBasedServer(int port) {
		this.serverPort = port;
	}

	@Override
	public void run() {
		System.out.println("Running Thread Based Server");

		openServerSocket();
		Socket clientSocket = null;

		new Statistics().start();
		
		while (true) {

			try {
				clientSocket = this.serverSocket.accept();
				new ClientHandler(clientSocket, System.currentTimeMillis()).start();
			} catch (IOException e) {
				throw new RuntimeException("Error accepting client connection", e);
			}

		}

	}

	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			throw new RuntimeException("Cannot open port " + this.serverPort, e);
		}
	}

}
