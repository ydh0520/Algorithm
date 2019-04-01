#include <iostream>

using namespace std;

int input[64][64]; 
void div(int x, int y, int size);
void check(int x, int y, int size);



int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1d", &input[i][j]);
		}
	}

	check(0, 0, n);
}

void div(int x, int y, int size) {
	printf("(");
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			check(x + i * size, y + j * size, size);
		}
	}
	printf(")");
}

void check(int x, int y, int size) {
	int num = input[x][y];

	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			if (input[x+i][y+j] != num) {
				div(x, y, size / 2);
				return;
			}
		}
	}
	printf("%d", num);
}
