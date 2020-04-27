package day0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_15686 {
	static List<Loc> house;
	static List<Loc> chicken;
	static int[][] board;
	static int count;
	static int hcount, ccount;
	static int min = 0;

	public static void combination(int[] selected, int index, int start) {
		if (index == count) {
			int tempmin = 0;
			for (int i = 0; i < hcount; i++) {
				int housemin = Integer.MAX_VALUE;

				for (int j = 0; j < count; j++) {
					if (board[i][selected[j]] < housemin)
						housemin = board[i][selected[j]];
				}
				tempmin += housemin;
			}

			if (tempmin < min) {
				min = tempmin;
			}
		} else {
			for (int i = start; i < ccount; i++) {
				selected[index] = i;
				combination(selected, index + 1, i + 1);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		count = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;
		house = new LinkedList<Loc>();
		chicken = new LinkedList<Loc>();

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				switch (st.nextToken()) {
				case "1":
					house.add(new Loc(i, j));
					break;
				case "2":
					chicken.add(new Loc(i, j));

				}
			}
		}

		hcount = house.size();
		ccount = chicken.size();

		board = new int[hcount][ccount];

		for (int i = 0; i < hcount; i++) {
			for (int j = 0; j < ccount; j++) {
				board[i][j] = Math.abs(house.get(i).i - chicken.get(j).i) + Math.abs(house.get(i).j - chicken.get(j).j);
			}
		}

		combination(new int[count], 0, 0);
		System.out.println(min);
	}

	static class Loc {
		int i, j;

		public Loc(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Loc [i=" + i + ", j=" + j + "]";
		}
	}
}
