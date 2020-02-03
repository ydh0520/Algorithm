package MyAlgo;

import java.util.Scanner;

public class Solution_2294 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int coinKind=scan.nextInt();
		int price=scan.nextInt();
		
		int coinValue[]=new int[coinKind];
		
		for(int i=0;i<coinKind;i++)
			coinValue[i]=scan.nextInt();
		
		int dp[] = new int[price+1];
		
		for(int i=1;i<dp.length;i++) {
			dp[i]=100001;
		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<coinKind;j++) {
				if(i+coinValue[j]>=dp.length) continue;
				if(dp[i]+1<dp[i+coinValue[j]])
					dp[i+coinValue[j]] = dp[i]+1;
			}
		}
	
		if(dp[price]==100001)
			System.out.println(-1);
		else
			System.out.println(dp[price]);
	}
	
}
