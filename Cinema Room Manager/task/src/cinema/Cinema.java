package cinema;

import java.util.Scanner;

public class Cinema {
	private static int INCOME = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of seats in each row: ");
		int columns = scanner.nextInt();

		String[][] cinemaSeats = createSeats(rows, columns);

		while (true) {
			System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
			String input = scanner.next();

			switch (input) {
				case "1":
					showSeats(cinemaSeats);
					break;
				case "2":
					buyATicket(cinemaSeats);
					break;
				case "3":
					showStatistics(cinemaSeats);
					break;
				case "0":
					return;
			}
		}
	}

	private static void buyATicket(String[][] cinemaSeats) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Enter a row number:");
			int rowOfUserSeat = scanner.nextInt();
			System.out.println("Enter a seat number in that row:");
			int columnOfUserSeat = scanner.nextInt();

			if (rowOfUserSeat >= cinemaSeats.length || columnOfUserSeat >= cinemaSeats[0].length) {
				System.out.println("Wrong input!");
			} else {
				if (cinemaSeats[rowOfUserSeat][columnOfUserSeat].equals("B")) {
					System.out.println("That ticket has already been purchased!");
				} else {
					if (cinemaSeats.length * cinemaSeats[0].length < 60) {
						System.out.println("Ticket price: $10");
						INCOME += 10;
					} else {
						int firstHalf = (cinemaSeats.length - 1) / 2;
						if (rowOfUserSeat <= firstHalf) {
							System.out.println("Ticket price: $10");
							INCOME += 10;
						} else {
							System.out.println("Ticket price: $8");
							INCOME += 8;
						}
					}

					cinemaSeats[rowOfUserSeat][columnOfUserSeat] = "B";
					break;
				}
			}
		}
	}

	private static void showSeats(String[][] seats) {
		System.out.println("Cinema:");

		for (String[] row : seats) {
			for (String seat : row) {
				System.out.print(seat + " ");
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

	private static void showStatistics(String[][] seats) {
		//number of purchased tickets
		int counter = 0;
		for (String[] row : seats) {
			for (String seat : row) {
				if (seat.equals("B")) counter++;
			}
		}
		System.out.format("Number of purchased tickets: %d", counter);

		//purchased tickets as %
		int numberOfSeats = ((seats.length - 1) * (seats[0].length - 1));
		double percentage = ((100 * counter) / (double) numberOfSeats);
		System.out.format("\nPercentage: %.2f%%", percentage);

		//income
		System.out.format("\nCurrent income: $%d", INCOME);

		//total income
		int totalIncome = numberOfSeats < 60 ?
				numberOfSeats * 10
				:
				((seats.length - 1) / 2) * (seats[0].length - 1) * 10
						+ (seats.length - 1 - ((seats.length - 1) / 2)) * (seats[0].length - 1) * 8;

		System.out.format("\nTotal income: $%d\n", totalIncome);
	}
}