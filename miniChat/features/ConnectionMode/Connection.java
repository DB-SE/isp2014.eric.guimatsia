import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Connection implements Runnable {

	private Socket socket = null;
	public static Thread t2;
	public static String login = null, pass = null, message1 = null, message2 = null, message3 = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	private boolean connect = false;
	
	public Connection(Socket s){
		
		socket = s;
	}
	
	public void run() {
		
		try {
			
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
	
		
		while(!connect ){
		
		System.out.println(in.readLine());
		login = sc.nextLine();
		out.println(login);
		out.flush();
		
		System.out.println(in.readLine());
		pass = sc.nextLine();
		out.println(pass);
		out.flush();
		
		if(in.readLine().equals("online")){
			
		System.out.println("I'm online "); 
		connect = true;
		  }
		
		else {
			System.err.println("Your credentials are false "); 
		  }
		
	}
			
			t2 = new Thread(new Chat_ClientServer(socket));
			t2.start();
		
		} catch (IOException e) {
			
			System.err.println("Server doen't answer ");
		}
	}

}
