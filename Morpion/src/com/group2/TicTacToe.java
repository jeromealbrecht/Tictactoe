package com.group2;

public class TicTacToe {
	public static final char PLAYER_1 = 'X';
	public static final char PLAYER_2 = 'O';
	static char[][] grid = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	static int turn = 1;
	static char[] xy = { '\0', '\0' };
	static char player = '\0';
	static boolean isPlayerWin = false;

	// TODO
	public static void displayGameOver() {

	}

	// TODO
	public static void displayRules() {

	}

	// TODO ZEDOUN
	public static void displayGrid() {

	}

	// TODO ZEDOUN
	public static void displayWelcome() {

	}

	// TODO JEROME
	public static char[] chooseCase(char x, char y) {
		xy[0] = x;
		xy[1] = y;
		return xy;
	}

	// TODO ALICIA
	public static boolean checkWin() {
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

	// TODO ALICIA
	public static void fillCase() throws Exception {
		int x = -1;
		int y = Integer.parseInt(String.valueOf(xy[1])) - 1;

		if (xy[0] == 'A') {
			x = 0;
		} else if (xy[0] == 'B') {
			x = 1;
		} else if (xy[0] == 'C') {
			x = 2;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (x == j && y == i && grid[i][j] == '\0') {
					grid[i][j] = player;
					return;
				}
			}
		}
		throw new Exception("La case aux coordonnées (" + xy[0] + ", " + xy[1] + ") est déjà occupée.");
	}

	// TODO ALICIA
	public static void playNextTurn() {
		boolean isInvalid;
		do {
			isInvalid = false;
			try {
				System.out.println("\nTour: " + turn);
				System.out.println("C'est au tour du joueur " + player + " de jouer.");
				// en mode test valeur fixe avec x = A et y = 2
				xy = chooseCase('A', '2');
				fillCase();
				turn++;
			} catch (Exception e) {
				isInvalid = true;
				System.out.println(e.getMessage());
				System.out.println("Merci de choisir une autre case.");
			}
		} while (isInvalid);
	}

	// TODO ALICIA
	public static void play2player() {
		// en mode test turn = 1 sinon turn = 9
		while (turn <= 9 && !isPlayerWin) {
			// Choisi le joueur
			player = (turn % 2 == 0) ? PLAYER_2 : PLAYER_1;
			playNextTurn();
			if (turn >= 5) {
				isPlayerWin = checkWin();
			}
			displayGrid();
		}
		displayGameOver();
	}
}
