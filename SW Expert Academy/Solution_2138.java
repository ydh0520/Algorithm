import java.util.Scanner;

public class Solution_2138 {
	static boolean[] bulb;
	static boolean[] goal;
	static int limit;
	static int min;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		limit = scan.nextInt();
		min = Integer.MAX_VALUE;

		bulb = new boolean[limit];
		goal = new boolean[limit];

		String init = scan.next();
		for (int i = 0; i < init.length(); i++) {
			if (init.charAt(i) == '1')
				bulb[i] = true;
		}

		String result = scan.next();
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == '1')
				goal[i] = true;
		}

		
		
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}