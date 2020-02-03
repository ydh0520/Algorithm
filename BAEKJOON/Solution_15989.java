package MyAlgo;

import java.util.Scanner;

public class Solution_15989 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc= scan.nextInt();
		int mem[][]=new int[10001][3];
		
		//3가지 base case를 구한다
		mem[1][0]=mem[2][0]=mem[2][1]=mem[3][0]=mem[3][1]=mem[3][2]=1;
		
		
		for(int i=4;i<10001;i++) {
			mem[i][0] = mem[i-1][0];
			mem[i][1] = mem[i-2][0]+mem[i-2][1];
			mem[i][2] = mem[i-3][0]+mem[i-3][1]+mem[i-3][2];
		}
		
		for(int i=0;i<tc;i++) {
			int input= scan.nextInt();
			System.out.println(mem[input][0]+mem[input][1]+mem[input][2]);
		}
	}
}
