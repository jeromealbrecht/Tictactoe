package com.group2;

public class TestTicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { '\0', '\0', '\0' }, { 'O', '\0', 'X' }, { 'O', '\0', 'X' } };
		boolean hasWon = TicTacToe.isWon(grid);
		System.out.println(hasWon);
	}

}
