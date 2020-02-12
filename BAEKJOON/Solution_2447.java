package day0212;

import java.util.Scanner;

public class Solution_2447 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();

		boolean[][] board = new boolean[max][max];
		boolean[] pattern = { true, true, true, true, false, true, true, true, true };

		int[] di = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
		int[] dj = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };

		int count = 1;

		while (Math.pow(3, count) != max)
			count++;
		board[0][0] = true;
		int sectionsize = 1;
		
		for (int c = 0; c < count; c++) {
			int sectionNo = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (sectionNo == 0) {
						sectionNo++;
						continue;
					}

					int starti = sectionsize * di[sectionNo];
					int startj = sectionsize * dj[sectionNo];

					for (int x = 0; x < sectionsize; x++) {
						for (int y = 0; y < sectionsize; y++) {
							if (pattern[sectionNo]) {
								board[starti + x][startj + y] = board[x][y];
							} else {
								board[starti + x][startj + y] = false;
							}
						}
					}
					sectionNo++;
				}
			}
			sectionsize *= 3;
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if (board[i][j]) {
					sb.append('*');
				} else {
					sb.append(' ');
				}
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}
}
