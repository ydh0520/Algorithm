#include <iostream>
#include <vector>
#include <algorithm>

#define limit 8

using namespace std;

int n, m;
vector<int> selected;
vector<int> input;


void print_selected() {
	for (int i = 0; i < selected.size(); i++) {
		printf("%d ", selected.at(i));
	}
	printf("\n");
}

void select(int start, int count) {
	if (count == m) {
		print_selected();
		return;
	}

	for (int i = start; i < n; i++) {
		selected.push_back(input.at(i));
		select(i, count + 1);
		selected.pop_back();
	}
}


int main() {
	scanf("%d %d", &n, &m);
	int temp;
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		input.push_back(temp);
	}
	
	sort(input.begin(), input.end());
	select(0,0);
}