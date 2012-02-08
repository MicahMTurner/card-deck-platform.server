import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


public class Server {
	public static ArrayList<ConnectionObject> connectoins = new ArrayList<ConnectionObject>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		ServerSocket serverSocket = new ServerSocket(9998);
		while(true){
			
			Socket clientSocket;
			System.out.println("Waiting for messages...");
			clientSocket = serverSocket.accept();
			System.out.println("connection request from from " + clientSocket.getRemoteSocketAddress().toString());
			
			final PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
			BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			connectoins.add(new ConnectionObject(out, in, clientSocket.getRemoteSocketAddress().toString()));
			
		    new Thread(new ServerTask(clientSocket.getRemoteSocketAddress().toString(),in)).start();
	    }
	}
	   
    
}
