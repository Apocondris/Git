package polaczenie;

import java.io.*;
import java.net.*;
import java.util.concurrent.Callable;

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
	public void sendData(Object data) throws IOException{

		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());   
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in)); 

		outToClient.writeBytes((String) data); 
	}
	
	//TODO -- zmieniæ typ danych
	public Object getData() throws IOException {
		
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
