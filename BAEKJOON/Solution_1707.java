import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] set;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int vertex = scan.nextInt();
			int edge = scan.nextInt();

			boolean result = true;

			set = new int[vertex];
			ArrayList<Integer>[] link = new ArrayList[vertex];

			for (int i = 0; i < vertex; i++) {
				link[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < edge; i++) {
				int v1 = scan.nextInt() - 1;
				int v2 = scan.nextInt() - 1;

				link[v1].add(v2);
				link[v2].add(v1);
			}

			Queue<Integer> queue = new LinkedList<Integer>();

			queue.add(0);
			set[0] = 1;

			while (true) {

				if (!queue.isEmpty()) {
					int current = queue.poll();
					int currentset = set[current];

					if (currentset == 1)
						currentset = 2;
					else
						currentset = 1;

					for (int i = 0; i < link[current].size(); i++) {
						int next = link[current].get(i);
						if (set[next] == 0) {
							set[next] = currentset;
							queue.add(next);
						} else {
							if (set[next] != currentset) {
								queue.clear();
								result = false;
								break;
							}
						}

					}
				} else {
					for (int i = 0; i < vertex; i++) {
						if (set[i] == 0) {
							queue.add(i);
							set[i] = 1;
							break;
						}
					}
					if (queue.isEmpty()) {
						break;
					}

				}

			}

			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}
}