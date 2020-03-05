package day0305;

import java.util.Scanner;

public class Solution_2105 {
	static int size;
	static int[][] board;
	static int max;
	static boolean[] visit;

	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { 1, -1, -1, 1 };

	static int fi, fj;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			size = scan.nextInt();
			board = new int[size][size];
			max = -1;

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					board[i][j] = scan.nextInt();
				}
			}

			for (int i = 0; i < size - 2; i++) {
				for (int j = 1; j < size - 1; j++) {
					visit = new boolean[101];
					fi = i;
					fj = j;
					visit[board[fi][fj]] = true;
					dfs(i + di[0], j + dj[0], 0, 1);
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

	public static void dfs(int ci, int cj, int cd, int count) {
		if (fi == ci && fj == cj) {
			if (max < count)
				max = count;
		} else if (!visit[board[ci][cj]]) {
			visit[board[ci][cj]] = true;

			int ni = ci + di[cd];
			int nj = cj + dj[cd];

			if (ni >= 0 && ni < size && nj >= 0 && nj < size) {
				dfs(ni, nj, cd, count + 1);
			}

			if (cd < 3) {
				cd++;
				ni = ci + di[cd];
				nj = cj + dj[cd];

				if (ni >= 0 && ni < size && nj >= 0 && nj < size) {
					dfs(ni, nj, cd, count + 1);
				}
			}

			visit[board[ci][cj]] = false;
		}
	}
}
