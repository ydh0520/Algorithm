package myalgo;

import java.util.Scanner;

public class Solution_17822 {
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int count = scan.nextInt();// 돌리는 횟수

		int board[][] = new int[n+1][m];
	
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = scan.nextInt();
			}
		}


		for (int i = 0; i < count; i++) {
			int target = scan.nextInt();// 대상
			int direction = scan.nextInt();// 방향
			int offset = scan.nextInt();// 돌리는 크기
			
			if (direction == 0)
				offset = m-offset;
			
			for (int j = target; j <= n; j+=target) {
				int tmp[] = new int[m];
				for (int y = 0; y < m; y++) {
					tmp[y] = board[ j][(y + offset) % m];
				}
				board[j] = tmp;
			}		
			boolean lineflag = true;
			int sum =0 ;
			int remain=0;
			

			int next[][] = new int[n+1][m];
			for (int x = 1; x <=n; x++) {
				for (int y = 0; y < m; y++) {
					boolean flag = false;
					if (board[x][y] < 0) {
						next[x][y] = -1;
						continue;
					}
					for (int z = 0; z < 4; z++) {
						int ni = x + di[z];
						int nj = y + dj[z];

						if (ni < 1 || ni > n)
							continue;
						
						if(nj<0)
							nj=m-1;
						if(nj>=m)
							nj=0;

						if (board[ni][nj] == board[x][y]) {
							flag = true;
						}
					}

					if (flag) {
						next[x][y] = -1;
						lineflag=false;
					}else {
						next[x][y]=board[x][y];
						sum+=board[x][y];
						remain++;
					}
				}
			}
			board = next;
			
			if(lineflag) {
				double avg = (double)sum/remain;
				for(int x=1;x<=n;x++) {
					for(int y=0;y<m;y++) {
						if(board[x][y]<0)continue;
						if(avg<board[x][y]) {
							board[x][y]--;
						}else if(avg>board[x][y]){
							board[x][y]++;	
						}
					}
				}
			}
		}	
		
		int result =0;
		for(int x=1;x<=n;x++) {
			for(int y=0;y<m;y++) {
				if(board[x][y]<0)continue;
				result+=board[x][y];
			}
		}
		
		System.out.println(result);
		

	}
}
