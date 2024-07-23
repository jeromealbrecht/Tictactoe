package com.group2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
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
	public static char[][] chooseCase(char[][] grid, char player) {
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

				for (int i = 1; i <= grid.length; i++) {
					for (int j = 1; j <= grid.length; j++) {
						System.out.println("hello2 " + i + " " + j + " " + abs + " " + ord);
						if (i == abs && j == ord) {
							System.out.println(grid[i][j] + "grid");
							grid[i][j] = player;
							System.out.println("hello");
						}
					}
				}

			} catch (InputMismatchException e) {
				System.out.println("Entrée invalide. Veuillez entrer des chiffres seulement.");
				scan.next();
			}

		}

		scan.close();
		return grid;

	}

	// TODO ALICIA
	public static boolean game() {
		boolean isWin = true;
		return isWin;
	}
}
