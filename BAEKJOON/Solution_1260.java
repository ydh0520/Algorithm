import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean board[][];
	static boolean bfs_visit[];
	static boolean dfs_visit[];

	static StringBuffer bfs_result = new StringBuffer();
	static StringBuffer dfs_result = new StringBuffer();

	static Queue<Integer> queue = new LinkedList<>();
	static Stack<Integer> stack = new Stack<>();

	static int vertex;

	public static void dfs() {
		if (!stack.isEmpty()) {
			int current = stack.pop();
			if (!dfs_visit[current]) {
				dfs_result.append(current + " ");
				dfs_visit[current] = true;

				for (int i = vertex; i > 0; i--) {
					if (board[current][i] && !dfs_visit[i]) {
						stack.add(i);
					}
				}
			}
			dfs();
		}
	}

	public static void bfs() {
		if (!queue.isEmpty()) {
			int current = queue.poll();

			if (!bfs_visit[current]) {
				bfs_result.append(current + " ");
				bfs_visit[current] = true;

				for (int i = 1; i <= vertex; i++) {
					if (board[current][i] && !bfs_visit[i]) {
						queue.add(i);
					}
				}
			}
			bfs();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		board = new boolean[vertex + 1][vertex + 1];
		bfs_visit = new boolean[vertex + 1];
		dfs_visit = new boolean[vertex + 1];

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(bf.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			board[v1][v2] = board[v2][v1] = true;
		}
		queue.add(start);
		stack.add(start);

		dfs();
		bfs();

		System.out.println(dfs_result.toString());
		System.out.println(bfs_result.toString());

	}
}