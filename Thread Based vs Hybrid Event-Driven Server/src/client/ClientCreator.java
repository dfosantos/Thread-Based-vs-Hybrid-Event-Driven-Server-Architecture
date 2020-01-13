package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientCreator {

	static int ConnectionsPerSecond;
	static InetAddress ip;
	static int port;

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println(
					"Proper Usage:\n 1st ARGUMENT: Server IP\n 2nd ARGUMENT: Port number\n\tEx.: java ClientCreator 192.168.1.125 12345");
			System.exit(0);
		}

		try {
			ip = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
			System.exit(0);
		}

		port = Integer.parseInt(args[1]);
		Statistics stats = new Statistics();
		Socket s = new Socket();
		try {
			s.setSoTimeout(1000);
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Client c;
		new GUI(stats).run();

		while (true) {

			try {

				s = new Socket(ip, port);
				c = new Client(s, stats);
				c.start();
				long time = System.currentTimeMillis();
				while (System.currentTimeMillis() - time < (1 / stats.ConnectionsPerSecond))
					;
			} catch (IOException e) {
				System.out.println("Couldn't Connect to Server");
				e.printStackTrace();
			}
		}

	}

	static class Statistics {
		public int ConnectionsPerSecond = 1;
		public int nBytes = 10000;
	}

}
