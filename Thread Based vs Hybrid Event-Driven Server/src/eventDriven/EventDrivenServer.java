package eventDriven;
import java.util.ArrayList;

public class EventDrivenServer implements Runnable{

	@Override
	public void run() {
		System.out.println("Running Event Driven Server");
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		long t = System.currentTimeMillis();
		int threadNumber = 1;
		ArrayList<Thread> threads = new ArrayList<>();

		for (int i = 0; i < threadNumber; i++) {
			Thread thread = new test();
			thread.start();
			threads.add(thread);
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
