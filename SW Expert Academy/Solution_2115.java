package day0227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_2115 {
	static int[][] board;
	static int[][] mem;

	static int[] squared = { 0, 1, 4, 9, 16, 25, 36, 49, 64, 81 };
	static int size, width, weight, max;
	static boolean[] visit;
	static ArrayList<int[]> combinationList;

	public static void makelist(int index, int count, int max, int[] arr) {
		if (count == max) {
			combinationList.add(arr.clone());
		} else {
			for (int i = index; i < width; i++) {
				arr[count] = i;
				makelist(i + 1, count + 1, max, arr);
			}
		}
	}

	public static void select(int ci, int cj, int count, int value) {
		if (count == 2) {
			if (max < value)
				max = value;
		} else {
			for (int i = ci; i < size; i++) {

				int j = 0;
				if (i == ci)
					j = cj;

				while (j < size) {
					if (mem[i][j] == 0) {
						j++;
						continue;
					}
					select(i, j + width, count + 1, value + mem[i][j]);
					j++;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {
			size = scan.nextInt();
			width = scan.nextInt();
			weight = scan.nextInt();

			board = new int[size][size];
			mem = new int[size][size];
			max = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					board[i][j] = scan.nextInt();
				}
			}

			combinationList = new ArrayList<int[]>();
			for (int i = 1; i <= width; i++) {
				makelist(0, 0, i, new int[i]);
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j <= size - width; j++) {
					for (int x = 0; x < combinationList.size(); x++) {
						int current = 0;
						int currentWeight = 0;
						for (int y = 0; y < combinationList.get(x).length; y++) {
							currentWeight += board[i][j + combinationList.get(x)[y]];
							current += squared[board[i][j + combinationList.get(x)[y]]];
						}
						if (currentWeight <= weight && mem[i][j] < current)
							mem[i][j] = current;
					}

				}
			}

			select(0, 0, 0, 0);
			System.out.println("#" + test_case + " " + max);
		}
	}

}
