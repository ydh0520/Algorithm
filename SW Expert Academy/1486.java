package myalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486 {
	
	static int min = Integer.MAX_VALUE;
	static int s;
	static int input[];
	public static void solve(int height,int count) {
		if(input.length==count) {
			if(height>=s&&height<min) {
				min = height;
			}
		}else {
			solve(height, count+1);
			solve(height+input[count], count+1);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int Tc = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= Tc; test_case++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			input = new int[n];
			for(int i=0;i<n;i++) {
				input[i]=Integer.parseInt(st.nextToken());
			}
			solve(0, 0);
			sb.append("#"+test_case+' '+(min-s)+'\n');
		}
		System.out.println(sb.toString());
	}
}
