package threadBased;

import java.io.IOException;
import java.net.*;

import server.ClientHandler;

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
		
		while (true) {
			

			try {
				System.out.println("Waiting Client");
				clientSocket = this.serverSocket.accept();
				System.out.println("Client Accepted");
			} catch (IOException e) {
				throw new RuntimeException("Error accepting client connection", e);
			}

			try {
				System.out.println("Creating Thread for client");
				new ClientHandler(clientSocket).run();
				System.out.println("Thread Created");
			} catch (IOException e) {
				e.printStackTrace();
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
