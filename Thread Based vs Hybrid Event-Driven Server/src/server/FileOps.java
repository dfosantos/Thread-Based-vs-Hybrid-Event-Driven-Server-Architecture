package server;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.*;

public interface FileOps {

	public static void write(int pos, String path, String data) {
		RandomAccessFile f;
		try {
			f = new RandomAccessFile(new File(path), "rw");
			f.seek(pos);
			f.write(data.getBytes());
			f.close();
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

	public static void read(int pos, String path) {
		RandomAccessFile f;

		try {
			FileReader fr = new FileReader(path);
			int i;
			while ((i = fr.read()) != -1)
				;

			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] NIO_Read(String path, int size, long offset) {
		RandomAccessFile file;
		FileChannel channel;
		ByteBuffer buf = null;

		try {
			file = new RandomAccessFile(path, "r");
			channel = file.getChannel();
			channel.position(offset);
			buf = ByteBuffer.allocate(size);
			channel.read(buf);
			buf.flip();
			channel.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return buf.array();
	}

	public static void NIO_Write(String path, byte[] data) {

		RandomAccessFile file;
		FileChannel channel;
		ByteBuffer buffer = null;
		
		try {
			file = new RandomAccessFile(path, "rw");
			channel = file.getChannel();
			buffer = ByteBuffer.allocate(data.length);
			buffer.put(data);
			buffer.flip();
			channel.write(buffer);
			channel.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
