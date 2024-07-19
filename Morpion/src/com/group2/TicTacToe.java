package com.group2;

public class TicTacToe {
	public static final char PLAYER_1 = 'O';
	public static final char PLAYER_2 = 'X';

	// TODO
	public static void displayGameOver() {

	}

// TODO 
	public static void displayRules() {

	}

	// TODO ZEDOUN
	public static void diplayGrid() {

	}

	// TODO ZEDOUN
	public static void displayWelcome() {

	}

	// TODO JEROME
	public static int[] chooseCase() {
		int[] cases = { 0, 0 };
		return cases;
	}

	// TODO ALICIA
	public static boolean isWon(char[][] grid) {
		// Test les lignes
		for (int i = 0; i < 3; i++) {
			if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != '\0') {
				return true;
			}
		}
		// Test les colonnes
		for (int i = 0; i < 3; i++) {
			if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != '\0') {
				return true;
			}
		}
		// Test les diagonales
		if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '\0') {
			return true;
		}
		if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != '\0') {
			return true;
		}
		return false;
	}
}
