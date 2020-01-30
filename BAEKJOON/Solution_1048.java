import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1048 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuffer sb = new StringBuffer();

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int board[][] = new int[r][c];
		
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<c;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int mem[][]= new int[r][c];
		mem[0][0]=board[0][0];
		int di[] = {-1,0,-1};
		int dj[] = {0,-1,-1};
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				for(int d=0;d<3;d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					
					if(ni<0||ni>=r) continue;
					if(nj<0||nj>=c) continue;
					
					int next =mem[ni][nj]+board[i][j];
					
					if(mem[i][j]<next)
						mem[i][j]=next;
				}
			}
		}
		
		
		System.out.println(mem[r-1][c-1]);
	}
}
