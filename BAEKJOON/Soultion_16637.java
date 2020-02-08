package day0208;

import java.util.Scanner;
public class Solution_16637 {

	static String input;
	static int size;
	static int max;

	public static int calc(int i, int j, char op) {
		int result = 0;
		switch (op) {
		case '+':
			result = i + j;
			break;
		case '-':
			result = i - j;
			break;
		case '*':
			result = i * j;
			break;
		}
		return result;
	}

	public static void dfs(int result, int index) {
		if (index == size) {
			if (max < result)
				max = result;
		} else {
			char nextop = input.charAt(index + 1);
			int next = input.charAt(index + 2) - '0';

			dfs(calc(result, next, nextop), index + 2);
			if (index + 4 < input.length()) {
				char nextnextop = input.charAt(index + 3);
				int nextnext = input.charAt(index + 4) - '0';

				int nextcal = calc(next, nextnext, nextnextop);

				dfs(calc(result, nextcal, nextop), index + 4);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		input = scan.next();
		max = Integer.MIN_VALUE;
		input = "+" + input;

		dfs(0, -1);

		System.out.println(max);
	}
}
