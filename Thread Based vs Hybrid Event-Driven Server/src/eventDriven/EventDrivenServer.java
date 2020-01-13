package eventDriven;

import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import server.ClientHandler;
import server.ServerStatisticsGUI;

public class EventDrivenServer implements Runnable {

	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	public static Queue<ClientHandler> FIFO = new LinkedList<>();
	public static ThreadPoolExecutor executor;

	public EventDrivenServer(int port) {
		this.serverPort = port;
	}

	@Override
	public void run() {
		System.out.println("Running Event Driven Server");

		int threadNumber;
		// threadNumber = Runtime.getRuntime().availableProcessors();
		threadNumber = 16;

		new ServerStatisticsGUI().run();
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadNumber);

		// Starts the FIFO to accept client connections
		new FIFO(serverPort).start();

		while (true) {
			if (executor.getActiveCount() < threadNumber && !FIFO.isEmpty()) {
				synchronized (FIFO) {
					executor.execute(FIFO.remove());

				}

			}

		}

	}

}
