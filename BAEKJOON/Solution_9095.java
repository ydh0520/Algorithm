import java.util.Scanner;

public class Solution_9095 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int maximum = 12;
		int dp[] = new int[maximum];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < maximum; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		int testCase = scan.nextInt();
		for(int i=0;i<testCase;i++) {
			int input= scan.nextInt();
			System.out.println(dp[input]);
			
		}
	}
}
