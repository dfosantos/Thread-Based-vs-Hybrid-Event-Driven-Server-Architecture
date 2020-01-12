package server;

import eventDriven.EventDrivenServer;
import threadBased.ThreadBasedServer;

public class Server {

	public static void main(String[] args) {

		if (args.length != 2 || !(args[0].equals("THREAD") || args[0].equals(("EVENT")))) {
			System.out.println(
					"Proper Usage:\n 1st ARGUMENT: Either THREAD or EVENT\n 2nd ARGUMENT: Port number\n\tEx.: java Server THREAD  \n\tEx.: java Server EVENT");
			System.exit(0);
		}

		if (args[0].equals("THREAD"))
			new ThreadBasedServer(Integer.parseInt(args[1])).run();

		else if (args[0].equals("EVENT"))
			new EventDrivenServer().run();

		else {
			System.out.println("Proper Usage: \n\tjava Server THREAD \n\tjava Server EVENT");
			System.exit(0);
		}

	}

}
