/*
 * 백준 알고리즘 10610 30
 */

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	string input;
	int temp, check = 0;
	bool zero = false;
	vector<int> num;
	getline(cin, input);
	
	for (int i = 0; i < input.length(); i++) {
		temp = (int)input.at(i)-'0';
		if (!zero&&temp == 0)
			zero = true;
		else {
			num.push_back(temp);
			check += temp;
		}
	}

	if (check % 3 == 0 && zero) {
		sort(num.begin(), num.end());
		for (int i = num.size() - 1; i > -1; i--)
			cout << num[i];
		cout << 0;
	}
	else {
		cout << -1;
	}
}