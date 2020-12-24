package cinema;

public class Cinema {
	public static void main(String[] args) {
		System.out.println("Cinema:");
		System.out.print("  ");
		for (int i = 0; i < 8; i++) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();

		for (int i = 0; i < 7; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print("S ");
			}
			System.out.println();
		}
	}
}