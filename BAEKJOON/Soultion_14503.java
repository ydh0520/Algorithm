package day0224;

import java.util.Scanner;

public class Soultion_14503 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();

		int[] di = { -1, 0, 1, 0 };
		int[] dj = { 0, 1, 0, -1 };
		
		int[] bi = { 1, 0, -1, 0 };
		int[] bj = { 0, -1, 0, 1 };

		int ci = scan.nextInt();
		int cj = scan.nextInt();
		int cd = scan.nextInt();

		int[][] board = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = scan.nextInt();
			}
		}

		int count = 0;
		while (true) {
			if (board[ci][cj] == 0) {
				board[ci][cj] = 2;
				count++;
			}

			boolean back = true;

			for (int i = 1; i <= 4; i++) {
				int nd = cd - i;
				if (nd < 0)
					nd += 4;

				int ni = ci + di[nd];
				int nj = cj + dj[nd];

				if (board[ni][nj] == 0) {
					ci = ni;
					cj = nj;
					cd = nd;
					back = false;
					break;
				}
			}

			if (back) {
				int ni = ci + bi[cd];
				int nj = cj + bj[cd];

				if (board[ni][nj] == 1)
					break;
				ci = ni;
				cj = nj;
			}
		}
		System.out.println(count);
	}

	static void print(int[][] arr, int ci, int cj) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (ci == i && cj == j)
					System.out.print("* ");
				else
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
