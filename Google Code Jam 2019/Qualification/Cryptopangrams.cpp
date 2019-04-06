#include <iostream>
using namespace std;

bool check4(int a) {
	while (a > 0) {
		if (a % 10 == 4)
			return false;
		a /= 10;
	}
	return true;
}

char input[10000];

int main() {
	int t, n, a, b;
	scanf("%d", &t);
	for (int i = 1; i <= t; i++) {
		scanf("%d", &n);
		n = 2 * n - 2;
		scanf("%s", input);
		printf("Case #%d: ",i);
		for (int j = 0; j<n; j++) {
			if (input[j] == 'S')
				printf("%c", 'E');
			else
				printf("%c", 'S');
		}
		printf("\n");
	}
}