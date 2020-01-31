import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10942 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb=new StringBuffer();
		int size= Integer.parseInt(bf.readLine());
		int number[] = new int[size];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<size;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		int check[][] = new int[size][size];

		for (int i = 0; i < size; i++) {
			for(int j=0;j<size-i;j++) {
				if(j==(j+i))
					check[j][j+i]=1;
				else if(number[j]==number[j+i])
					if(j+1>j+i-1)
						check[j][j+i]=1;
					else if(check[j+1][j+i-1]==1)
						check[j][j+i]=1;
			}
		}
		
		int qeustion= Integer.parseInt(bf.readLine());
		for(int i=0;i<qeustion;i++) {
			st=new StringTokenizer(bf.readLine());
			int start= Integer.parseInt(st.nextToken());
			int end= Integer.parseInt(st.nextToken());
			
			sb.append(check[start-1][end-1]);
			sb.append('\n');
		}
		
	}
}
