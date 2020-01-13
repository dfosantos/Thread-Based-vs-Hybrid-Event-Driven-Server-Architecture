package threadBased;

import java.io.IOException;
import java.net.*;

import server.ClientHandler;
import server.ServerStatisticsGUI;
import server.Statistics;

public class ThreadBasedServer implements Runnable {

	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	public static int CPS = 1;
	public static int FileSize = 10000;

	public ThreadBasedServer(int port) {
		this.serverPort = port;
	}

	@Override
	public void run() {
		System.out.println("Running Thread Based Server");

		openServerSocket();
		Socket clientSocket = null;

		new Statistics().start();
		new ServerStatisticsGUI().run();
		long time = System.nanoTime();
		while (true) {

			try {
				while (System.nanoTime() - time < (double) (1.0 / CPS) * 1000000000)
					;
				clientSocket = new Socket();
				Statistics.CPS = (float) (1.0 / (System.nanoTime() - time) * 1000000000);
				time = System.nanoTime();
				new ClientHandler(clientSocket, System.nanoTime(), FileSize).start();
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
