package algo;

import java.util.Scanner;

public class Solution_17144 {
	static int board[][];
	static int row, col;

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	static int[] upi = { -1, 0, 1, 0 };
	static int[] upj = { 0, 1, 0, -1 };

	static int[] downi = { 1, 0, -1, 0 };
	static int[] downj = { 0, 1, 0, -1 };

	static int airupi;
	static int airdowni;

	public static void spread() {
		int[][] next = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int cur = board[i][j];
				int value = cur / 5;

				if (board[i][j] < 0) {
					next[i][j] = board[i][j];
					continue;
				}

				if (board[i][j] == 0)
					continue;

				for (int d = 0; d < 4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (ni < 0 || ni >= row || nj < 0 || nj >= col)
						continue;
					if (board[ni][nj] < 0)
						continue;

					next[ni][nj] += value;
					cur -= value;
				}
				next[i][j] += cur;
			}
		}

		board = next;
	}

	public static void wind() {
		int ci = airupi - 1;
		int cj = 0;
		int d = 0;

		while (true) {
			int ni = ci + upi[d];
			int nj = cj + upj[d];

			if (ni < 0 || ni > airupi || nj < 0 || nj >= col) {
				d++;
				continue;
			}

			if (board[ni][nj] == -1) {
				board[ci][cj] = 0;
				break;
			}

			board[ci][cj] = board[ni][nj];
			ci = ni;
			cj = nj;
		}

		ci = airdowni + 1;
		cj = 0;
		d = 0;
		
		while (true) {
			int ni = ci + downi[d];
			int nj = cj + downj[d];

			if (ni < airdowni || ni >=row || nj < 0 || nj >= col) {
				d++;
				continue;
			}

			if (board[ni][nj] == -1) {
				board[ci][cj] = 0;
				break;
			}

			board[ci][cj] = board[ni][nj];
			ci = ni;
			cj = nj;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		row = scan.nextInt();
		col = scan.nextInt();
		int time = scan.nextInt();

		board = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = scan.nextInt();
				if (board[i][j] == -1) {
					airdowni = i;
				}
			}
		}

		airupi = airdowni - 1;

		for (int i = 0; i < time; i++) {
			spread();
			wind();
		}
		
		int sum = 2;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sum += board[i][j];
			}
		}
		System.out.println(sum);
	}

	public static void print() {

		System.out.println("==");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(board[i][j] + " ");

			}
			System.out.println();
		}

		System.out.println("==");
	}
}
