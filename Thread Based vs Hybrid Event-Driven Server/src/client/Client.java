package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import client.ClientCreator.Statistics;

public class Client extends Thread{

	Statistics stats;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;

	public Client(Socket sckt, Statistics stats) throws IOException {
		this.socket = sckt;
		this.stats = stats;
		this.in = new DataInputStream(sckt.getInputStream());
		this.out = new DataOutputStream(sckt.getOutputStream());

	}

	@Override
	public void run() {
		try {
			out.writeInt(stats.nBytes);
			out.writeInt(getRandomNumberInRange(0,1073741824 - stats.nBytes));
			in.readLong();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}