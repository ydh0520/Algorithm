package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution_5658 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			String input = scan.next();
			int size = n / 4;
			HashSet<String> list = new HashSet<String>();

			for (int i = 0; i < n; i++) {
				String cur = "";

				for (int j = 0; j < size; j++) {
					int ni = i + j;

					if (ni >= n)
						ni -= n;

					cur += input.charAt(ni);
				}
				list.add(cur);
			}
			List<String> result = new ArrayList<String>(list);
			Collections.sort(result);
			System.out.println(Integer.parseInt(result.get(n-k-1),16));
		}
	}
}
