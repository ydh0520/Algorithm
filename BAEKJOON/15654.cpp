#include <iostream>
#include <algorithm>

#define limit 8

using namespace std;

int n, m;
int input[limit];
int selected[limit];
int check[limit];


void select(int count) {
	if (count == m) {
		
		for (int i = 0; i < m; i++) {
			printf("%d ", selected[i]);
		}
		printf("\n");
		return;
	}

	for (int i = 0; i < n; i++) {
		if (check[i] != 0) {
			continue;
		}

		selected[count] = input[i];
		check[i] = 1;
		select(count + 1);
		check[i] = 0;

	}
}

int main()
{
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &input[i]);
	}
	sort(input, input + n);
	select(0);
}

