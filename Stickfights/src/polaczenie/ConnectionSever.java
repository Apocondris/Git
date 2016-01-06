package polaczenie;

import java.io.*;
import java.net.*;

public class ConnectionSever {
	int port = 10001;
	String odebrane;
	String wysylane;
	ServerSocket serverSocket;
	Socket connectionSocket;  
	
	public ConnectionSever() {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForConnection(){
		// czekamy na zg³oszenie klienta ...
		try {
			connectionSocket = serverSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO -- zmieniæ typ danych
	public void sendData(Object data) throws IOException{
		// wysylanie
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());   
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in)); 

		outToClient.writeBytes((String) data); 
	}
	
	//TODO -- zmieniæ typ danych
	public Object getData() throws IOException {
		//odbieranie
		BufferedReader inFromClient = new BufferedReader(
				new InputStreamReader(connectionSocket.getInputStream()));                       
		odebrane = inFromClient.readLine();             
		return odebrane;
	}
}
