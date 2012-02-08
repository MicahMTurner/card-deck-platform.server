import java.io.BufferedReader;
import java.io.PrintWriter;


public class ConnectionObject {
	
	public ConnectionObject(){}
	
	
	
	public ConnectionObject(PrintWriter out, BufferedReader in, String id){
		this.out = out;
		this.in = in;
		this.id = id;
	}
	
	public PrintWriter out;
	public BufferedReader in;
	public String id;
}
