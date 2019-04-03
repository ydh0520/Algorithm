#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int checksum[9] = { 1,1,1,1,1,1,1,1,1 };
int input[9];
void find(int sum) {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < i; j++) {
			if (sum == (input[i] + input[j])) {
				checksum[i] = 0;
				checksum[j] = 0;
				return;
			}
		}
	}
}

int main() {
	int sum = 0;
	for (int i = 0; i < 9; i++) {
		cin >> input[i];
		sum += input[i];
	}
	find(sum - 100);
	vector<int> small;
	for (int i = 0; i < 9; i++) {
		if(checksum[i]==1)
			small.push_back(input[i]);
	}

	sort(small.begin(),small.end());

	for (int i = 0; i < 7; i++) {
		printf("%d\n", small[i]);
	}
}