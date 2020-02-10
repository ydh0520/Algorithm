package myalgo;

import java.util.Scanner;

public class Solution_14499 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();
		int ci = scan.nextInt();
		int cj = scan.nextInt();
		int cmd = scan.nextInt();

		int[] di = { 0, 0, 0, -1, 1 };
		int[] dj = { 0, 1, -1, 0, 0 };

		int[][] board = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = scan.nextInt();
			}
		}

		Node dice = new Node();

		for (int c = 0; c < cmd; c++) {
			int d = scan.nextInt();

			int ni = ci + di[d];
			int nj = cj + dj[d];

			if (ni < 0 || ni >= row || nj < 0 || nj >= col)
				continue;

			ci = ni;
			cj = nj;

			switch (d) {
			case 1:
				dice.right(board[ci][cj]);
				break;
			case 2:
				dice.left(board[ci][cj]);
				break;
			case 3:
				dice.up(board[ci][cj]);
				break;
			case 4:
				dice.down(board[ci][cj]);
				break;
			}

			if (board[ci][cj] == 0) {
				board[ci][cj] = dice.data[5];
			} else {
				dice.data[5] = board[ci][cj];
				board[ci][cj] = 0;
			}
			System.out.println(dice.data[0]);
		}
	}

	static class Node {
		int[] data;

		public Node() {
			data = new int[6];
		}

		public void up(int value) {
			int[] next = { data[3], data[0], data[2], data[5], data[4], data[1] };
			data = next;
		}

		public void down(int value) {
			int[] next = { data[1], data[5], data[2], data[0], data[4], data[3] };
			data = next;

		}

		public void left(int value) {
			int[] next = { data[2], data[1], data[5], data[3], data[0], data[4] };
			data = next;

		}

		public void right(int value) {
			int[] next = { data[4], data[1], data[0], data[3], data[5], data[2] };
			data = next;
		}

	}
}
