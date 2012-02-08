import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class ServerTask implements Runnable {
	
	private String id;
	BufferedReader in;	
	public ServerTask(String id, BufferedReader in){
		this.id = id;
		this.in = in;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				// gets messages.
				String msg = in.readLine();
				
				System.out.println("Message: " + msg);
				if(msg==null)
					return;
				
				for(ConnectionObject co : Server.connectoins){
					if(!co.id.equals(id))
						co.out.println(msg);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
		
	}

}
