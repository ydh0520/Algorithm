package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1949 {
	static int size;
	static int dig;
	static int[][] board;
	static boolean[][] visited;
	static List<Loc> top;

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	static int maxCount;

	public static void dfs(int i, int j, int count, boolean c, int hight) {
		visited[i][j] = true;
		if (maxCount < count) {
			maxCount = count;
		}

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (ni < 0 || ni >= size || nj < 0 || nj >= size)
				continue;
			if (visited[ni][nj])
				continue;

			if (board[ni][nj] < hight) {
				dfs(ni, nj, count + 1, c, board[ni][nj]);
			} else if (!c) {
				int nhight = board[ni][nj];
				for(int cut=0;cut<dig;cut++) {
					nhight--;					
					if (nhight < hight) {
						dfs(ni, nj, count + 1, true, nhight);
					}
				}
			}

		}

		visited[i][j] = false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {
			size = scan.nextInt();
			dig = scan.nextInt();

			board = new int[size][size];
			visited = new boolean[size][size];

			int max = 0;
			maxCount = 0;

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					board[i][j] = scan.nextInt();

					if (board[i][j] > max) {
						top = new ArrayList<Loc>();
						top.add(new Loc(i, j));
						max = board[i][j];
					} else if (board[i][j] == max) {
						top.add(new Loc(i, j));
					}
				}
			}

			for (int i = 0; i < top.size(); i++) {
				int ci = top.get(i).i;
				int cj = top.get(i).j;

				visited[ci][cj] = true;
				dfs(ci, cj, 1, false, max);
				visited[ci][cj] = false;
			}
			System.out.println("#" + test_case + " " + maxCount);
		}
	}

	public static class Loc {
		int i, j;

		public Loc(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Loc [i=" + i + ", j=" + j + "]";
		}
	}

	public static void print() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(visited[i][j]) {
					System.out.print("O");
				}else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
