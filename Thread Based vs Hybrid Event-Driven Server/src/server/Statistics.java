package server;

import java.util.ArrayList;

import eventDriven.EventDrivenServer;

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
				averageTimePerClient = (float) (clientTimes.get(0) / 1000000.0);
				clientTimes.clear();
			}

			if (Server.server.equals("EVENT"))
				Statistics.activeThreads = EventDrivenServer.executor.getActiveCount();
			else
				Statistics.activeThreads = java.lang.Thread.activeCount();
			ServerStatisticsGUI.lblNewLabel_3.setText(String.valueOf(CPS));
			ServerStatisticsGUI.label.setText(String.valueOf(averageTimePerClient) + "ms");
			ServerStatisticsGUI.label_2.setText(String.valueOf(activeThreads));
			ServerStatisticsGUI.lblNewLabel_6.setText(String.valueOf(EventDrivenServer.FIFO.size()));

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
