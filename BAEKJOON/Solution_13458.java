package day0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13458 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(bf.readLine());
		int[] room = new int[size];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < size; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		long count = 0;

		for (int i = 0; i < size; i++) {
			count++;
			room[i] -= main;

			if (room[i] <= 0)
				continue;
			count += room[i] / sub;
			if (room[i] % sub != 0)
				count++;
		}

		System.out.println(count);

	}
}
