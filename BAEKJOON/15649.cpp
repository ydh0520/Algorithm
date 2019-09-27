#include <iostream>
#include <vector>

#define limit 8

using namespace std;

int select_check[limit];
vector<int> selected;

int n, m;

void print_selected() {
	for (int i = 0; i < m; i++) {
		printf("%d ", selected.at(i)+1);
	}
	printf("\n");
}

void select(int count) {
	if (count == m) {
		print_selected();
	}
	else {
		for (int i = 0; i < n; i++) {
			if (select_check[i] == 1) {
				continue;
			}
			else {
				select_check[i] = 1;
				selected.push_back(i);
				count++;
				select(count);
				count--;
				selected.pop_back();
				select_check[i] = 0;
			}
		}
	}
}


int main() {
	scanf("%d %d", &n, &m);
	select(0);
}
