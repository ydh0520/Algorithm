import java.util.Arrays;
import java.util.Scanner;

public class Soultion_2810 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int size = scan.nextInt();
		String input = scan.next();

		input = input.replace("LL", "*LL*");
		input = input.replace("S", "*S*");
		input = input.replace("**", "*");

		int count = 0;
		char[] holder = input.toCharArray();

		for (int i = 0; i < holder.length; i++) {
			if (holder[i] == 'S' || holder[i] == 'L') {
				char left = holder[i - 1];
				char right = holder[i + 1];

				if (left == '*') {
					holder[i - 1] = '.';
					count++;
					continue;
				}

				if (right == '*') {
					holder[i + 1] = '.';
					count++;
					continue;
				}

			}
		}

		System.out.println(count);
	}
}
