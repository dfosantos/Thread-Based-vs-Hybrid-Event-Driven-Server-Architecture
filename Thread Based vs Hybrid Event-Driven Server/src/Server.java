
public class Server {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Proper Usage: \n\tjava Server THREAD \n\tjava Server EVENT");
			System.exit(0);
		}

		if (args[0].equals("THREAD"))
			new ThreadBasedServer().run();

		else if (args[0].equals("EVENT"))
			new EventDrivenServer().run();

	}

}
