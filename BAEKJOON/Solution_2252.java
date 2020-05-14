package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2252 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();

		int[] indegree = new int[n + 1];

		List<List<Integer>> edge = new ArrayList<List<Integer>>();

		for (int i = 0; i <= n; i++) {
			edge.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();

			edge.get(start).add(end);
			indegree[end]++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}
		StringBuffer sb = new StringBuffer();
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < edge.get(cur).size(); i++) {
				int next = edge.get(cur).get(i);

				if (--indegree[next] == 0) {
					queue.add(next);
				}
			}
			sb.append(cur);
			sb.append(' ');
		}
		System.out.println(sb.toString());
	}

}
