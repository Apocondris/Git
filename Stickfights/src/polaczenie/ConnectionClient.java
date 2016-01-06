package polaczenie;

import java.io.*;
import java.net.*;

public class ConnectionClient{
	int port = 52825;
	String odebrane;
	String wysylane;
	Socket clientSocket;
	public Boolean connected=false;
	
	public ConnectionClient(String ip) {
		try {
			clientSocket = new Socket(ip, port); 
			this.connected = true;
		} catch (IOException e) {
			e.printStackTrace();
			this.connected = false;
		}
	}
	
	public void sendData(String data) throws IOException{

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		out.println(data);
	}
	
	public String getData() throws IOException {
		
		BufferedReader inFromServer = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream()));   
		
		odebrane = inFromServer.readLine();             
		return odebrane;
	}

}
