package algo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution_5653 {
	static boolean board[][];
	static int row, col, time;

	static List<Loc> sleep;
	static List<Loc> active;

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {
			row = scan.nextInt();
			col = scan.nextInt();
			time = scan.nextInt();
			int half = time / 2;
			board = new boolean[row + time][col + time];

			sleep = new LinkedList<Loc>();
			active = new LinkedList<Loc>();

			int value;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					value = scan.nextInt();
					if (value != 0) {
						board[i + half][j + half] = true;
						sleep.add(new Loc(i + half, j + half, value, value));
					}
				}
			}

			for (int t = 0; t < time; t++) {
				Collections.sort(active);

				List<Loc> nextActive = new LinkedList<Loc>();
				List<Loc> nextSleep = new LinkedList<Loc>();

				for (int i = 0; i < active.size(); i++) {
					Loc cur = active.get(i);
					cur.time--;
					for (int d = 0; d < 4; d++) {
						int ni = cur.i + di[d];
						int nj = cur.j + dj[d];

						if (!board[ni][nj]) {
							board[ni][nj] = true;
							nextSleep.add(new Loc(ni, nj, cur.value, cur.value));
						}

					}
					if (cur.time > 0) {
						nextActive.add(cur);
					}

				}

				for (int q = 0; q < sleep.size(); q++) {
					Loc cur = sleep.get(q);
					cur.time--;
					if (cur.time > 0) {
						nextSleep.add(cur);
					} else {
						nextActive.add(new Loc(cur.i, cur.j, cur.value, cur.value));
					}
				}

				active = nextActive;
				sleep = nextSleep;
			}

			System.out.println("#" + test_case + " " + (active.size() + sleep.size()));
			// print();
		}

	}

	public static class Loc implements Comparable<Loc> {
		int i, j, value, time;

		public Loc(int i, int j, int value, int time) {
			this.i = i;
			this.j = j;
			this.value = value;
			this.time = time;
		}

		@Override
		public int compareTo(Loc o) {
			// TODO Auto-generated method stub
			return o.value - this.value;
		}

		@Override
		public String toString() {
			return "Loc [i=" + i + ", j=" + j + ", value=" + value + ", time=" + time + "]";
		}
	}

	public static void print() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j])
					System.out.print("X");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
