package com.tictactoe.client;

import java.net.*;
import java.io.*;

public class GameClient {
	
	static String hostName = "localhost";
	static int portNumber = 4444;
	
	static Socket socket;
	static PrintWriter outputToServer;
	static BufferedReader inputFromServer;
	
	public static void main(String[] args) {
		
		try
		{
			System.out.println("Client starting");
			socket = new Socket("localhost", portNumber);
			outputToServer = new PrintWriter(socket.getOutputStream(), true);
			inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			System.out.println("Going to create a handshake");
			clientHandshake();
		}
		catch (Exception e)
		{
			
		}
	}
	
	static boolean clientHandshake()
	{
		try
		{
			outputToServer.write("Hey, this is a client \n");
			outputToServer.flush();
			System.out.println("Sent a message to the server");
			
			String input = inputFromServer.readLine();
			System.out.println("Message recieved by client is: " + input);
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}

}
