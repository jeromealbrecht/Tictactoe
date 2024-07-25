package com.group2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
	public static final char PLAYER_1 = 'X';
	public static final char PLAYER_2 = 'O';
	static char[][] grid = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	static int turn = 1;
	static int[] xy = { -1, -1 };
	static char player = '\0';
	static boolean isPlayerWin = false;

	// TODO JEROME
	public static void displayGameOver() {
		System.out.println(" GAME OVER ");
	}

	// TODO
	public static void displayRules() {

	}

	// TODO ZEDOUN
	public static void displayGrid(char[][] grid) {

		for (int i = 0; i < 3; i++) {
			if (i > 0) {
				System.out.println("---+---+---");
			}
			for (int j = 0; j < 3; j++) {
				if (j < 2) {
					System.out.print(" " + grid[i][j] + " |");
				} else {
					System.out.println(" " + grid[i][j]);
				}

			}
			System.out.println();
		}

	}

	// TODO ZEDOUN
	public static void displayWelcome() {

		System.out.println("* welcome to MORPION ");
		System.out.println(" bienvenu à Morpion *");

	}

	// TODO JEROME
	public static void chooseCase() {
		Scanner scan = new Scanner(System.in);

		boolean validInput = false;
		while (!validInput) {
			try {
				// Récupération des abscisses
				System.out.println("Choisir emplacement abscisses (1-3)");
				boolean isAbs = false;
				int abs = scan.nextInt();
				while (!isAbs) {
					if (abs < 1 || abs > 3) {
						System.out.println("Entrée invalide. Merci de rentrer une valeur comprise entre 1 et 3 : ");
						abs = scan.nextInt();

					} else {
						isAbs = true;
					}
				}
				// Récupération des ordonnées
				System.out.println("Choisir emplacement ordonnées (1-3)");
				boolean isOrd = false;
				int ord = scan.nextInt();
				while (!isOrd) {
					if (ord < 1 || ord > 3) {
						System.out.println("Entrée invalide. Merci de rentrer une valeur comprise entre 1 et 3 : ");
						ord = scan.nextInt();

					} else {
						isOrd = true;
					}
				}

				abs -= 1;
				ord -= 1;

				validInput = true;
			
				xy[0] = abs;
				xy[1] = ord;
			} catch (InputMismatchException e) {
				System.out.println("Entrée invalide. Veuillez entrer des chiffres seulement.");
				scan.next();
			}

		}

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
		int x = xy[0];
		int y = xy[1];
		// int y = Integer.parseInt(String.valueOf(xy[1])) - 1;

//		if (xy[0] == 'A') {
//			x = 0;
//		} else if (xy[0] == 'B') {
//			x = 1;
//		} else if (xy[0] == 'C') {
//			x = 2;
//		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (x == j && y == i && grid[i][j] == '\0') {
					grid[i][j] = player;
					return;
				}
			}
		}
		throw new Exception("La case aux coordonnées (" + (xy[0] + 1) + ", " + (xy[1] + 1) + ") est déjà occupée.");
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
				chooseCase();
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
			displayGrid(grid);
		}
		displayGameOver();
	}
}
