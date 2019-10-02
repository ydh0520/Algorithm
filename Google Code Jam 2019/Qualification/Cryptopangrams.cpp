#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool prime[100000];


void findprime(int limit) {
	for (int i = 2; i <= limit; i++) {
		if (!prime[i]) {
			for (int j = 2; i*j <= limit; j++)
				prime[i*j] = true;
		}
	}
}

int main() {
	int t, n, l;
	cin >> t;
	for (int testcase = 0; testcase < t; testcase++) {
		int temp, prime1, prime2, pre;
		cin >> n >> l;
		vector<int> selectedprime;
		int* result=new int[l+1];
		
		findprime(n);

		printf("Case #%d: ", testcase + 1);
		
		scanf("%d", &temp);
		for (int i = 2; i <= n; i++) {
			if (!prime[i] && temp%i == 0) {
				prime1 = i;
				prime2 = temp / i;
			}
		}

		selectedprime.push_back(prime1);
		selectedprime.push_back(prime2);


		scanf("%d", &temp);
		if (temp%prime1 != 0) {
			pre = temp / prime2;
			result[0] = prime1;
			result[1] = prime2;
		}
		else {
			pre = temp / prime1;
			result[0] = prime2;
			result[1] = prime1;
		}

		result[2] = pre;
		selectedprime.push_back(pre);

		for (int i = 2; i < l; i++) {
			scanf("%d", &temp);
			pre = temp / pre;
			result[i + 1] = pre;
			selectedprime.push_back(pre);
		}

		sort(selectedprime.begin(), selectedprime.end());
		selectedprime.erase(unique(selectedprime.begin(), selectedprime.end()), selectedprime.end());

		for (int i = 0; i < l + 1; i++) {
			for (int j = 0; j < 26; j++) {
				if (result[i] == selectedprime[j]) {
					printf("%c", j + 'A');
					break;
				}
			}
		}
		printf("\n");
	}
}