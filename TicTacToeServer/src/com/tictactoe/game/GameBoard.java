package com.tictactoe.game;

public class GameBoard {
	private char[] cells;
	
	// Initialize a new blank game board
	public GameBoard() {
		cells = new char[9];
		for(int i=0; i<9; i++)
			cells[i] = ' ';				
	}
	
	public void fillCell(int i, char c) {
		cells[i] = c;
	}
	
	public boolean isCellEmpty(int i) {
		return (cells[i] == ' ');
	}
	
	public char getCellValue(int i) {
		return cells[i];
	}
}
