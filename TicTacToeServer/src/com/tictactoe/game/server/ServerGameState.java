package com.tictactoe.game.server;

public class ServerGameState {
	public static final char MOVE_X = 'X';
	public static final char MOVE_O = 'O';
	public static final char MOVE_DRAW = 'D';
	
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
		// Check for winner
		char currentWinner = isWinner(i);
		
		currentPlay = getNextPlay();
		
	}
	
	private void endGame(char winner)
	{
		if(winner == MOVE_X)
		{
			
		}
		else if (winner == MOVE_O)
		{
			
		}
		else if (winner == MOVE_DRAW)
		{
			
		}
		
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
	
	
	public char isWinner(int play)
	{
		
		if(checkWinner(0,1,2) || checkWinner(3,4,5) || checkWinner(6,7,8) || checkWinner(0,3,6) || checkWinner(1,4,7) || checkWinner(2,5,8) || checkWinner(0,4,8) || checkWinner(2,4,6))
			return currentPlay;
		
		int emptyCellCount = 0;
		for(int i=0; i<9; i++)
		{
			if(board.getCellValue(i) == ' ')
				emptyCellCount++;
		}
		
		if(emptyCellCount == 0)
			return MOVE_DRAW;
		
		return ' ';
	}
	
	private boolean checkWinner(int cell1, int cell2, int cell3)
	{
		if(board.getCellValue(cell1) == board.getCellValue(cell2) && board.getCellValue(2) == board.getCellValue(3))
			return true;
		return false;
	}

}
