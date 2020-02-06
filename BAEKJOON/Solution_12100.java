package myalgo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_12100 {
	static int size;
	static int result;
	static Queue<Board> queue;

	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		size = Scan.nextInt();
		int board[][] = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = Scan.nextInt();
			}
		}
		queue = new LinkedList<>();
		queue.add(new Board(board, 0));
		while (!queue.isEmpty()) {
			move();
		}

		System.out.println(result);
	}

	public static void move() {
		Board current = queue.poll();
		if (current.moveCount == 5) {
			int max = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (current.board[i][j] > max)
						max = current.board[i][j];
				}
			}
			if (max > result)
				result = max;
		} else {
			clac(current.board, current.moveCount);
		}
	}

	static void clac(int[][] arr, int count) {
		int[][] next = new int[size][size];
		for (int i = 0; i < size; i++) {// 좌로이동
			int nextindex = 0;
			int preValue = -1;
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == 0)
					continue;
				if (preValue != arr[i][j]) {
					next[i][nextindex] = arr[i][j];
					preValue = arr[i][j];
					nextindex++;
				} else {
					next[i][nextindex - 1] *= 2;
					preValue = -1;
				}

			}
		}
		queue.add(new Board(next, count + 1));

		next = new int[size][size];
		for (int i = 0; i < size; i++) {// 우로이동
			int nextindex = size - 1;
			int preValue = -1;
			for (int j = size - 1; j >= 0; j--) {
				if (arr[i][j] == 0)
					continue;
				if (preValue != arr[i][j]) {
					next[i][nextindex] = arr[i][j];
					preValue = arr[i][j];
					nextindex--;
				} else {
					next[i][nextindex + 1] *= 2;
					preValue = -1;
				}
			}
		}
		queue.add(new Board(next, count + 1));

		next = new int[size][size];
		for (int j = 0; j < size; j++) {// 상으로 이동
			int nextindex = 0;
			int preValue = -1;
			for (int i = 0; i < size; i++) {
				if (arr[i][j] == 0)
					continue;
				if (preValue != arr[i][j]) {
					next[nextindex][j] = arr[i][j];
					preValue = arr[i][j];
					nextindex++;
				} else {
					next[nextindex - 1][j] *= 2;
					preValue = -1;
				}
			}
		}
		queue.add(new Board(next, count + 1));

		next = new int[size][size];
		for (int j = 0; j < size; j++) {// 하로 이동
			int nextindex = size - 1;
			int preValue = -1;
			for (int i = size - 1; i >= 0; i--) {
				if (arr[i][j] == 0)
					continue;
				if (preValue != arr[i][j]) {
					next[nextindex][j] = arr[i][j];
					preValue = arr[i][j];
					nextindex--;
				} else {
					next[nextindex + 1][j] *= 2;
					preValue = -1;
				}
			}
		}
		queue.add(new Board(next, count + 1));
	}

	static class Board {
		int board[][];
		int moveCount;

		public Board(int[][] board, int moveCount) {
			this.board = board;
			this.moveCount = moveCount;
		}
	}
}
