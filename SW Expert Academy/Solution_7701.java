package day0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_7701 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		StringBuffer sb = new StringBuffer();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int size = Integer.parseInt(bf.readLine());
			ArrayList<String> input = new ArrayList<String>();

			sb.append('#');
			sb.append(test_case);
			sb.append('\n');

			for (int i = 0; i < size; i++) {
				input.add(bf.readLine());
			}

			Collections.sort(input, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						if (o1.equals(o2))
							return 0;
						int i = 0;

						while (i < o1.length()) {
							if (o1.charAt(i) == o2.charAt(i)) {
								i++;
								continue;
							}
							return o1.charAt(i) - o2.charAt(i);
						}
					}

					return o1.length() - o2.length();
				}
			});

			String pre = "";
			for (int i = 0; i < size; i++) {
				if (pre.equals(input.get(i))) {
					continue;
				}
				pre = input.get(i);
				sb.append(pre);
				sb.append('\n');
			}

		}
		System.out.println(sb.toString());
	}
}
