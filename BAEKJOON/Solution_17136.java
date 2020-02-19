package myalgo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_17136 {
	static boolean[][] board;

	static int[][] checki = { { 0 }, { 0, 1, 1 }, { 0, 1, 2, 2, 2 }, { 0, 1, 2, 3, 3, 3, 3 },
			{ 0, 1, 2, 3, 4, 4, 4, 4, 4 } };
	static int[][] checkj = { { 0 }, { 1, 1, 0 }, { 2, 2, 2, 1, 0 }, { 3, 3, 3, 3, 2, 1, 0 },
			{ 4, 4, 4, 4, 4, 3, 2, 1, 0 } };
	static Queue<State> queue;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		board = new boolean[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (scan.nextInt() == 1) {
					board[i][j] = true;
				}
			}
		}
		queue = new LinkedList<>();
		int[] initPaper = { 5, 5, 5, 5, 5 };

		State init = new State(0, 0, initPaper, board);
		queue.add(init);

		while (!queue.isEmpty()) {
			run();
		}
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
		scan.close();
	}

	public static void run() {
		State current = queue.poll();

		if (find(current)) {
			queue.clear();
			return;
		}

		for (int i = 0; i < 5; i++) {
			boolean use = true;
			for (int j = 0; j < checki[i].length; j++) {
				int ni = current.i + checki[i][j];
				int nj = current.j + checkj[i][j];

				if (ni < 0 || ni >= 10 || nj < 0 || nj >= 10) {
					use = false;
					break;
				}

				if (!current.board[ni][nj]) {
					use = false;
					break;
				} else {
					current.board[ni][nj] = false;
				}
			}

			if (use && current.remain[i] > 0) {
				int[] remain = current.remain.clone();
				remain[i]--;
				State next = new State(current.i, current.j, remain, current.board);
				queue.add(next);
			}
			if (!use)
				break;
		}

	}

	public static boolean find(State current) {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (current.board[i][j]) {
					current.i = i;
					current.j = j;
					return false;
				}
			}
		}

		int max = 25;
		for (int i = 0; i < 5; i++) {
			max -= current.remain[i];
		}
		if (max < min)
			min = max;
		return true;
	}

	static public class State {
		int i, j;
		int[] remain;
		boolean[][] board;

		public State(int i, int j, int[] remain, boolean[][] board) {
			this.i = i;
			this.j = j;
			this.remain = remain;

			this.board = new boolean[10][];

			for (int c = 0; c < 10; c++) {
				this.board[c] = board[c].clone();
			}
		}

		@Override
		public String toString() {
			return "(" + i + "," + j + ")" + Arrays.toString(remain);
		}
	}

	public static void print(boolean[][] arr) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
}
