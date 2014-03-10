package com.tictactoe.game.client;

public class ClientGameState {
	private char currentPlay= ' ';
	
	public char getCurrentPlay() {
		return currentPlay;
	}
	
	public void setCurrentPlay(char c) {
		currentPlay = c;
	}

}
