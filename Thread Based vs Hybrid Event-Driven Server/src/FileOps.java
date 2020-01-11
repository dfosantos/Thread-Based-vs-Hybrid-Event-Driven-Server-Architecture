import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

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
	
	public void DeleteFile(String path) {
		
	}
}
	
