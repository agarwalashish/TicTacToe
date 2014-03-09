package com.tictactoe.game;

public class Game {
	public static final char MOVE_X = 'X';
	public static final char MOVE_Y = 'Y';
	
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
	}
	
	private boolean isMoveValid(int i, char c) {
		return (currentPlay == c && board.isCellEmpty(i));
	}

}
