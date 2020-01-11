
public class ClientCreator {

	public static void main(String[] args) {
		
		if (args.length != 2 ) {
			System.out.println(
					"Proper Usage:\n 1st ARGUMENT: Server IP\n 2nd ARGUMENT: Port number\n\tEx.: java ClientCreator 192.168.1.125 12345");
			System.exit(0);
		}

	}

}
