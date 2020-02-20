package myalgo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_17472 {
	static int row, col;
	static boolean board[][];
	static int islandCount;

	static int di[] = { 0, 1 };
	static int dj[] = { 1, 0 };

	static int island[][];
	static int distance[][];

	static HashMap<Integer, Integer> islandIndex;
	static int result;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		row = scan.nextInt();
		col = scan.nextInt();
		board = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (scan.nextInt() == 1)
					board[i][j] = true;
				else
					board[i][j] = false;
			}
		}
		result = 0;

		init();
		int islandindex = 1;
		int[] head = new int[100];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (island[i][j] == i * col + j) {
					islandCount++;
					head[i * col + j] = islandindex++;
				} else if (island[i][j] != -1) {
					find(i, j);
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (island[i][j] != -1) {
					island[i][j] = head[island[i][j]];
				}
			}
		}
		link();
		makeMst();
		System.out.println(result);
	}

	public static void init() {
		island = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j]) {
					island[i][j] = i * col + j;
				} else {
					island[i][j] = -1;
				}
			}
		}
		islandCount = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j]) {
					for (int d = 0; d < 2; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];

						if (ni < 0 || ni >= row || nj < 0 || nj >= col)
							continue;

						if (board[ni][nj]) {
							union(i, j, ni, nj);
						}
					}
				}
			}
		}
	}

	public static void union(int first_i, int first_j, int sec_i, int sec_j) {
		int headi = find(first_i, first_j);
		int headj = find(sec_i, sec_j);

		if (headi != headj) {
			int headi_i = headi / col;
			int headi_j = headi % col;

			island[headi_i][headi_j] = headj;
		}
	}

	public static int find(int i, int j) {
		if (island[i][j] == i * col + j) {
			return i * col + j;
		}

		int ni = island[i][j] / col;
		int nj = island[i][j] % col;

		int head = find(ni, nj);
		island[i][j] = head;
		return head;

	}

	public static void link() {
		distance = new int[islandCount][islandCount];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (island[i][j] != -1) {
					for (int d = 0; d < 2; d++) {
						int ni = i;
						int nj = j;
						int currentCount = -1;

						if (ni < 0 || ni >= row || nj < 0 || nj >= col)
							continue;

						boolean make = true;
						do {
							ni += di[d];
							nj += dj[d];

							if (ni < 0 || ni >= row || nj < 0 || nj >= col) {
								make = false;
								break;
							}

							currentCount++;
						} while (island[ni][nj] == -1);

						if (make) {
							int start = island[i][j] - 1;
							int end = island[ni][nj] - 1;

							if (currentCount > 1 && start != end) {
								if (distance[start][end] == 0 || distance[start][end] > currentCount) {
									distance[start][end] = currentCount;
									distance[end][start] = currentCount;
								}
							}
						}
					}
				}
			}
		}
	}

	public static void makeMst() {
		PriorityQueue<Loc> queue = new PriorityQueue<>();

		for (int i = 0; i < islandCount; i++) {
			for (int j = i; j < islandCount; j++) {
				if (distance[i][j] != 0) {
					queue.add(new Loc(i, j, distance[i][j]));
				}
			}
		}

		int[] set = new int[islandCount];

		for (int i = 0; i < set.length; i++) {
			set[i] = i;
		}

		while (!queue.isEmpty()) {
			Loc current = queue.poll();

			int set1 = set[current.i];
			int set2 = set[current.j];

			if (set1 != set2) {
				for (int i = 0; i < set.length; i++) {
					if (set[i] == set1 || set[i] == set2) {
						set[i] = set1;
					}
				}
				result += current.dist;
			}
		}
		int headcount = 0;
		for (int i = 0; i < set.length; i++) {
			if (set[i] == i) {
				headcount++;
			}
		}

		if (headcount != 1)
			result = -1;
	}

	public static class Loc implements Comparable<Loc> {
		int i, j, dist;

		public Loc(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return i + " " + j + " " + dist;
		}

		@Override
		public int compareTo(Loc o) {
			return this.dist - o.dist;
		}
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}
	}
}
