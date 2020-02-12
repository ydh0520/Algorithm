import java.util.Scanner;

public class Solution_8979 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int size = scan.nextInt();
		int target = scan.nextInt();

		int[][] contry = new int[size + 1][3];

		for (int i = 1; i < contry.length; i++) {
			int index = scan.nextInt();
			contry[index][0] = scan.nextInt();
			contry[index][1] = scan.nextInt();
			contry[index][2] = scan.nextInt();
		}

		int count = 0;

		for (int i = 1; i < contry.length; i++) {
			if(contry[i][0]>contry[target][0]) {
				count++;
			}else if(contry[i][0]==contry[target][0]) {
				if(contry[i][1]>contry[target][1]) {
					count++;
				}else if(contry[i][1]==contry[target][1]) {
					if(contry[i][2]>contry[target][2]) {
						count++;
					}
				}	
			}
		}

		System.out.println(count + 1);
	}
}
