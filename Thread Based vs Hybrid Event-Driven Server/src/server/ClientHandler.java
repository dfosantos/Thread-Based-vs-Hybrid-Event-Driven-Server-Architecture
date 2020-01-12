package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ClientHandler implements Runnable {

	DataInputStream in;
	DataOutputStream out;
	Socket socket;
	static final String path = "../file";
	
	public ClientHandler(Socket clientSocket) throws IOException {
		this.socket = clientSocket;
		this.in = new DataInputStream(socket.getInputStream());
		this.out = new DataOutputStream(socket.getOutputStream());
	}

	@Override
	public void run() {

		int size;
		int offset;
		byte[] read = null;
		try {
			System.out.println("about to read");
			size = in.readInt();
			System.out.println("read");
			offset = in.readInt();
			System.out.println(size);
			System.out.println(offset);
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

	}

}
