import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import communication.messages.*;


public class Server {
	public static String[] cardCollection = {"c2","c3","c4","c5","c6","c7","c8","c8","c9","c10","ca","cj","ck","cq",
											 "d2","d3","d4","d5","d6","d7","d8","d8","d9","d10","da","dj","dk","dq",
											 "h2","h3","h4","h5","h6","h7","h8","h8","h9","h10","ha","hj","hk","hq",
											 "s2","s3","s4","s5","s6","s7","s8","s8","s9","s10","sa","sj","sk","sq"};
	
	
	
	public static ArrayList<ConnectionObject> connectoins = new ArrayList<ConnectionObject>();
	
	static ArrayList<String> player1Cards = new ArrayList<String>();
	static ArrayList<String> player2Cards = new ArrayList<String>();
	
	private static void onLoad(){
		ArrayList<String> cards = new ArrayList<String>();
		
		for(String s : cardCollection)
			cards.add(s);
		
		Random generator = new Random();
		
		// give cards to player 1.
		for(int i=0 ; i<6; i++){
			int cardIndex = generator.nextInt(cards.size());
			player1Cards.add(cards.get(cardIndex));
			cards.remove(cardIndex);
		}
		
		
		// give cards to player 2.
		for(int i=0 ; i<6; i++){
			int cardIndex = generator.nextInt(cards.size());
			player1Cards.add(cards.get(cardIndex));
			cards.remove(cardIndex);
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		onLoad();
		
		
		
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
