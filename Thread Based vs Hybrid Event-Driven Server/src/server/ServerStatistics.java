package server;

public class ServerStatistics extends Thread{
	
	@Override
	public void run() {
		while(true) {
			System.out.println(java.lang.Thread.activeCount());			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
