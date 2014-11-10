import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login = "zero", pass =  null;
	public boolean authentifier = false;
	public Thread t2;
	
	public Authentification(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
		while(!authentify){
			
			out.println("Enter your login :");
			out.flush();
			login = in.readLine();
			
			
			out.println("Enter your password :");
			out.flush();
			pass = in.readLine();

			if(isValid(login, pass)){
				
				out.println("connected");
				System.out.println(login +" has just connected ");
				out.flush();
				authentify = true;	
			}
			else {out.println("error"); out.flush();}
		 }
			t2 = new Thread(new Chat_ClientServer(socket,login));
			t2.start();
			
		} catch (IOException e) {
			
			System.err.println(login+" don't answer !");
		}
	}
	
	private static boolean isValid(String login, String pass) {
		
		
		boolean connection = false;
		try {
			Scanner sc = new Scanner(new File("friend.txt"));
			
			
			while(sc.hasNext()){
				if(sc.nextLine().equals(login+" "+pass)){
              	  connection=true;
				  break;
				}
             }
			
		} catch (FileNotFoundException e) {	
			System.err.println("the file doesn't exist !");
		}
	return connection;
		
	}

}
