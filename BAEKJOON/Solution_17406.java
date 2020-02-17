package myalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_17406 {
	static int[][] board;
	static int[][] current;
	static int row, col, cmd;

	static int[][] nexti;
	static int[][] nextj;

	static ArrayList<Cmd> cmdList;
	static boolean[] visit;

	static int min;

	public static void makeNext() {
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		int[] coneri = { -1, -1, 1, 1 };
		int[] conerj = { -1, 1, 1, -1 };

		nexti = new int[26][];
		nextj = new int[26][];

		nexti[0] = new int[1];
		nextj[0] = new int[1];

		for (int i = 1; i <= 25; i++) {
			nexti[i] = new int[8 * i];
			nextj[i] = new int[8 * i];
		}

		for (int i = 1; i <= 25; i++) {
			int index = 0;
			for (int j = 0; j < 4; j++) {
				int ni = coneri[j] * i;
				int nj = conerj[j] * i;

				for (int k = 0; k < 2 * i + 1; k++) {
					if (index == nextj[i].length)
						break;

					nexti[i][index] = ni;
					nextj[i][index] = nj;

					ni += di[j];
					nj += dj[j];

					index++;
				}
				index--;

			}
		}
	}

	public static void makeCombination(int count, int[] arr) {
		if (count == cmd) {
			current = new int[row][col];

			for (int i = 0; i < row; i++) {
				current[i] = board[i].clone();
			}

			for (int i = 0; i < arr.length; i++) {
				run(cmdList.get(arr[i]));
			}

			check(current);

		} else {
			for (int i = 0; i < cmd; i++) {
				if (visit[i])
					continue;

				visit[i] = true;
				arr[count] = i;
				makeCombination(count + 1, arr);
				visit[i] = false;
			}
		}
	}

	public static void run(Cmd cmd) {
		for (int i = 1; i <= cmd.offset; i++) {
			change(cmd.i, cmd.j, i);
		}
	}

	public static void change(int i, int j, int count) {
		int last = current[i + nexti[count][nexti[count].length - 1]][j + nextj[count][nextj[count].length - 1]];

		for (int n = nexti[count].length - 1; n > 0; n--) {
			current[i + nexti[count][n]][j + nextj[count][n]] = current[i + nexti[count][n - 1]][j
					+ nextj[count][n - 1]];
		}
		current[i + nexti[count][0]][j + nextj[count][0]] = last;
	}

	public static void check(int[][] arr) {
		int currentMin = Integer.MAX_VALUE;
		for (int i = 0; i < row; i++) {
			int rowSum = 0;
			for (int j = 0; j < col; j++) {
				rowSum += arr[i][j];
			}

			if (rowSum < currentMin)
				currentMin = rowSum;
		}
		if (currentMin < min) {
			min = currentMin;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		row = scan.nextInt();
		col = scan.nextInt();
		cmd = scan.nextInt();
		min = Integer.MAX_VALUE;

		board = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = scan.nextInt();
			}
		}
		cmdList = new ArrayList<>();
		for (int i = 0; i < cmd; i++) {
			cmdList.add(new Cmd(scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}
		makeNext();
		visit = new boolean[cmd];
		makeCombination(0, new int[cmd]);
		System.out.println(min);
	}

	public static class Cmd {
		int i, j, offset;

		public Cmd(int i, int j, int offset) {
			this.i = i - 1;
			this.j = j - 1;
			this.offset = offset;
		}

	}
}