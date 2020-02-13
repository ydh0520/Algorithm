package myalgo;

import java.util.Scanner;

public class Soultion_2522 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();

		Scanner scan = new Scanner(System.in);

		int size = scan.nextInt();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				sb.append(' ');
			}
			for (int j = 0; j <= i; j++) {
				sb.append('*');
			}

			sb.append('\n');
		}
		
		for (int i = 0; i < size-1; i++) {
			for (int j = 0; j <= i; j++) {
				sb.append(' ');
			}
			for (int j = 0; j < size - i - 1; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}
}
