import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1890 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuffer sb = new StringBuffer();

		int n = Integer.parseInt(bf.readLine());
		
		int board[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long mem[][]= new long[n][n];
		mem[0][0]=1;
		int di[] = {1,0};
		int dj[] = {0,1};
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int d=0;d<2;d++) {
					int ni = i+di[d]*board[i][j];
					int nj = j+dj[d]*board[i][j];
					
					if(ni<0||ni>=n) continue;
					if(nj<0||nj>=n) continue;
					
					if(board[i][j]==0) continue;
					mem[ni][nj] += mem[i][j];
				}
			}
		}
		
		
		System.out.println(mem[n-1][n-1]);
	}
}
