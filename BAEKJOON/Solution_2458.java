package myalgo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2458 {
	static int size;
	static int compare;
	static boolean[][] input;
	static boolean[][] result;

	static boolean[] visit;
	static Queue<Integer> queue;

	public static void bfs(int start) {
		queue = new LinkedList<>();
		visit = new boolean[size + 1];

		queue.add(start);
		visit[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			result[start][current] = true;

			for (int i = 1; i <= size; i++) {
				if (visit[i] || i == current)
					continue;
				if (input[current][i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		size = scan.nextInt();
		compare = scan.nextInt();
		input = new boolean[size + 1][size + 1];
		result = new boolean[size + 1][size + 1];

		int shortinput, tallinput;
		for (int i = 0; i < compare; i++) {
			shortinput = scan.nextInt();
			tallinput = scan.nextInt();
			input[shortinput][tallinput] = true;
		}

		for (int i = 1; i <= size; i++) {
			bfs(i);
		}

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (result[i][j])
					result[j][i] = true;
			}
		}

		int count = 0;
		for (int i = 1; i <= size; i++) {
			boolean check = true;
			for (int j = 1; j <= size; j++) {
				if (!result[i][j])
					check = false;
				if (!check)
					break;
			}

			if (check)
				count++;
		}

		System.out.println(count);

	}
}
