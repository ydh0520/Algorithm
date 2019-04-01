#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n,m,temp;
	scanf("%d", &n);

	vector<int> input(n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		input[i] = temp;
	}

	sort(input.begin(), input.end());

	scanf("%d", &m);

	int start, end;
	for (int i = 0; i < m; i++) {
		start = 0, end = n - 1;
		scanf("%d", &temp);
		while (1) {
			if (start == end) {
				if (input[start] == temp)
					printf("%d ", 1);
				else
					printf("%d ", 0);
				break;
			}
			else {
				if(input[(start+end)/2]<temp){
					start = (start + end) / 2+1;
				}
				else {
					end = (start + end) / 2;
				}
			}
		}
	}

}