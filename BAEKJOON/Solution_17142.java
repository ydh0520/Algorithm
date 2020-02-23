package myalgo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_17142 {
	static int board[][];
	static int tempboard[][];
	static int size;
	static int select;
	static LinkedList<Loc> virus;
	static Queue<Loc> queue;

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	static int min;

	public static void select(int count, int index, int[] selected) {
		if (count == select) {
			run(selected);
		} else {
			for (int i = index; i < virus.size(); i++) {
				selected[count] = i;
				select(count + 1, i + 1, selected);
			}
		}
	}

	public static void run(int[] arr) {
		queue = new LinkedList<>();
		tempboard = new int[size][size];

		for (int i = 0; i < arr.length; i++) {
			queue.add(virus.get(arr[i]));
		}

		while (!queue.isEmpty()) {
			spread(queue.poll());
		}

		int tempMax = 1;
		boolean check = true;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] == 0) {
					if (tempboard[i][j] == 0) {
						check = false;
					} else {
						if (tempMax < tempboard[i][j]) {
							tempMax = tempboard[i][j];
						}
					}

				}
			}
		}

		if (check && tempMax < min)
			min = tempMax;

	}

	public static void spread(Loc current) {
		tempboard[current.i][current.j] = current.time;

		for (int d = 0; d < 4; d++) {
			int ni = current.i + di[d];
			int nj = current.j + dj[d];

			if (ni < 0 || ni >= size || nj < 0 || nj >= size)
				continue;

			if (tempboard[ni][nj] == 0) {
				if (board[ni][nj] != 1) {
					tempboard[ni][nj] = current.time + 1;
					queue.add(new Loc(ni, nj, tempboard[ni][nj]));
				}
			}

		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		select = scan.nextInt();

		board = new int[size][size];
		virus = new LinkedList<>();
		min = Integer.MAX_VALUE;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = scan.nextInt();
				if (board[i][j] == 2) {
					virus.add(new Loc(i, j, 1));
				}
			}
		}

		select(0, 0, new int[select]);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min - 1);
		}
	}

	static void print(int[][] arr) {

		System.out.println();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Loc {
		int i, j, time;

		public Loc(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}
}
