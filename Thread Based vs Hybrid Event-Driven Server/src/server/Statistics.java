package server;

import java.util.ArrayList;

public class Statistics extends Thread {

	public static float CPS;
	public static float averageTimePerClient = 0;
	public static float debit = 0;
	public static int activeThreads;
	public static ArrayList<Long> clientTimes = new ArrayList<>();
	public static ArrayList<Float> clientDebits = new ArrayList<>();

	@Override
	public void run() {
		while (true) {
			if (!clientTimes.isEmpty()) {
				averageTimePerClient = clientTimes.get(0);
				clientTimes.clear();
			}

			Statistics.activeThreads = java.lang.Thread.activeCount();
			ServerStatisticsGUI.lblNewLabel_3.setText(String.valueOf(CPS));
			ServerStatisticsGUI.label.setText(String.valueOf(averageTimePerClient));
			ServerStatisticsGUI.label_2.setText(String.valueOf(activeThreads));

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
