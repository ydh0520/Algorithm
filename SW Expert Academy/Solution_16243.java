package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_16243 {

	static int[][] board;
	static boolean[][] check;
	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	static Queue<Loc> union;
	static int size;
	static int l, r;

	static int sum;

	public static void dfs(int ci, int cj) {
		sum += board[ci][cj];
		union.add(new Loc(ci, cj));
		check[ci][cj] = true;
		for (int i = 0; i < 4; i++) {
			int ni = ci + di[i];
			int nj = cj + dj[i];

			if (ni < 0 || ni >= size || nj < 0 || nj >= size || check[ni][nj]) {
				continue;
			}

			int diff = Math.abs(board[ni][nj] - board[ci][cj]);

			if (l <= diff && diff <= r) {
				dfs(ni, nj);
			}
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		size = scan.nextInt();
		l = scan.nextInt();
		r = scan.nextInt();

		board = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = scan.nextInt();
			}
		}

		boolean change = true;
		int changeCount = -1;
		while (change) {
			change = false;
			check = new boolean[size][size];
			changeCount++;

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (check[i][j])
						continue;

					sum = 0;
					union = new LinkedList<Loc>();
					dfs(i, j);

					int count = union.size();
					
					if (count == 1)
						continue;
					change = true;
					while (!union.isEmpty()) {
						Loc cur = union.poll();
						board[cur.i][cur.j] = sum / count;
					}
				}
			}
		}
		System.out.println(changeCount);
	}

	static class Loc {
		int i, j;

		public Loc(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
	
	static public void print() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--");
	}
}
