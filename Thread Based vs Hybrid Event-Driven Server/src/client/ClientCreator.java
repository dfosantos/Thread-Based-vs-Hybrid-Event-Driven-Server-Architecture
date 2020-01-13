package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class ClientCreator {

	static int ConnectionsPerSecond;
	static InetAddress ip;
	static int port;
	static Statistics stats;
	static Timer timer;

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

		stats = new Statistics();

		new GUI(stats).run();

		changeCPS(1000);

	}

	public static void changeCPS(int millis) {
		try {
			timer.cancel();
		} catch (Exception e) {
			System.out.println("Already canceled");
		}

		timer = new Timer();
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Socket s = null;
				try {
					s = new Socket(ip, port);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Client c = null;
				try {
					c = new Client(s, stats);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.start();
			}
		}, 0, millis);

	}

	static class Statistics {
		public int ConnectionsPerSecond = 1;
		public int nBytes = 10000;
	}

}
