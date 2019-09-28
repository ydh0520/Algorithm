#include <iostream>
#include <vector>

#define limit 8

using namespace std;

int select_check[limit];
int n, m;

void print_selected() {
	for (int i = 0; i < n; i++) {
		if (select_check[i] == 1) {
			printf("%d ", i + 1);
		}
	}
	printf("\n");
}

void select(int start, int count) {
	if (count == m) {
		print_selected();
		return;
	}

	for (int i = start; i < n; i++) {
		select_check[i] = 1;

		select(i + 1, count + 1);

		select_check[i] = 0;
	}
}


int main() {
	scanf("%d %d", &n, &m);
	select(0,0);
}