package myalgo;

import java.util.Scanner;

public class Solution_14500 {
	public static void main(String[] args) {
		int[][] di = { { 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 1, 1 }, { 0, 1, 2, 2 }, { 0, 0, 0, -1 }, { 0, 0, 1, 2 },
				{ 0, 0, 0, 1 }, { 0, 1, 1, 2 }, { 0, 0, -1, -1 }, { 0, 0, 1, 0 }, { 0, -1, 1, 0 }, { 0, -1, 0, 0 },
				{ 0, -1, 0, 1 },{0,0,-1,-2},{0,0,0,1},{0,0,1,2},{0,1,1,1},{0,1,1,2},{0,0,1,1} };
		int[][] dj = { { 0, 1, 2, 3 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 1, 2, 2 }, { 0, 1, 1, 1 },
				{ 0, 1, 2, 0 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 1, 0, -1 }, { 0, 0, 0, -1 }, { 0, 0, 1, -1 },
				{ 0, 0, 1, 0 } ,{0,1,1,1},{0,1,2,2},{0,1,0,0},{0,0,1,2},{0,0,-1,-1},{0,1,1,2}};

		Scanner scan = new Scanner(System.in);

		int row = scan.nextInt();
		int col = scan.nextInt();

		int board[][] = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = scan.nextInt();
			}
		}

		int max = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				for (int d = 0; d < di.length; d++) {
					int current = 0;
					for (int e = 0; e < 4; e++) {
						int ni = i + di[d][e];
						int nj = j + dj[d][e];

						if (ni < 0 || ni >= row || nj < 0 || nj >= col) {
							current = Integer.MIN_VALUE;
							continue;
						}

						current += board[ni][nj];
					}
					if (max < current)
						max = current;
				}
			}
		}
		System.out.println(max);

	}
}
