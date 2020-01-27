import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soultion_8658 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int tc = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(bf.readLine());
			int max = 0;
			int min = 1000000;
			for (int i = 0; i < 10; i++) {
				int token = Integer.parseInt(st.nextToken());
				int result = 0;

				while (token > 0) {
					result += token % 10;
					token /= 10;
				}
				
				if(result>max)
					max = result;
				if(result<min)
					min=result;
				
			}
			sb.append("#"+test_case+' '+max+' '+min+'\n');
		}
		System.out.println(sb.toString());

	}
}
