package myalgo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_17135 {

	static int row;
	static int col;
	static int range;
	static int[][] board;
	static boolean[] selected;
	static int max;

	static int[] di;
	static int[] dj;

	public static void select(int[] arr, int count, int start) {
		if (count == 3) {
			rush(arr);
		} else {
			for (int i = start; i < col; i++) {
				if (selected[i])
					continue;

				selected[i] = true;
				arr[count] = i;
				select(arr, count + 1, i + 1);
				selected[i] = false;
			}
		}
	}

	public static void rush(int[] arr) {
		int[][] currentBoard = new int[row][];

		for (int i = 0; i < row; i++) {
			currentBoard[i] = board[i].clone();
		}

		int currentScore = 0;

		for (int i = row - 1; i >= 0; i--) {
			int[] targeti = new int[3];
			int[] targetj = new int[3];
			boolean[] find = new boolean[3];

			for (int j = 0; j < 3; j++) {
				for (int d = 0; d < di.length; d++) {
					int ni = i + di[d];
					int nj = arr[j] + dj[d];

					if (ni < 0 || nj < 0 || nj >= col) {
						continue;
					}

					if (currentBoard[ni][nj] == 1) {
						targeti[j] = ni;
						targetj[j] = nj;
						find[j] = true;
						break;
					}
				}
			}

			for (int j = 0; j < 3; j++) {
				if (find[j]) {
					if (currentBoard[targeti[j]][targetj[j]] == 1) {
						currentBoard[targeti[j]][targetj[j]] = 0;
						currentScore++;
					}
				}
			}

		}

		if (max < currentScore) {
			max = currentScore;
		}

	}

	public static void makeRange() {
		int index = 0;
		for (int i = 0; i < range; i++) {
			for (int j = 0; j <= i; j++) {
				di[index++] = j * -1;
			}
			for (int j = i * -1 + 1; j <= 0; j++) {
				di[index++] = j;
			}

		}
		index = 0;
		for (int i = 0; i < range; i++) {
			for (int j = i * -1; j <= 0; j++) {
				dj[index++] = j;
			}
			for (int j = 1; j <= i; j++) {
				dj[index++] = j;
			}

		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		row = scan.nextInt();
		col = scan.nextInt();
		range = scan.nextInt();

		board = new int[row][col];
		di = new int[range * range];
		dj = new int[range * range];

		makeRange();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = scan.nextInt();
			}
		}

		max = 0;
		selected = new boolean[col];
		select(new int[3], 0, 0);
		System.out.println(max);
	}
}
