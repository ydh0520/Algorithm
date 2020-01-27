import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8821 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int tc = Integer.parseInt(bf.readLine());
		for(int test_case = 1;test_case<=tc;test_case++) {
			String input = bf.readLine();
			boolean check[] = new boolean[10];
			int index=0;
		
			for(int i=0;i<input.length();i++) {
				check[(int)(input.charAt(i)-'0')] = !check[(int)(input.charAt(i)-'0')] ;
			}
			
			int result = 0;
			
			for(int i=0;i<check.length;i++) {
				if(check[i])
					result++;
			}
			
			sb.append("#"+test_case+' '+result+'\n');
		}
		System.out.println(sb.toString());
	}
}
