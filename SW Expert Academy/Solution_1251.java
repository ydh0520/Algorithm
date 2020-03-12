package day0310;

import java.util.Currency;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_1251 {
	static int size;
	static int[] locationx, locationy;
	static int[] set;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			size = scan.nextInt();
			locationx = new int[size];
			locationy = new int[size];

			for (int i = 0; i < size; i++) {
				locationx[i] = scan.nextInt();
			}
			for (int i = 0; i < size; i++) {
				locationy[i] = scan.nextInt();
			}

			double tax = scan.nextDouble();

			PriorityQueue<Tunnel> list = new PriorityQueue<Tunnel>();

			for (int i = 0; i < size; i++) {
				for (int j = i + 1; j < size; j++) {
					list.add(new Tunnel(i, j));
				}
			}

			set = new int[size];
			for (int i = 0; i < size; i++) {
				set[i] = i;
			}
			double total = 0;
			int linkCount = 0;
			while (!list.isEmpty()) {
				Tunnel current = list.poll();
				if (union(current.start, current.end)) {
					total += current.length;
					linkCount++;
				}
				if (linkCount == size - 1) {
					list.clear();
				}
			}
			System.out.println(String.format("#%d %.0f", test_case, total * tax));
		}
	}

	static int find(int i) {
		if (i == set[i])
			return i;

		int head = find(set[i]);
		set[i] = head;
		return head;
	}

	static boolean union(int i, int j) {
		int headi = find(i);
		int headj = find(j);

		if (headi == headj)
			return false;
		else {
			set[headj] = headi;
			return true;
		}
	}

	static class Tunnel implements Comparable<Tunnel> {
		int start, end;
		double length;

		public Tunnel(int start, int end) {
			this.start = start;
			this.end = end;

			double diffx = locationx[start] - locationx[end];
			double diffy = locationy[start] - locationy[end];

			this.length = diffx * diffx + diffy * diffy;
		}

		@Override
		public int compareTo(Tunnel o) {
			return (int) (this.length - o.length);
		}
	}
}
