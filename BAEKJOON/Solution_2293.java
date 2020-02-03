package MyAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2293 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int coinKind = scan.nextInt();
		int price = scan.nextInt();
		int coinValue[] = new int[coinKind];

		for (int i = 0; i < coinKind; i++) {
			coinValue[i] = scan.nextInt();
		}
		Arrays.sort(coinValue);
		int mem[][] = new int[10001][coinKind];

		for (int i = 0; i < coinValue.length; i++) {
			if(coinValue[i]>10000) continue;
			mem[coinValue[i]][i] = 1;
		}

		for (int i = 1; i < 10001; i++) {
			for (int j = 0; j < coinKind; j++) {
				if (i - coinValue[j] <= 0)
					continue;
				for (int k = 0; k <= j; k++) {
					mem[i][j] += mem[i - coinValue[j]][k];
				}
			}
		}
		int result = 0;
		for (int i = 0; i < coinKind; i++) {
			result += mem[price][i];
		}
		System.out.println(result);

	}
}
