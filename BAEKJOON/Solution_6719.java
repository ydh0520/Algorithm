package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_6719 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = scan.nextInt();
			int k = scan.nextInt();

			int[] input = new int[n];

			for (int i = 0; i < n; i++) {
				input[i] = scan.nextInt();
			}

			Arrays.sort(input);

			double result = 0.0;

			for (int i = n - k; i < n; i++) {
				result = (result + input[i]) / 2;
			}

			System.out.printf("#%d %.6f\n", test_case, result);
		}
	}
}
