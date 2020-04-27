package algo;

import java.util.Scanner;

public class Solution_5215 {
	static int size;
	static int limit;

	static int[] taste;
	static int[] cal;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tc = scan.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {
			size = scan.nextInt();
			limit = scan.nextInt();

			taste = new int[size];
			cal = new int[size];

			for (int i = 0; i < size; i++) {
				taste[i] = scan.nextInt();
				cal[i] = scan.nextInt();
			}

			int[] mem = new int[limit + 1];

			for (int i = 0; i < size; i++) {
				int[] cur = new int[limit + 1];

				for (int j = 1; j <= limit; j++) {
					int pre = j - cal[i];
					if (pre < 0) {
						cur[j] = mem[j];
						continue;
					}

					if (mem[pre] + taste[i] > mem[j]) {
						cur[j]= mem[pre] + taste[i];
					}else {
						cur[j] = mem[j];
					}

				}

				mem = cur;
			}
			System.out.println("#"+test_case+" "+mem[limit]);
		}
	}
}
