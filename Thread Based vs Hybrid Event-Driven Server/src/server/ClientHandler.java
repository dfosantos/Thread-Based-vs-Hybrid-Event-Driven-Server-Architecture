package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ClientHandler extends Thread{

	DataInputStream in;
	DataOutputStream out;
	Socket socket;
	static final String path = "files/file";
	long startTime;
	
	public ClientHandler(Socket clientSocket, long startTime) throws IOException {
		this.socket = clientSocket;
		this.in = new DataInputStream(socket.getInputStream());
		this.out = new DataOutputStream(socket.getOutputStream());
		this.startTime = startTime;
	}

	@Override
	public void run() {

		int size;
		int offset;
		byte[] read = null;
	
		
		try {
			size = in.readInt();
			offset = in.readInt();
			read = FileOps.NIO_Read(ClientHandler.path, size, offset);
		} catch (IOException e) {
			e.printStackTrace();
		}

		MessageDigest msg = null;
		try {
			msg = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] sha256 = msg.digest(read);
		
		FileOps.NIO_Write(path, sha256);
		
		try {
			out.writeLong(java.nio.ByteBuffer.wrap(sha256).getLong());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Statistics.clientTimes.add(System.currentTimeMillis() - startTime);
	}

}
