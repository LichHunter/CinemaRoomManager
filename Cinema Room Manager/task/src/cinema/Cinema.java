package cinema;

import java.util.Scanner;

public class Cinema {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.println("Enter the number of seats in each row: ");
		int columns = scanner.nextInt();

		if (rows * columns < 60) {
			System.out.println("Total income: \n$" + rows * columns * 10);
		} else {
			int firstHalf = rows / 2;
			System.out.println("Total income: \n$"
					+ (firstHalf * columns * 10 + (rows - firstHalf) * columns * 8));
		}
	}
}