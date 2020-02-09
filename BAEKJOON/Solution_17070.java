package day0209;

import java.util.Scanner;

public class Soultion_17070 {
	static int[][] board;
	static int size;
	static int result;

	static int[][] ds = { { 0, 2 }, { 1, 2 }, { 0, 1, 2 } };
	static int[][] di = { { 0, 1 }, { 1, 1 }, { 0, 1, 1 } };
	static int[][] dj = { { 1, 1 }, { 0, 1 }, { 1, 0, 1 } };

	static int[][] ci = { { 0 }, { 1 }, { 0, 1, 1 } };
	static int[][] cj = { { 1 }, { 0 }, { 1, 0, 1 } };

	static boolean check(int i, int j, int s) {
		boolean result = true;

		for (int d = 0; d < ci[s].length; d++) {
			int ni = i + ci[s][d];
			int nj = j + cj[s][d];

			if (board[ni][nj] == 1) {
				result = false;
			}
		}

		return result;
	}

	static void next(int i, int j, int s) {
		if (i == size - 1 && j == size - 1) {
			result++;
		} else {
			for (int d = 0; d < di[s].length; d++) {
				int ni = i + di[s][d];
				int nj = j + dj[s][d];

				if (ni < 0 || ni >= size || nj < 0 || nj >= size) {
					continue;
				}
				if (check(i, j, ds[s][d]))
					next(ni, nj, ds[s][d]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		size = scan.nextInt();
		result = 0;

		board = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = scan.nextInt();
			}
		}

		next(0, 1, 0);
		System.out.println(result);
	}
}
