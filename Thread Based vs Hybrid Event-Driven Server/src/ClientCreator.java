import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientCreator {

	static int ConnectionsPerSecond;
	static InetAddress ip;
	static int port;
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println(
					"Proper Usage:\n 1st ARGUMENT: Server IP\n 2nd ARGUMENT: Port number\n\tEx.: java ClientCreator 192.168.1.125 12345");
			System.exit(0);
		}
		
		try {
			ip = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
			System.exit(0);
		}
		
		port = Integer.parseInt(args[1]) ;
		Statistics stats = new Statistics();
		
		new KeyListener(stats).run();

		while (true) {
			
			Socket s = new Socket();
			
			
			
			try {
				Thread.sleep(1000/stats.ConnectionsPerSecond);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(stats.ConnectionsPerSecond);
		}

	}
	
    public static class Statistics {
        public int ConnectionsPerSecond = 1;
    }

}
