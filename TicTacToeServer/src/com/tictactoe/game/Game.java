package com.tictactoe.game;

public class Game {
	public static final char MOVE_X = 'X';
	public static final char MOVE_O = 'O';
	
	private char currentPlay;
	private GameBoard board;
	
	public Game() {
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
