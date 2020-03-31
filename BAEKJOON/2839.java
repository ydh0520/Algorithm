import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] mem = new int[5001];
		int[] weight = { 3, 5 };

		mem[3] = 1;
		mem[5] = 1;

		for (int i = 0; i < mem.length; i++) {
			if (mem[i] == 0) {
				mem[i] = -1;
			} else {
				for (int j = 0; j < 2; j++) {
					int ni = i + weight[j];

					if (ni >= 5001)
						continue;

					if (mem[ni] == 0 || mem[i] + 1 < mem[ni]) {
						mem[ni] = mem[i] + 1;
					}

				}
			}
		}

		Scanner scan = new Scanner(System.in);

		System.out.println(mem[scan.nextInt()]);

	}
}