import java.io.*;
import java.net.*;

public class Server {
 public static ServerSocket ss = null;
 public static Thread t;

 
	public static void main(String[] args) {
		
		try {
			ss = new ServerSocket(2014);
			System.out.println("Server listen at port "+ss.getLocalPort());
			
			t = new Thread(new Accept_connexion(ss));
			t.start();
			
		} catch (IOException e) {
			System.err.println("The port "+ss.getLocalPort()+" is already used !");
		}
	
	}

	
	}
