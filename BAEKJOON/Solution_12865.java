package day210310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] w = new int[n];
		int[] v = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n][k + 1];

		for (int i = w[0]; i <= k; i++) {
			dp[0][i] = v[0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = dp[i - 1][j];

				if (j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
				}

			}

		}

		System.out.println(dp[n - 1][k]);
	}
}
