import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8741 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int tc = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			sb.append("#"+test_case+' ');
			String input = bf.readLine();
			st = new StringTokenizer(input);
			for(int i=0; i<3;i++) {
				sb.append(st.nextToken().charAt(0));
			}
			sb.append('\n');
		}
		System.out.println(sb.toString().toUpperCase());
	}
}
