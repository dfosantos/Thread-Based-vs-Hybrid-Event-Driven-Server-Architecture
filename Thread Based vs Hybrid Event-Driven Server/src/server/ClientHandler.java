package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class ClientHandler extends Thread {

	Socket socket;
	static final String path = "files/file";
	long startTime;

	public ClientHandler(Socket clientSocket, long startTime) throws IOException {
		this.socket = clientSocket;

		this.startTime = startTime;
	}

	@Override
	public void run() {

		int size = 10000;
		int offset = getRandomNumberInRange(0,1073741824 - size);
		byte[] read = null;

		read = FileOps.NIO_Read(ClientHandler.path, size, offset);

		MessageDigest msg = null;
		
		try {
			msg = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] sha256 = msg.digest(read);

		FileOps.NIO_Write(path, sha256);


		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long time = System.currentTimeMillis() - startTime;
		Statistics.clientTimes.add(time);
		Statistics.clientDebits.add((float) (size / time));

	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
