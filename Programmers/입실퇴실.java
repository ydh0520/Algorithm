import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class 입실퇴실 {
	public static void main(String[] args) {

		int[] enter = { 1, 4, 2, 3 };
		int[] leave = { 2, 1, 3, 4 };
		System.out.println(Arrays.toString(solution(enter, leave)));
	}

	public static int[] solution(int[] enter, int[] leave) {
		int n = enter.length;
		int[] answer = new int[n];

		HashSet<Integer> man = new HashSet<>();

		List<HashSet<Integer>> counter = new LinkedList<>();

		for (int i = 0; i <= n; i++) {
			counter.add(new HashSet<Integer>());
		}

		int j = 0;
		for (int i = 0; i < n; i++) {
			if (man.contains(leave[i])) {
				man.remove(leave[i]);
			} else {
				while (!man.contains(leave[i])) {
					int e = enter[j];

					for (int cur : man) {
						counter.get(cur).add(e);
						counter.get(e).add(cur);
					}

					man.add(e);
					j++;
				}
				i--;
			}

		}

		for (int i = 1; i <= n; i++) {
			answer[i - 1] = counter.get(i).size();
		}

		return answer;
	}
}
