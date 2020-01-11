import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileOps {
	
	public void WriteMiddleOfFile(long pos,String path,String data){
		RandomAccessFile f;
		try {
			f = new RandomAccessFile(new File(path), "rw");
			f.seek(pos); 
		    f.write(data.getBytes());
		    f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	}
	
	public void ReadFromFile(long pos, String path){
		RandomAccessFile f;
		try {
		    FileReader fr = new FileReader(path); 
		    int i; 
		    while ((i=fr.read()) != -1) 
		      System.out.print((char) i); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
