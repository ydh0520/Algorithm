package day0309;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_5656 {

	static int row = 3, col = 3;
	static int max;
	static int limit;

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	static void select(int count, int result, int[][] arr) {
		if (count == limit) {
			if (max < result)
				max = result;
		} else {
			for (int j = 0; j < col; j++) {
				Queue<Loc> removelist = new LinkedList<>();
				boolean[][] visit = new boolean[row][col];

				for (int i = 0; i < row; i++) {
					if (arr[i][j] != 0) {
						removelist.add(new Loc(i, j));
						break;
					}
				}

				while (!removelist.isEmpty()) {
					Loc current = removelist.poll();
					if (arr[current.i][current.j] == 0) {
						continue;
					}

					visit[current.i][current.j] = true;

					for (int d = 0; d < 4; d++) {
						int ci = current.i;
						int cj = current.j;

						for (int c = 1; c < arr[current.i][current.j]; c++) {
							ci = ci + di[d];
							cj = cj + dj[d];

							if (ci < 0 || ci >= row || cj < 0 || cj >= col)
								break;

							if (!visit[ci][cj] && arr[ci][cj] != 0) {
								visit[ci][cj] = true;
								removelist.add(new Loc(ci, cj));
							}
						}

					}
				}

				int[][] next = new int[row][col];
				int removeCount = 0;
				for (int ci = 0; ci < row; ci++) {
					for (int cj = 0; cj < col; cj++) {
						if (visit[ci][cj]) {
							next[ci][cj] = 0;
							removeCount++;
						} else {
							next[ci][cj] = arr[ci][cj];
						}
					}
				}

				select(count + 1, result + removeCount, down(next));
			}
		}
	}

	static int[][] remove(int[][] arr) {
		int[][] result = new int[row][col];
		return result;
	}

	static int[][] down(int[][] arr) {
		int[][] result = new int[row][col];

		for (int j = 0; j < col; j++) {
			int index = row - 1;
			for (int i = row - 1; i >= 0; i--) {
				if (arr[i][j] != 0) {
					result[index][j] = arr[i][j];
					index--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {
			limit = scan.nextInt();
			col = scan.nextInt();
			row = scan.nextInt();
			max = Integer.MIN_VALUE;

			int[][] board = new int[row][col];
			int blockCount = 0;

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					board[i][j] = scan.nextInt();
					if (board[i][j] != 0)
						blockCount++;
				}
			}

			select(0, 0, board);

			System.out.println("#" + test_case + " " + (blockCount - max));
		}
	}

	public static class Loc {
		int i, j;

		public Loc(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	public static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
