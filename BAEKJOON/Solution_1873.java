package day0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(bf.readLine());

		int[] di = { -1, 1, 0, 0 };// 위 아래 왼쪽 오른쪽
		int[] dj = { 0, 0, -1, 1 };

		StringBuffer sb = new StringBuffer();

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(bf.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			char[][] board = new char[row][col];

			int ci = 0;
			int cj = 0;
			int cd = 0;

			for (int i = 0; i < row; i++) {
				String s = bf.readLine();
				for (int j = 0; j < col; j++) {
					board[i][j] = s.charAt(j);

					if (board[i][j] == '<') {
						ci = i;
						cj = j;
						board[i][j] = '.';
						cd = 2;
					} else if (board[i][j] == '^') {
						ci = i;
						cj = j;
						board[i][j] = '.';
						cd = 0;
					} else if (board[i][j] == 'v') {
						ci = i;
						cj = j;
						board[i][j] = '.';
						cd = 1;
					} else if (board[i][j] == '>') {
						ci = i;
						cj = j;
						board[i][j] = '.';
						cd = 3;
					}
				}
			}

			int cmdCount = Integer.parseInt(bf.readLine());
			char[] cmd = bf.readLine().toCharArray();

			for (int i = 0; i < cmd.length; i++) {
				int ni = 0;
				int nj = 0;
				boolean s = false;
				switch (cmd[i]) {
				case 'U':
					cd = 0;
					break;
				case 'D':
					cd = 1;
					break;
				case 'L':
					cd = 2;
					break;
				case 'R':
					cd = 3;
					break;
				case 'S':
					s = true;
					break;
				}

				if (!s) {
					ni = ci + di[cd];
					nj = cj + dj[cd];
					if (ni < 0 || ni >= row || nj < 0 || nj >= col)
						continue;

					if (board[ni][nj] != '.')
						continue;

					ci = ni;
					cj = nj;
				} else {
					ni = ci;
					nj = cj;
					while (true) {
						ni += di[cd];
						nj += dj[cd];
						if (ni < 0 || ni >= row || nj < 0 || nj >= col)
							break;
						if (board[ni][nj] == '*') {
							board[ni][nj] = '.';
							break;
						} else if (board[ni][nj] == '#') {
							break;
						}

					}
				}
			}

			switch (cd) {
			case 0:
				board[ci][cj] = '^';
				break;
			case 1:
				board[ci][cj] = 'v';
				break;
			case 2:
				board[ci][cj] = '<';
				break;
			case 3:
				board[ci][cj] = '>';
				break;
			}
			sb.append('#');
			sb.append(test_case);
			sb.append(' ');
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					sb.append(board[i][j]);
				}
				sb.append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}