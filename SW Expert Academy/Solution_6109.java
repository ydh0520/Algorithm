package algo;

import java.util.Scanner;

public class Solution_6109 {
	static int size;
	static int[][] board;

	static int[] rotateCount = { 0, 1, 2, 3 };
	static int[] printCount = { 0, 3, 2, 1 };

	public static void move() {
		int[][] next = new int[size][size];
		for (int i = 0; i < size; i++) {
			int inputIndex = 0;
			int pre = 0;
			int j = 0;
			while (j < size) {
				if (board[i][j] != 0) {
					if (board[i][j] == pre) {
						next[i][inputIndex++] = pre * 2;
						pre = 0;
					} else {
						if (pre != 0) {
							next[i][inputIndex++] = pre;
						}
						pre = board[i][j];
					}
				}
				j++;
			}
			if (pre != 0) {
				next[i][inputIndex++] = pre;
			}
		}
		board = next;
	}

	public static void rotate() {
		int[][] roteated = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				roteated[size - 1 - j][i] = board[i][j];
			}
		}
		board = roteated;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {
			size = scan.nextInt();
			String direction = scan.next();

			board = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					board[i][j] = scan.nextInt();
				}
			}

			int d = 0;
			switch (direction) {
			case "up":
				d = 1;
				break;
			case "right":
				d = 2;
				break;
			case "down":
				d = 3;
				break;
			}

			for (int i = 0; i < rotateCount[d]; i++) {
				rotate();
			}
			move();
			for (int i = 0; i < printCount[d]; i++) {
				rotate();
			}
			print(test_case);

		}
	}

	public static void print(int test_case) {
		System.out.println("#"+test_case);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
