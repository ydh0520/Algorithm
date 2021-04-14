import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 지형이동 {
	public static void main(String[] args) {
		int[][] land = { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 }, { 10, 10, 10, 20 } };
		System.out.println(solution(land, 3));
	}

	public static int[] di = { 0, 1 };
	public static int[] dj = { 1, 0 };

	public static int[] set;

	public static int r, c;

	public static int solution(int[][] land, int height) {
		int answer = 0;

		r = land.length;
		c = land[0].length;

		set = new int[r * c];

		int index = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				set[index] = index++;
			}
		}

		PriorityQueue<link> queue = new PriorityQueue<link>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int curi = i * c + j;
				for (int d = 0; d < 2; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (ni < 0 || ni >= r || nj < 0 || nj >= c)
						continue;

					int curj = ni * c + nj;
					if (Math.abs(land[i][j] - land[ni][nj]) <= height) {
						union(curi, curj);
					} else {
						queue.add(new link(curi, curj, Math.abs(land[i][j] - land[ni][nj])));
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			link cur = queue.poll();

			if (find(cur.i) == find(cur.j))
				continue;
			answer += cur.v;
			union(cur.i, cur.j);
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				find(i * c + j);
			}
		}

		return answer;
	}

	public static class link implements Comparable<link> {
		int i, j, v;

		public link(int i, int j, int v) {
			this.i = i;
			this.j = j;
			this.v = v;
		}

		@Override
		public int compareTo(link o) {
			// TODO Auto-generated method stub
			return this.v - o.v;
		}

		@Override
		public String toString() {
			return "link [i=" + i + ", j=" + j + ", v=" + v + "]";
		}

	}

	public static void union(int i, int j) {
		int headi = find(Math.min(i, j));
		int headj = find(Math.max(i, j));

		if (headi != headj) {
			set[headj] = headi;
		}
	}

	public static int find(int i) {
		int headi = set[i];

		if (headi == i)
			return headi;

		set[i] = find(headi);
		return set[i];
	}
}
