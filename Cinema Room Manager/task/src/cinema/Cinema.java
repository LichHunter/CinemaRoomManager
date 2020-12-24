package cinema;

import java.util.Scanner;

public class Cinema {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of seats in each row: ");
		int columns = scanner.nextInt();

		String[][] cinemaSeats = createSeats(rows, columns);

		while (true) {
			System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit");
			String input = scanner.next();

			switch (input) {
				case "1":
					showSeats(cinemaSeats);
					break;
				case "2":
					buyATicket(cinemaSeats);
					break;
				case "0":
					return;
			}
		}
	}

	private static void buyATicket(String[][] cinemaSeats) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a row number:");
		int rowOfUserSeat = scanner.nextInt();
		System.out.println("Enter a seat number in that row:");
		int columnOfUserSeat = scanner.nextInt();

		if (cinemaSeats.length * cinemaSeats[0].length < 60) {
			System.out.println("Ticket price: $10");
		} else {
			int firstHalf = (cinemaSeats.length - 1) / 2;
			if (rowOfUserSeat <= firstHalf) {
				System.out.println("Ticket price: $10");
			} else {
				System.out.println("Ticket price: $8");
			}
		}

		cinemaSeats[rowOfUserSeat][columnOfUserSeat] = "B";
	}

	private static void showSeats(String[][] seats) {
		System.out.println("Cinema:");

		for (String[] ss : seats) {
			for (String s : ss) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	private static String[][] createSeats(int rows, int columns) {
		String[][] cinemaSeats = new String[rows + 1][columns + 1];
		cinemaSeats[0][0] = "  ";
		for (int i = 1; i <= columns; i++) {
			cinemaSeats[0][i] = String.valueOf(i);
		}

		for (int i = 1; i < cinemaSeats.length; i++) {
			cinemaSeats[i][0] = String.valueOf(i);
			for (int j = 1; j < cinemaSeats[i].length; j++) {
				cinemaSeats[i][j] = "S";
			}
		}

		return cinemaSeats;
	}
}