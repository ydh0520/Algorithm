package algo;

import java.util.Scanner;

public class Solution_5607 {
	public static final int MOD = 1234567891;

	public static long mul(long under, int upper) {
		if (upper == 1)
			return under;

		long half = mul(under, upper / 2);

		long result = half * half;
		result %= MOD;

		if (upper % 2 != 0) {
			result *= under;
			result %= MOD;
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			long n = scan.nextInt();
			long r = scan.nextInt();
			long nr = n - r;

			long pn = 1;
			long pr = 1;
			long pnr = 1;

			for (int i = 1; i <= n; i++) {
				pn *= i;
				pn %= MOD;

				if (i == r)
					pr = pn;
				if (i == nr)
					pnr = pn;
			}

			long mpr = mul(pr, MOD - 2);
			long mpnr = mul(pnr, MOD - 2);

			long result = pn * mpr;
			result %= MOD;
			result *= mpnr;
			result %= MOD;

			System.out.println("#"+test_case+" "+result);
		}
	}
}
