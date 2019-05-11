#include <iostream>

using namespace std;

int input[2187][2187];
int counter[3] = { 0,0,0 };

void check(int start_i, int start_j, int size) {
	int num = input[start_i][start_j];
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			if (num != input[start_i + i][start_j + j]) {
				int next_size = size / 3;
				for (int a = 0; a<3; a++) {
					for (int b = 0; b < 3; b++) {
						check(start_i + a*next_size, start_j + b*next_size, next_size);
					}
				}
				return;
			}
		}
	}
	counter[num + 1]++;
}


int main() {
	int n;
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &input[i][j]);
		}
	}

	check(0, 0, n);

	for (int i = 0; i < 3; i++) {
		printf("%d\n", counter[i]);
	}
}