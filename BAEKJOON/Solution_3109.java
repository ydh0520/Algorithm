package day2010;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3109 {
	static int row, col;
	static int[][] board;

	static int[] di = { -1, 0, 1 };
	static int[] dj = { 1, 1, 1 };

	static int count;

	public static boolean link(int i, int j) {
		if (board[i][j] != 0) {
			return false;
		} else {
			if (j == col - 1) {
				board[i][j] = 2;
				count++;
				return true;
			} else {
				boolean make = false;
				for (int d = 0; d < 3; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (ni < 0 || ni >= row)
						continue;
					make = link(ni, nj);

					if (make) {
						board[i][j] = 2;
						break;
					}else {
						board[i][j] = 3;
					}
				}
				return make;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bf = new BufferedReader(new FileReader("test.txt"));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		board = new int[row][col];

		for (int i = 0; i < row; i++) {
			String line = bf.readLine();
			for (int j = 0; j < col; j++) {
				if (line.charAt(j) == 'x') {
					board[i][j] = 1;
				} else {
					board[i][j] = 0;
				}
			}
		}

		count = 0;
		for (int i = 0; i < row; i++) {
			link(i, 0);
		}
		
		System.out.println(count);

	}
}
