import java.util.Scanner;

public class Solutiojn_2804 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char[] first = scan.next().toCharArray();
		char[] second = scan.next().toCharArray();

		int f_index = 0;
		int s_index = 0;
		boolean stop = false;

		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < second.length; j++) {
				if (first[i] == second[j]) {
					f_index = i;
					s_index = j;
					stop = true;
					break;
				}
			}
			if (stop)
				break;
		}

		for (int i = 0; i < second.length; i++) {
			if (i == s_index) {
				System.out.println(first);
				continue;
			}
			for (int j = 0; j < first.length; j++) {
				if (j == f_index) {
					System.out.print(second[i]);
				}else {
					System.out.print('.');
				}
			}
			System.out.println();
		}

	}
}
