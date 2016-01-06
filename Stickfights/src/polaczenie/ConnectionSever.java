package polaczenie;

import java.io.*;
import java.net.*;

public class ConnectionSever implements Runnable{
	int port = 52825;
	String odebrane;
	String wysylane;
	ServerSocket serverSocket;
	Socket connectionSocket;  
	public Boolean connected=false;
	
	public ConnectionSever() {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.connected = false;
	}
	
	//TODO -- zmieniæ typ danych
	public void sendData(String data) throws IOException{

		PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);
		out.println(data);
	}
	
	//TODO -- zmieniæ typ danych
	public String getData() throws IOException {
		
		BufferedReader inFromClient = new BufferedReader(
				new InputStreamReader(connectionSocket.getInputStream()));                       
		odebrane = inFromClient.readLine();             
		return odebrane;
	}

	@Override
	public void run() {
		try {
			connectionSocket = serverSocket.accept();
			connected = true;
		} catch (IOException e) {
		}
	}
}
