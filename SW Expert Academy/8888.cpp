import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_8888 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Scanner scan = new Scanner(System.in);
		int Tc = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= Tc; test_case++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			p--;
			int point[] = new int[t];
			int info[][] = new int[n][t];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < t; j++) {
					info[i][j] = Integer.parseInt(st.nextToken());
					if (info[i][j] == 1)
						point[j]++;
				}
			}

			int zhscore = 0;
			int zhcount = 0;
			int result = 1;
			for (int i = 0; i < t; i++)
				if (info[p][i] == 1) {
					zhscore += n - point[i];
					zhcount++;
				}

			for (int i = 0; i < n; i++) {
				int count = 0;
				int score = 0;

				if (i == p)
					continue;
				for (int j = 0; j < t; j++) {
					if (info[i][j] == 1) {
						score += n - point[j];
						count++;
					}
				}

				if (score > zhscore) {
					result++;
				} else if (score == zhscore) {
					if (count > zhcount) {
						result++;
					} else if (count == zhcount) {
						if (i < p)
							result++;
					}
				}
			}

			System.out.println("#" + test_case + " " + zhscore + " " + result);
		}
	}
}
