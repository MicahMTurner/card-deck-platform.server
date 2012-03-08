import communication.server.Server;
public class ServerStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server s = new Server();
		try{
			s.start();
		}
		catch(Exception e){
			
		}
	}

}
