package polaczenie;

import java.io.*;
import java.net.*;

import engine.Vector2F;

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
	
	public void sendData(String[] data) throws IOException{
		String wiadomosc = data[0] + data[1] + data[2] + data[3] + data[4] + data[5] + data[6] + data[7];
		PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);
		out.println(wiadomosc);
	}
	
	public void sendData(String data) throws IOException{
		PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);
		out.println(data);
	}
	
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

	public void sendPos(Object pos) {
		
	}

	public Vector2F getPos() {
		return null;
	}
}
