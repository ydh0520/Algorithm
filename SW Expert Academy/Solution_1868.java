package day0316;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import day0316.Solution_1868.Loc;

public class Solution_1868 {
	static int size;
	static boolean[][] board;
	static int[][] ref;

	static int[] di = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dj = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static Queue<Loc> queue;

	public static void spread() {
		Loc current = queue.poll();
		board[current.i][current.j] = true;
		for (int d = 0; d < 8; d++) {
			int ni = current.i + di[d];
			int nj = current.j + dj[d];

			if (ni < 0 || ni >= size || nj < 0 || nj >= size || board[ni][nj])
				continue;
			board[ni][nj] = true;
			if (ref[ni][nj] == 0)
				queue.add(new Loc(ni, nj));

		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			size = scan.nextInt();
			board = new boolean[size][size];

			for (int i = 0; i < size; i++) {
				String input = scan.next();
				for (int j = 0; j < size; j++) {
					if (input.charAt(j) == '*') {
						board[i][j] = true;
					}
				}
			}

			ref = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {

					int count = 0;
					for (int d = 0; d < 8; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];

						if (ni < 0 || ni >= size || nj < 0 || nj >= size)
							continue;

						if (board[ni][nj])
							count++;
					}
					ref[i][j] = count;
				}
			}
			int result = 0;
			queue = new LinkedList<Loc>();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (board[i][j] || ref[i][j] != 0) {
						continue;
					}
					result++;
					queue.add(new Loc(i, j));
					while (!queue.isEmpty()) {
						spread();
					}
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (!board[i][j])
						result++;
				}
			}

			System.out.println("#" + test_case + " " + result);
		}

	}

	static class Loc {
		int i, j;

		public Loc(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}
