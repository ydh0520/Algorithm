import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2037 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int push = Integer.parseInt(st.nextToken());
		int wait = Integer.parseInt(st.nextToken());

		char[] input = bf.readLine().toCharArray();

		int[][] button = new int[input.length][2];

		for (int i = 0; i < input.length; i++) {
			switch (input[i]) {
			case 'A':
			case 'B':
			case 'C':
				button[i][0] = 0;
				button[i][1] = (input[i] - 'A') % 3 + 1;
				break;
			case 'D':
			case 'E':
			case 'F':
				button[i][0] = 1;
				button[i][1] = (input[i] - 'D') % 3 + 1;
				break;
			case 'G':
			case 'H':
			case 'I':
				button[i][0] = 2;
				button[i][1] = (input[i] - 'G') % 3 + 1;
				break;
			case 'J':
			case 'K':
			case 'L':
				button[i][0] = 3;
				button[i][1] = (input[i] - 'J') % 3 + 1;
				break;
			case 'M':
			case 'N':
			case 'O':
				button[i][0] = 4;
				button[i][1] = (input[i] - 'M') % 3 + 1;
				break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				button[i][0] = 5;
				button[i][1] = (input[i] - 'P') % 4 + 1;
				break;
			case 'T':
			case 'U':
			case 'V':
				button[i][0] = 6;
				button[i][1] = (input[i] - 'T') % 3 + 1;
				break;
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				button[i][0] = 7;
				button[i][1] = (input[i] - 'W') % 4 + 1;
				break;
			default:
				button[i][0] = 8;
				button[i][1] = 1;
				break;
			}
		}
		long time = button[0][1] * push;
		for (int i = 1; i < button.length; i++) {
			if (button[i - 1][0] == button[i][0]) {
				if(button[i][0]!=8)
					time += wait;
			}
			time += button[i][1] * push;
		}
		System.out.println(time);

	}
}
