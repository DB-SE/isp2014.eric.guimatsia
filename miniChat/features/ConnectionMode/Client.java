import java.io.*;
import java.net.*;

public class Client {

	public static Socket socket = null;
	public static Thread t1;
	
	public static void main(String[] args) {
	
		
	try {
		
		System.out.println("Asking for Connection");
		socket = new Socket("127.0.0.1",2014);
		System.out.println("Connection with the Server is going on, authentification :"); // if this msg displays that means client is connected
		
		t1 = new Thread(new Connection(socket));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible to get connected at the adress "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("No server is listenig to port "+socket.getLocalPort());
	}
	
	

	}

}
