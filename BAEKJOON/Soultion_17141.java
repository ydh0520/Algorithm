package myalgo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Soultion_17141 {
	static int[][] board;
	static int[][] tempboard;
	static int size;
	static int vsize;
	static Queue<Loc> queue;
	static LinkedList<Loc> virus;

	static int min;
	static int tempmax;

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void select(int count, int index, int[] selected) {
		if (count == vsize) {
			run(selected);
		} else {
			for (int i = index; i < virus.size(); i++) {
				selected[count] = i;
				select(count + 1, i + 1, selected);
			}
		}

	}

	public static void run(int[] arr) {
		tempboard = new int[size][size];

		for (int i = 0; i < size; i++) {
			tempboard[i] = board[i].clone();
		}

		tempmax = 0;

		for (int i = 0; i < arr.length; i++) {
			queue.add(virus.get(arr[i]));
			tempboard[virus.get(arr[i]).i][virus.get(arr[i]).j] = virus.get(arr[i]).time;
		}

		while (!queue.isEmpty()) {
			spread();
		}

		boolean check = true;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (tempboard[i][j] == 0)
					check = false;
			}
		}

		if (check && tempmax < min) {
			min = tempmax;
		}
	}

	public static void spread() {
		Loc current = queue.poll();

		if (tempmax < tempboard[current.i][current.j]) {
			tempmax = current.time;
		}

		for (int d = 0; d < 4; d++) {
			int ni = current.i + di[d];
			int nj = current.j + dj[d];

			if (ni < 0 || ni >= size || nj < 0 || nj >= size)
				continue;
			if (tempboard[ni][nj] == 0) {
				tempboard[ni][nj] = current.time + 1;
				queue.add(new Loc(ni, nj, tempboard[ni][nj]));
			}
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		vsize = scan.nextInt();

		board = new int[size][size];
		queue = new LinkedList<>();
		virus = new LinkedList<>();

		min = Integer.MAX_VALUE;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = scan.nextInt();

				if (board[i][j] == 2) {
					virus.add(new Loc(i, j, 1));
					board[i][j] = 0;
				}

			}
		}

		select(0, 0, new int[vsize]);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min - 1);
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
