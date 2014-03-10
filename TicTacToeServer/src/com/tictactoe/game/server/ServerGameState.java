package com.tictactoe.game.server;

public class ServerGameState {
	public static final char MOVE_X = 'X';
	public static final char MOVE_O = 'O';
	
	private char currentPlay;
	private GameBoard board;
	
	public ServerGameState() {
		board = new GameBoard();
		currentPlay = MOVE_X;
	}
	
	public void movePlayed(int i, char c) {
		if(!isMoveValid(i, c)) {
			// TODO: Handle this scenario
		}
		
		board.fillCell(i, c);
		currentPlay = getNextPlay();
	}
	
	private boolean isMoveValid(int i, char c) {
		// TODO: Split these two checks and return specific error messages in case of invalid moves.
		return (currentPlay == c && board.isCellEmpty(i));
	}
	
	private char getNextPlay() {
		if(currentPlay == MOVE_X)
			return MOVE_O;
		return MOVE_X;
	}
	
	public char getCurrentPlay() {
		return currentPlay;
	}

}
