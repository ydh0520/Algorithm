package myalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767 {
	static int board[][];
	static int min = Integer.MAX_VALUE;
	static int connectCore = 0;
	static ArrayList<Core> coreSet;
	static int boardSize;
	static int di[] = { -1, 0, 1, 0 };// 상 우 하 좌
	static int dj[] = { 0, 1, 0, -1 };

	static int rdi[] = { 1, 0, -1, 0 };// 하 좌 상 우
	static int rdj[] = { 0, -1, 0, 1 };

	static class Core {
		int i;
		int j;

		public Core(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void solve(int lineCounter, int coreIndex, int corecount) {
		if (coreIndex == coreSet.size()) {
			if (corecount > connectCore) {
				connectCore = corecount;
				min =lineCounter;
			}else if(corecount==connectCore) {
				if(lineCounter<min) {
					connectCore = corecount;
					min =lineCounter;
				}
			}
		} else {
			int ci = coreSet.get(coreIndex).i;
			int cj = coreSet.get(coreIndex).j;

			for (int d = 0; d < 4; d++) {
				boolean flag = true;
				while (true) {
					ci += di[d];
					cj += dj[d];

					if (ci < 0 || ci >= boardSize || cj < 0 || cj >= boardSize)
						break;

					if (board[ci][cj] == 0) {
						board[ci][cj] = 1;
						lineCounter++;
					} else {
						flag = false;
						break;
					}
				}

				if (flag)
					solve(lineCounter, coreIndex + 1, corecount + 1);

				while (true) {
					ci += rdi[d];
					cj += rdj[d];

					if (ci == coreSet.get(coreIndex).i && cj == coreSet.get(coreIndex).j)
						break;
					board[ci][cj] = 0;
					lineCounter--;
				}
			}

			solve(lineCounter, coreIndex + 1, corecount);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			boardSize = Integer.parseInt(bf.readLine());
			board = new int[boardSize][boardSize];
			min = Integer.MAX_VALUE;
			connectCore = 0;
			coreSet = new ArrayList<>();
			int defaultCore = 0;
			for (int i = 0; i < boardSize; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < boardSize; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) {

						if (i == 0 || i == boardSize - 1 || j == 0 || j == boardSize - 1)
							defaultCore++;
						else
							coreSet.add(new Core(i, j));
					}
				}
			}

			solve(0, 0, defaultCore);
			System.out.println("#" + test_case + " " + min);
		}
	}
}
