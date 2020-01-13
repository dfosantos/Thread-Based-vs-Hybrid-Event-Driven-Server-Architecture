package eventDriven;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.ClientHandler;
import server.Statistics;

public class FIFO extends Thread {

	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;

	public FIFO(int port) {
		this.serverPort = port;
	}

	@Override
	public void run() {

		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Socket clientSocket;
		new Statistics().run();
		
		while (true) {

			try {
				
				clientSocket = serverSocket.accept();

				
				// Adds Client to FIFO
				ClientHandler worker = new ClientHandler(clientSocket, System.currentTimeMillis());
				EventDrivenServer.FIFO.add(worker);
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
