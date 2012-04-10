import war.War;
import logic.client.Game;
import logic.host.Host;
//import communication.server.Server;
public class ServerStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new War();
		Host host = new Host(game);
		try{
			host.run();
		}
		catch(Exception e){
			
		}
	}

}
