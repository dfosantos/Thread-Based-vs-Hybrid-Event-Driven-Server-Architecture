package eventDriven;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.ClientHandler;
import server.Statistics;

public class FIFO extends Thread {

	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	public static int FileSize = 10000;
	public static int CPS = 1;
	
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
		new Statistics().start();
		long time = System.currentTimeMillis();

		while (true) {

			try {
				
				while (System.nanoTime() - time < (double) (1.0 / CPS) * 1000000000)
					;
				clientSocket = new Socket();
				Statistics.CPS = (float) (1.0 / (System.nanoTime() - time) * 1000000000);
				time = System.nanoTime();
				
				// Adds Client to FIFO
				ClientHandler worker = new ClientHandler(clientSocket, time, FileSize);
				EventDrivenServer.FIFO.add(worker);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
