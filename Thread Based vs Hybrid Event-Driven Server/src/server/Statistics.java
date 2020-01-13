package server;

import java.util.ArrayList;

public class Statistics extends Thread{
	
	
	public static float CPS;
	public static float averageTimePerClient;
	public static int activeThreads;
	public static ArrayList<Long> clientTimes = new ArrayList<>();
	
	@Override
	public void run() {
		while(true) {
			Statistics.activeThreads = java.lang.Thread.activeCount();		
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
