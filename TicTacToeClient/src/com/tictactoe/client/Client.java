package com.tictactoe.client;

import java.net.*;
import java.io.*;

import com.tictactoe.game.client.ClientGameState;
import com.tictactoe.shared.CommunicationConstants;

public class Client {
	
	static String hostName = "localhost";
	static int portNumber = 4444;
	
	static Socket socket;
	static PrintWriter outputToServer;
	static BufferedReader inputFromServer;
	static BufferedReader stdIn;
	
	static ClientGameState gameState;
	
	public static void main(String[] args) {
		
		try
		{
			socket = new Socket("localhost", portNumber);
			outputToServer = new PrintWriter(socket.getOutputStream(), true);
			inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
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
			outputToServer.println(CommunicationConstants.NEW_GAME);
			while((input = inputFromServer.readLine()) != null) {
				if(input.length() > 0) {
					String result = processInput(input.trim());
					if(result != null && result.length() > 0) {
						outputToServer.println(result);
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
	
	private static int nextMove() {
		try {
			System.out.println("Player " + gameState.getCurrentPlay() + ", enter move.");
			String cellNum = stdIn.readLine();
			return Integer.parseInt(cellNum);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("An error ocurred, please try again");
			nextMove();
		}
		return -1;
	}
	
	
	/**
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
	**/

}
