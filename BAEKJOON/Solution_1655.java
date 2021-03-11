package day210310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1655 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		PriorityQueue<Integer> front = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> back = new PriorityQueue<Integer>();

		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (front.size() == 0) {
				front.add(cur);
			} else {
				int mid = front.peek();

				if (cur < mid) {
					front.add(cur);
					if (front.size() - back.size() > 1) {
						back.add(front.poll());
					}
				} else {
					back.add(cur);
					if (back.size() > front.size()) {
						front.add(back.poll());
					}
				}
			}
			sb.append(front.peek());
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
