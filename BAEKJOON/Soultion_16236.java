package myalgo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.omg.CORBA.LocalObject;

public class Soultion_16236 {
	static int size;
	static int[][] board;

	static Location baby;
	static int babySize;
	static int babyCount;

	static Queue<Location> queue;
	static boolean[][] visit;
	static Location min;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static int result;

	public static void bfs() {
		Location current = queue.poll();

		if (board[current.i][current.j] == babySize || board[current.i][current.j] == 0) {
			for (int i = 0; i < 4; i++) {
				int ni = current.i + di[i];
				int nj = current.j + dj[i];

				if (ni < 0 || ni >= size || nj < 0 || nj >= size)
					continue;
				if (visit[ni][nj])
					continue;
				if (min == null) {
					queue.add(new Location(ni, nj, current.count + 1));
					visit[ni][nj] = true;
				}
			}
		} else if (board[current.i][current.j] < babySize) {
			if (min == null) {
				min = current;
			} else {
				if (current.count <= min.count)
					if (current.i < min.i) {
						min = current;
					} else if (current.i == min.i) {
						if (current.j < min.j) {
							min = current;
						}
					}
			}

		}
	}

	public static boolean search() {
		queue = new LinkedList<>();
		visit = new boolean[size][size];

		queue.add(baby);
		visit[baby.i][baby.j] = true;
		min = null;

		while (!queue.isEmpty()) {
			bfs();
		}

		return min != null;
	}

	public static void eat() {
		result += min.count;
		baby = min;
		baby.count = 0;
		board[baby.i][baby.j] = 0;
		babyCount++;
		if (babyCount == babySize) {
			babyCount = 0;
			babySize++;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		board = new int[size][size];
		int temp;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp = scan.nextInt();
				if (temp != 9) {
					board[i][j] = temp;
				} else {
					baby = new Location(i, j, 0);
					board[i][j] = 0;
				}
			}
		}
		babySize = 2;
		babyCount = 0;
		while (search()) {
			eat();
		}
		System.out.println(result);
	}

	public static class Location {
		int i;
		int j;
		int count;

		public Location(int i, int j, int count) {
			this.i = i;
			this.j = j;
			this.count = count;
		}
	}
}