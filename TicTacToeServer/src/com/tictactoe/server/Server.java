package com.tictactoe.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

import com.tictactoe.game.server.ServerGameState;
import com.tictactoe.shared.CommunicationConstants;

public class Server {
	
	static String hostName = "localhost";
	static int portNumber = 4444;
	static ServerSocket serverSocket;
	static Socket clientSocket;
	
	static PrintWriter outputToClient;
	static BufferedReader inputFromClient;
	
	static ServerGameState gameState;
	
	public static void main(String args[])
	{
		try
		{
			serverSocket = new ServerSocket(portNumber);
			clientSocket = serverSocket.accept();
			
			outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
			inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			play();			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	private static void play() {
		String input;
		try {
			while((input = inputFromClient.readLine()) != null) {
				if(input.length() > 0) {
					String result = processInput(input.trim());
					if(result != null) {
						outputToClient.println(result);
					}
				}
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static String processInput(String input) {
		String[] inputParams = input.split(" ");
		if(inputParams.length < 0) {
			return null;
		}
		
		// TODO: Implement
		
		
		return null;
	}
	
	
	
	/**
	static boolean serverHandshake()
	{
		try
		{
			String input = inputFromClient.readLine();
			System.out.println("Message recieved by server is: " + input);
			outputToClient.print("Hello from Server \n");
			outputToClient.flush();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	**/
	
}
