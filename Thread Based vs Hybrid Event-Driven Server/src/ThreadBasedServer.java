import java.io.IOException;
import java.net.*;

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

		while (true) {
			Socket clientSocket = null;

			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				throw new RuntimeException("Error accepting client connection", e);
			}

			new ClientHandler(clientSocket).run();

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
