/*
 * 백준 알고리즘 1744 수 묶기
 * 규칙찾기
 *
 */

#include <iostream>
#include <algorithm>
#include <vector>
#include <functional>

using namespace std;

int main() {
	
	int n;
	cin >> n;

	vector<int> plus;
	vector<int> minus;
	bool zero = false;
	int result = 0,temp;

	for (int i = 0; i < n; i++) {
		cin >> temp;
		if (temp > 0) {
			if (temp == 1)
				result++;
			else
				plus.push_back(temp);
		}
		else {
			if (temp == 0)
				zero = true;
			else
				minus.push_back(temp);
		}
	}

	sort(plus.begin(), plus.end(),greater<int>());
	sort(minus.begin(), minus.end());

	for (int i = 0; i < plus.size() / 2; i++)
		result += (plus[i * 2] * plus[i * 2 + 1]);
	if (plus.size() % 2 == 1)
		result += plus[plus.size() - 1];

	for (int i = 0; i < minus.size() / 2; i++)
		result += (minus[i * 2] * minus[i * 2 + 1]);
	if (minus.size() % 2 == 1&&!zero) {
		result += minus[minus.size() - 1];
	}
	cout << result;
}