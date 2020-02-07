package myalgo;

import java.util.Scanner;

public class Soultion_3190 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int size = scan.nextInt();
		int[][] board = new int[size + 1][size + 1];

		int apple = scan.nextInt();
		for (int i = 0; i < apple; i++) {
			board[scan.nextInt()][scan.nextInt()] = -1;
		}

		int change = scan.nextInt();
		int[] time = new int[change + 1];
		int[] direction = new int[change];

		for (int i = 0; i < change; i++) {
			time[i] = scan.nextInt();
			if (scan.next().charAt(0) == 'D') {
				direction[i] = 1;
			} else {
				direction[i] = -1;
			}
		}

		int headi = 1;
		int headj = 1;

		int taili = 1;
		int tailj = 1;

		int[] di = { 0, -1, 0, 1, 0 };
		int[] dj = { 0, 0, 1, 0, -1 };

		int d = 2;
		int count = 0;

		int currentChange = 0;

		while (true) {
			count++;

			int ni = headi + di[d];
			int nj = headj + dj[d];

			if (ni < 1 || ni > size || nj < 1 || nj > size)
				break;
			if (board[ni][nj] > 0)
				break;

			boolean eat = board[ni][nj] == -1;

			board[headi][headj] = d;
			headi = ni;
			headj = nj;

			if (!eat) {
				int taild = board[taili][tailj];
				board[taili][tailj] = 0;

				taili += di[taild];
				tailj += dj[taild];

			}
			if (count == time[currentChange]) {
				d += direction[currentChange];
				if (d < 1)
					d = 4;
				if (d > 4)
					d = 1;
				currentChange++;
			}
		}
		System.out.println(count);
		scan.close();
	}
}
