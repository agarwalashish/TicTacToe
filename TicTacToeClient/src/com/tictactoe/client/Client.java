package com.tictactoe.client;

import java.net.*;
import java.io.*;

public class Client {
	
	static String hostName = "localhost";
	static int portNumber = 4444;
	
	static Socket socket;
	static PrintWriter outputToServer;
	static BufferedReader inputFromServer;
	
	public static void main(String[] args) {
		
		try
		{
			socket = new Socket("localhost", portNumber);
			outputToServer = new PrintWriter(socket.getOutputStream(), true);
			inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
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
			outputToServer.print("Hey, this is a client \n");
			outputToServer.flush();
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
