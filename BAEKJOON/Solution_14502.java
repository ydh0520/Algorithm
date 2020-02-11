package myalgo;

import java.util.Scanner;

public class Solution_14502 {
	static int size, row, col;
	static int[][] board;
	static int max;

	static void wall(int count) {
		if (count == 3) {
			run();
		} else {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (board[i][j] != 0) {
						continue;
					}
					board[i][j] = 1;
					wall(count + 1);
					board[i][j] = 0;
				}
			}
		}
	}

	static void run() {

		int currentBoard[][] = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				currentBoard[i][j] = board[i][j];
			}
		}

		boolean change = true;

		int[] di = { -1, 1, 0, 0 };
		int[] dj = { 0, 0, -1, 1 };
		while (change) {
			change = false;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (currentBoard[i][j] == 2) {
						for (int d = 0; d <4; d++) {
							int ni = i + di[d];
							int nj = j + dj[d];

							if (ni < 0 || ni >= row || nj < 0 || nj >= col) {
								continue;
							}

							if (currentBoard[ni][nj] == 0) {
								currentBoard[ni][nj] = 2;
								change = true;
							}
						}
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (currentBoard[i][j] == 0)
					count++;
			}
		}
		
		if (max < count)
			max = count;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		row = scan.nextInt();
		col = scan.nextInt();
		max = 0;

		board = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = scan.nextInt();
			}
		}

		wall(0);
		System.out.println(max);
	}
}
