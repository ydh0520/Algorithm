import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_6087 {
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[h][w];
		int[][] mem = new int[h][w];
		List<loc> link = new LinkedList<loc>();

		for (int i = 0; i < h; i++) {
			String s = br.readLine();
			for (int j = 0; j < w; j++) {
				char c = s.charAt(j);

				if (c == '.') {
					map[i][j] = true;
				} else if (c == 'C') {
					map[i][j] = true;
					link.add(new loc(i, j));
				}
				mem[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<loc> q = new LinkedList<>();
		q.add(link.get(0));

		int count = -1;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				loc cur = q.poll();
				if (mem[cur.i][cur.j] < count)
					continue;

				mem[cur.i][cur.j] = count;

				for (int d = 0; d < 4; d++) {
					int ni = cur.i;
					int nj = cur.j;

					while (true) {
						ni += di[d];
						nj += dj[d];

						if (ni < 0 || ni >= h || nj < 0 || nj >= w || !map[ni][nj])
							break;

						if (mem[ni][nj] > count + 1) {
							mem[ni][nj] = count + 1;
							q.add(new loc(ni, nj));
						}
					}

				}

			}
			count++;
		}

		loc goal = link.get(1);
		System.out.println(mem[goal.i][goal.j]);
	}

	public static class loc {
		int i, j;

		public loc(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
