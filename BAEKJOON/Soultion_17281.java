package myalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Soultion_17281 {

	static int predict[][];
	static int max;
	static int inning;

	static ArrayList<List> list;
	static boolean visit[];

	public static void makeList(int arr[], int count) {
		if (count == 8) {
			list.add(new List(arr));
		} else {
			for (int i = 0; i < 8; i++) {
				if (visit[i])
					continue;

				visit[i] = true;
				arr[count] = i;
				makeList(arr, count + 1);
				visit[i] = false;
			}
		}
	}

	public static void play(int listIndex) {
		int player[] = list.get(listIndex).list;
		int current = 0;
		int score = 0;

		for (int i = 0; i < inning; i++) {
			boolean base[] = new boolean[4];
			int outCount = 0;

			while (outCount < 3) {
				int hitResult = predict[i][player[current]];

				if (hitResult == 0) {
					outCount++;
				} else {
					boolean nextBase[] = new boolean[4];
					int inningScore = 0;
					for (int j = 1; j < 4; j++) {
						if (base[j]) {
							if (j + hitResult < 4) {
								nextBase[j + hitResult] = true;
							} else {
								inningScore++;
							}
						}
					}
					base = nextBase;
					score+=inningScore;
					if (hitResult == 4)
						score++;
					else {
						base[hitResult] = true;
					}
				}
				current = (current + 1) % 9;
			}
		}

		if (max < score) {
			max = score;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 입력 초기화
		inning = scan.nextInt();
		predict = new int[inning][9];
		for (int i = 0; i < inning; i++) {
			for (int j = 0; j < 9; j++) {
				predict[i][j] = scan.nextInt();
			}
		}

		max = 0;
		list = new ArrayList<>();
		visit = new boolean[8];
		// 입력 및 초기화 완료

		// 조합 생성
		makeList(new int[8], 0);
		// 조합 생성 완료

		for (int i = 0; i < list.size(); i++) {
			play(i);
		}
		System.out.println(max);
	}

	public static class List {
		int list[];

		public List(int[] arr) {
			list = new int[9];
			list[3] = 0;
			int index = 0;
			for (int i = 0; i < 8; i++) {
				if (index == 3)
					index++;
				this.list[index] = arr[i] + 1;
				index++;
			}
		}

		@Override
		public String toString() {
			return Arrays.toString(list);
		}
	}
}