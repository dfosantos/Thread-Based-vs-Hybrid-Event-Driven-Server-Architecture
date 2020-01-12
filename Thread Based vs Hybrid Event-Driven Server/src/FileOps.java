import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.FileChannel;

public class FileOps {
	
	public static void main(String[] args) {
		//FileOps.WriteMiddleOfFile(10,"c:\\Testes\\s.mkv","haha");
		FileOps.ReadFromFile(0,"c:\\Testes\\s.mkv");
		System.out.println("Done");
	}
	public static void WriteMiddleOfFile(long pos,String path,String data){
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

	
	public static void ReadFromFile(long pos, String path){
		RandomAccessFile f;
		
		try {
		    FileReader fr = new FileReader(path); 
		    int i; 
		    while ((i=fr.read()) != -1) {
		      System.out.print((char) i);
		    }
		    fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void NIO_Read(String path, int size) {
		try {
			RandomAccessFile file = new RandomAccessFile(new File(path), "wr");
			FileChannel channel = file.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(size);
			int nrBytes = channel.read(buf);
			while(nrBytes!= -1){
				buf.flip();
				while(buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}
				buf.clear();
				nrBytes= channel.read(buf);
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void NIO_Write(String path, int size, String data) {
		try {
			RandomAccessFile file = new RandomAccessFile(new File(path), "wr");
			FileChannel channel = file.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(size);
			buf.put(data.getBytes());
			int nrBytes = channel.write(buf);
			while(nrBytes!= -1){
				buf.flip();
				while(buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}
				buf.clear();
				nrBytes= channel.write(buf);
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
