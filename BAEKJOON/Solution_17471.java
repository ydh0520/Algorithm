package myalgo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_17471 {
	static int size;
	static int sum;
	static int[] value;
	static boolean[][] board;
	static int min;
	public static int set[];

	public static void union(int i, int j) {
		int headj = find(j);
		int headi = find(i);
		if(headj!=headi)
			set[headi] = headj;
	}

	public static int find(int index) {
		if (set[index] == index)
			return set[index];

		int head = find(set[index]);
		set[index] = head;
		return head;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		value = new int[size];
		sum = 0;

		for (int i = 0; i < size; i++) {
			value[i] = scan.nextInt();
			sum += value[i];
		}

		board = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			int link = scan.nextInt();
			for (int j = 0; j < link; j++) {
				int v1 = scan.nextInt() - 1;

				board[v1][i] = true;
				board[i][v1] = true;
			}
		}

		min = Integer.MAX_VALUE;
		for (int i = 1; i < size; i++) {
			select(i, 0, 0, new boolean[size]);
		}

		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

	public static void select(int limit, int count, int index, boolean[] arr) {
		if (limit == count) {
			int[] section1 = new int[limit];
			int[] section2 = new int[size - limit];

			int section1Index = 0;
			int section2Index = 0;

			for (int i = 0; i < size; i++) {
				if (arr[i]) {
					section1[section1Index] = i;
					section1Index++;
				} else {
					section2[section2Index] = i;
					section2Index++;
				}
			}

			boolean v1 = verify(section1, section2);
			//boolean v2 = verify2(arr);

			if (v1) {
				compare(section1);
			}
			return;
		} else {
			for (int i = index; i < size; i++) {
				arr[i] = true;
				select(limit, count + 1, i + 1, arr);
				arr[i] = false;
			}
		}
	}

	public static boolean verify(int[] section1, int[] section2) {
		set = new int[size];

		for (int i = 0; i < size; i++) {
			set[i] = i;
		}

		for (int i = 0; i < section1.length; i++) {
			for (int j = 0; j < section1.length; j++) {
				if (board[section1[i]][section1[j]])
					union(section1[i], section1[j]);
			}
		}
		for (int i = 0; i < section2.length; i++) {
			for (int j = 0; j < section2.length; j++) {
				if (board[section2[i]][section2[j]])
					union(section2[i], section2[j]);
			}
		}

		int headCount = 0;
		for (int i = 0; i < size; i++) {
			if (set[i] == i)
				headCount++;
		}
		if (headCount == 2) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean[] visit;

	public static void dfs(boolean[] arr, int current, boolean flag) {
		visit[current] = true;
		for (int i = 0; i < arr.length; i++) {
			if (board[current][i] && arr[i] == flag) {
				if (visit[i])
					continue;
				dfs(arr, i, flag);
			}
		}
	}

	public static boolean verify2(boolean[] arr) {
		visit = new boolean[size];
		int lastTrue = 0;
		int lastFalse = 0;

		for (int i = 0; i < size; i++) {
			if (arr[i])
				lastTrue = i;
			else
				lastFalse = i;
		}

		dfs(arr, lastTrue, true);
		dfs(arr, lastFalse, false);

		for (int i = 0; i < size; i++) {
			if (!visit[i])
				return false;
		}
		return true;
	}

	public static void compare(int[] arr) {
		int section = 0;
		for (int i = 0; i < arr.length; i++) {
			section += value[arr[i]];
		}

		int diff = Math.abs(section + section - sum);
		if (diff < min)
			min = diff;
	}
}
