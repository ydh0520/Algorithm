#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n, m, k;
	cin >> n >> m >> k;
	if ((m + k - 1 <= n) && (n <= m*k)) {
		int* counter = new int[m];
		int temp1, temp2;
		if (k == 1) {
			temp1 = 0;
			temp2 = 0;
		}else {
			temp1 = (n - m) / (k - 1);
			temp2 = (n - m) % (k - 1);
		}

		for (int i = 0; i < m; i++) {
			counter[i] = 1;
			if (i < temp1) {
				counter[i] = k;
			}
			else if (i == temp1) {
				counter[i] += temp2;
			}
		}
		int out =0;
		for (int i = 0; i < m; i++) {
			out+=counter[i];
			for (int j = 0; j < counter[i]; j++) {
				cout << out<<" ";
				out--;
			}
			out += counter[i];
		}
	}else {
		cout << -1;
	}
}