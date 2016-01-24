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
	
	public void sendData(String[] data) throws IOException{

		String wiadomosc = data[0] + data[1] + data[2] + data[3] + data[4] + data[5] + data[6] + data[7];
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		System.out.println("wyslane - " + wiadomosc);     
		out.println(wiadomosc);
	}
	
	public String getData() throws IOException {
		
		BufferedReader inFromServer = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream()));   
		
		odebrane = inFromServer.readLine();
		System.out.println("odebrane - " + odebrane);     
		return odebrane;
	}

}
