package myalgo;

import java.util.Scanner;

public class Solution_11058 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int input = scan.nextInt();
		long dp[] = new long[input + 1];

		for (int i = 1; i < dp.length; i++) {
			if (dp[i] < dp[i - 1] + 1) {
				dp[i] = dp[i - 1] + 1;
			}

			for (int j = 3; i - j > 0; j++) {
				if (dp[i] < dp[i - j] * (j - 1))
					dp[i] = dp[i - j] * (j - 1);
			}
		}

		System.out.println(dp[input]);
	}
}
