package server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import eventDriven.EventDrivenServer;
import eventDriven.FIFO;
import threadBased.ThreadBasedServer;

public class Statistics extends Thread {

	public static float CPS;
	public static float averageTimePerClient = 0;
	public static float debit = 0;
	public static int activeThreads;
	public static ArrayList<Long> clientTimes = new ArrayList<>();
	public static ArrayList<Float> clientDebits = new ArrayList<>();
	public static boolean stop = false;

	@Override
	public void run() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File("files/test.csv"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		sb.append("CPS;TimePerClient;ActiveThreads");
		sb.append("\n");

		while (true) {
			if (!clientTimes.isEmpty()) {
				averageTimePerClient = (float) (clientTimes.get(0) / 1000000.0);
				clientTimes.clear();
				sb.append(String.valueOf(CPS) + ";" + averageTimePerClient + ";" + activeThreads + "\n");
			}

			if (Server.server.equals("EVENT"))
				Statistics.activeThreads = EventDrivenServer.executor.getActiveCount();
			else
				Statistics.activeThreads = java.lang.Thread.activeCount() - 3;
			ServerStatisticsGUI.lblNewLabel_3.setText(String.valueOf(CPS));
			ServerStatisticsGUI.label.setText(String.valueOf(averageTimePerClient) + "ms");
			ServerStatisticsGUI.label_2.setText(String.valueOf(activeThreads));
			ServerStatisticsGUI.lblNewLabel_6.setText(String.valueOf(EventDrivenServer.FIFO.size()));
			if (stop) {
				writer.write(sb.toString());
				writer.close();
			}
			try {
				if (ThreadBasedServer.CPS < 5000) {
					ThreadBasedServer.CPS++;
					FIFO.CPS++;
				}

				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
