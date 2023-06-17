import java.io.IOException;

public class test {
	public static void main(String[] args) {
		try {
			fun();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static int fun() throws IOException {
		int i = 10;

		return switch (i) {
			case 10 -> throw new IOException();
			case 11 -> i + 10;
			default -> i+ 20;
		};
	}
}
