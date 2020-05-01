package algo;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import algo.Solution_16235.Tree;

public class Solution_16235 {
	static int size;

	static int[][] board;
	static int[][] food;

	static PriorityQueue<Tree> list;
	static Queue<Tree> dead;
	static Queue<Tree> breeding;

	static int[] di = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dj = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void Spring() {
		PriorityQueue<Tree> next = new PriorityQueue<Tree>();

		Tree cur;
		while (!list.isEmpty()) {
			cur = list.poll();
			if (cur.age <= board[cur.i][cur.j]) {
				board[cur.i][cur.j] -= cur.age;
				cur.age++;
				if (cur.age % 5 == 0)
					breeding.add(cur);
				next.add(cur);
			} else {
				dead.add(cur);
			}
		}
		list = next;
	}

	public static void Summer() {
		Tree cur;
		while (!dead.isEmpty()) {
			cur = dead.poll();
			board[cur.i][cur.j] += (cur.age / 2);
		}
	}

	public static void Fall() {
		Tree cur;
		while (!breeding.isEmpty()) {
			cur = breeding.poll();

			for (int i = 0; i < 8; i++) {
				int ni = cur.i + di[i];
				int nj = cur.j + dj[i];

				if (ni < 0 || ni >= size || nj < 0 || nj >= size)
					continue;

				list.add(new Tree(ni, nj, 1));
			}

		}
	}

	public static void Winter() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] += food[i][j];
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		size = scan.nextInt();
		int m = scan.nextInt();
		int year = scan.nextInt();

		list = new PriorityQueue<Tree>();
		dead = new LinkedList<Tree>();
		breeding = new LinkedList<Tree>();

		board = new int[size][size];
		food = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				food[i][j] = scan.nextInt();
				board[i][j] = 5;
			}
		}

		int ci, cj, cage;
		for (int i = 0; i < m; i++) {
			ci = scan.nextInt() - 1;
			cj = scan.nextInt() - 1;
			cage = scan.nextInt();

			list.add(new Tree(ci, cj, cage));
		}

		for (int i = 0; i < year; i++) {
			Spring();
			Summer();
			Fall();
			Winter();
		}

		System.out.println(list.size());
	}

	public static class Tree implements Comparable<Tree> {
		int i, j, age;

		public Tree(int i, int j, int age) {
			this.i = i;
			this.j = j;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return "Tree [i=" + i + ", j=" + j + ", age=" + age + "]";
		}
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}
}
