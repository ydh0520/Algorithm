package day0302;

import java.util.Scanner;

public class Solution_14891 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean[][] state = new boolean[5][8];
		int[] index = { 0, 0, 0, 0, 0 };

		for (int i = 1; i <= 4; i++) {
			String input = scan.next();
			for (int j = 0; j < 8; j++) {
				if (input.charAt(j) == '1')
					state[i][j] = true;
			}
		}

		int cmd = scan.nextInt();
		for (int i = 0; i < cmd; i++) {
			int target = scan.nextInt();
			int direction = scan.nextInt();
			int[] change = new int[5];

			change[target] = direction;

			// 왼쪽
			for (int j = target - 1; j >= 1; j--) {
				boolean currentRight = state[j][(index[j] + 2) % 8];
				boolean prevLeft = state[j + 1][(index[j + 1] + 6) % 8];

				if (currentRight ^ prevLeft) {
					if (change[j + 1] == 1) {
						change[j] = -1;
					} else {
						change[j] = 1;
					}
				} else {
					break;
				}
			}
			// 오른쪽
			for (int j = target + 1; j <= 4; j++) {
				boolean currentLeft = state[j][(index[j] + 6) % 8];
				boolean prevRight = state[j - 1][(index[j - 1] + 2) % 8];

				if (currentLeft ^ prevRight) {
					if (change[j - 1] == 1) {
						change[j] = -1;
					} else {
						change[j] = 1;
					}
				} else {
					break;
				}
			}

			for (int j = 1; j <= 4; j++) {
				if (change[j] == 1) {
					index[j] = (index[j] + 7) % 8;
				} else if (change[j] == -1) {
					index[j] = (index[j] + 1) % 8;
				}
			}
		}

		int result = 0;
		int[] value = { 0, 1, 2, 4, 8 };
		for (int i = 1; i <= 4; i++) {
			if (state[i][index[i]]) {
				result += value[i];
			}
		}
		System.out.println(result);
	}
}
