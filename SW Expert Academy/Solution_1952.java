package day0227;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1952 {
	static int[] month;
	static int[] price;
	static int min;

	public static void select(int index, int result) {
		if (index > 9) {
			for (int i = index; i < 12; i++)
				result += month[i];
			if (result < min)
				min = result;
		} else {
			int temp = month[index] + month[index + 1] + month[index + 2];

			if (temp > price[2]) {
				select(index + 3, result + price[2]);
			}
			select(index + 1, result + month[index]);

		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			price = new int[4];
			month = new int[12];

			for (int i = 0; i < 4; i++) {
				price[i] = scan.nextInt();
			}

			for (int i = 0; i < 12; i++) {
				int day = scan.nextInt();
				day *= price[0];
				if (day > price[1])
					day = price[1];
				month[i] = day;
			}
			min = price[3];
			select(0, 0);
			System.out.println("#" + test_case + " " + min);
		}
	}
}
