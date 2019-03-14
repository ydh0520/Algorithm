/*
 * 백준 알고리즘 3020 개똥벌레
 * 규칙찾기
 *
 */

#include <iostream>
#include <vector>

using namespace std;

int main() {
	int N, H, temp1, temp2 , min = 200000, root=0;
	cin >> N >> H;
	vector<int> top(H);
	vector<int> bottom(H);

	for (int i = 0; i < N/2; i++) {
		cin >> temp1 >> temp2;
		top[temp1-1]++;
		bottom[temp2-1]++;
	}

	for (int i = H-1; i > 0; i--) {
		top[i - 1] += top[i];
		bottom[i - 1] += bottom[i];
	}

	for (int i = 0; i < H; i++) {
		temp1 = bottom[i] + top[H - 1 - i];
		if (min == temp1)
			root++;
		else if (min > temp1) {
			min = temp1;
			root = 1;
		}
	}

	cout << min << " " << root;
}