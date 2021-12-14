package amazon;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/design-tic-tac-toe/
 * https://leetcode.com/problems/design-tic-tac-toe/solution/
 */
public class _348TicTacToe {

	private int[][]ticTacToeBoard = new int[3][3];
	/*
	 * we're going to implement the brute-force from the available solution
	 */
	public boolean ticTacToeWinner(int row, int col, int player) {
		ticTacToeBoard[row][col] = player;
		if(checkRow(row, col, player)||
				checkCol(row, col, player)||
				checkDiagonal(row, col, player)||
				checkAntiDiagonal(row, col, player)
				)
			return true;
		return false;
	}
	
	public boolean checkRow(int row, int col, int player) {
		for(int i=0;i<3;i++)
			if(ticTacToeBoard[row][i]!=player)
				return false;
		return true;
	}
	

	public boolean checkCol(int row, int col, int player) {
		for(int i=0;i<3;i++)
			if(ticTacToeBoard[i][col]!=player)
				return false;
		return true;
	}
	

	public boolean checkDiagonal(int row, int col, int player) {
		for(int i=0;i<3;i++)
			if(ticTacToeBoard[i][i]!=player)
				return false;
		return true;
	}
	
	public boolean checkAntiDiagonal(int row, int col, int player) {
		for(int i=0;i<3;i++)
			if(ticTacToeBoard[i][3-i-1]!=player)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		
	int [][] moves = {
			{0, 0, 1}, 
			{0, 2, 2}, 
			{2, 2, 1}, 
			{1, 1, 2}, 
			{2, 0, 1}, 
			{1, 0, 2}, 
			{2, 1, 1}	
	};
	
	_348TicTacToe obj = new _348TicTacToe();
	for(int i=0;i<moves.length;i++)
		if(obj.ticTacToeWinner(moves[i][0], moves[i][1], moves[i][2])) {
			System.out.println("player "+moves[i][2]+" is the winner");
			break;
		}
	
	}

}
