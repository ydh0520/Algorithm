package day0309;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_7793 {
	static int[][] devil;
	static int[][] su;

	static Queue<Loc> devilQueue, suQueue;
	static int row, col;

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void devilHand() {
		Loc current = devilQueue.poll();

		if (devil[current.i][current.j] == 0) {
			devil[current.i][current.j] = current.value;

			for (int d = 0; d < 4; d++) {
				int ni = current.i + di[d];
				int nj = current.j + dj[d];

				if (ni < 0 || ni >= row || nj < 0 || nj >= col) {
					continue;
				}
				devilQueue.add(new Loc(ni, nj, current.value + 1));
			}
		}

	}

	public static void moveSu() {
		Loc current = suQueue.poll();

		if (su[current.i][current.j] == 0
				&& (devil[current.i][current.j] == 0 || devil[current.i][current.j] > current.value)) {
			su[current.i][current.j] = current.value;

			for (int d = 0; d < 4; d++) {
				int ni = current.i + di[d];
				int nj = current.j + dj[d];

				if (ni < 0 || ni >= row || nj < 0 || nj >= col) {
					continue;
				}

				suQueue.add(new Loc(ni, nj, current.value + 1));
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {
			row = scan.nextInt();
			col = scan.nextInt();

			devil = new int[row][col];
			su = new int[row][col];

			devilQueue = new LinkedList<>();
			suQueue = new LinkedList<>();

			int endi = 0, endj = 0;
			String input;
			for (int i = 0; i < row; i++) {
				input = scan.next();
				for (int j = 0; j < col; j++) {
					switch (input.charAt(j)) {
					case '*':
						devilQueue.add(new Loc(i, j, 1));
						break;
					case 'X':
						devil[i][j] = -1;
						su[i][j] = -1;
						break;
					case 'D':
						devil[i][j] = Integer.MAX_VALUE;
						endi = i;
						endj = j;
						break;
					case 'S':
						suQueue.add(new Loc(i, j, 1));
						break;
					}
				}
			}

			while (!devilQueue.isEmpty()) {
				devilHand();
			}

			while (!suQueue.isEmpty()) {
				moveSu();
			}

			if (su[endi][endj] == 0) {
				System.out.println("#" + test_case + " GAME OVER");
			} else {
				System.out.println("#" + test_case + " " + (su[endi][endj] - 1));
			}
		}
	}

	public static void print(int arr[][]) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static class Loc {
		int i, j, value;

		public Loc(int i, int j, int value) {
			this.i = i;
			this.j = j;
			this.value = value;
		}

	}
}
