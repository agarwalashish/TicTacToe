package com.tictactoe.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class GameServer {
	
	static String hostName = "localhost";
	static int portNumber = 4444;
	static ServerSocket serverSocket;
	static Socket clientSocket;
	
	static PrintWriter outputToClient;
	static BufferedReader inputFromClient;
	
	public static void main(String args[])
	{
		try
		{
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Server socket created. Waiting for connection...");
			clientSocket = serverSocket.accept();
			
			outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
			inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			System.out.println("Server waiting for handshake initiantion");
			serverHandshake();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	static boolean serverHandshake()
	{
		try
		{
			String input = inputFromClient.readLine();
			System.out.println("Message recieved by server is: " + input);
			outputToClient.print("Hello from Server");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
