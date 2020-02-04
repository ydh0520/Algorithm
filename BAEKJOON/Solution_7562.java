import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean visit[][];
	static int size;
	static int finish;

	static int endi;
	static int endj;

	static int di[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int dj[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static Queue<location> queue;

	public static void move() {

		if (!queue.isEmpty()) {
			location current = queue.poll();

			if (current.i == endi && current.j == endj) {
				finish = current.count;
				queue.clear();
			}
			visit[current.i][current.j] = true;
			
			for (int i = 0; i < 8; i++) {
				int ni = current.i + di[i];
				int nj = current.j + dj[i];

				if (ni < 0 || ni >= size)
					continue;
				if (nj < 0 || nj >= size)
					continue;

				if (!visit[ni][nj]) {
					visit[ni][nj] = true;
					queue.add(new location(ni, nj, current.count + 1));
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int test_case = scan.nextInt();

		for (int i = 0; i < test_case; i++) {
			size = scan.nextInt();
			int starti = scan.nextInt();
			int startj = scan.nextInt();

			endi = scan.nextInt();
			endj = scan.nextInt();

			visit = new boolean[size][size];
			finish = -1;

			queue = new LinkedList<location>();
			queue.add(new location(starti, startj, 0));
			while(!queue.isEmpty())		
				move();
			System.out.println(finish);
		}
	}

	static class location {
		int i;
		int j;
		int count;

		public location(int i, int j, int count) {
			this.i = i;
			this.j = j;
			this.count = count;
		}
	}
}