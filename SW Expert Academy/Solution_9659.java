package algo;

import java.util.Scanner;

public class Solution_9659 {
	static int[] t;
	static int[] a, b;
	final static long MOD = 998244353;
	static boolean[] mem;
	static long[] memval;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tc = scan.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = scan.nextInt();
			t = new int[N + 1];
			a = new int[N + 1];
			b = new int[N + 1];

			for (int i = 2; i <= N; i++) {
				t[i] = scan.nextInt();
				a[i] = scan.nextInt();
				b[i] = scan.nextInt();
			}

			int M = scan.nextInt();

			sb.append("#" + test_case + " ");

			for (int i = 0; i < M; i++) {
				int x = scan.nextInt();

				memval = new long[N + 1];
				memval[0] = 1;
				memval[1] = x;

				for (int j = 2; j <= N; j++) {
					if (t[j] == 1) {
						memval[j] = (memval[a[j]] + memval[b[j]]) % MOD;
					} else if (t[j] == 2) {
						memval[j] = (a[j] * memval[b[j]]) % MOD;
					} else {
						memval[j] = (memval[a[j]] * memval[b[j]]) % MOD;
					}

				}

				sb.append(memval[N]);
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
