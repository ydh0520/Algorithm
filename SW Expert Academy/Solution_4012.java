package day0316;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_4012 {
	static int[][] board;
	static int size;
	static int min;

	public static void select(int count, int index, boolean[] select) {
		if (count == size / 2) {
			int[] cook1 = new int[size / 2];
			int[] cook2 = new int[size / 2];

			int cook1index = 0;
			int cook2index = 0;

			for (int i = 0; i < size; i++) {
				if (select[i]) {
					cook1[cook1index] = i;
					cook1index++;
				} else {
					cook2[cook2index] = i;
					cook2index++;
				}
			}

			int diff = Math.abs(calculator(cook1) - calculator(cook2));
			if (diff < min) {
				min = diff;
			}

		} else {
			for (int i = index; i < size; i++) {
				select[i] = true;
				select(count + 1, i + 1, select);
				select[i] = false;
			}
		}

	}

	public static int calculator(int[] arr) {

		int value = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;

				value += board[arr[i]][arr[j]];
			}
		}

		return value;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			size = scan.nextInt();
			board = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					board[i][j] = scan.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			select(0, 0, new boolean[size]);
			System.out.println("#"+test_case+" "+min);
		}
	}
}
