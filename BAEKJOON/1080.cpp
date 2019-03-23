/*
* 행렬 규칙을 찾아 그리드 알고리즘을 통해 해결
* cin을통해 010을 입력받을시 8진법으로 인식하여 잘못된 입력을 받을수 있다. 
* 귀찮더라도 scanf를 사용하자
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N, M , counter = 0;
	cin >> N >> M;

	int matrix_A[50][50];
	int matrix_B[50][50];

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf_s("%1d", &matrix_A[i][j]);
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf_s("%1d", &matrix_B[i][j]);
		}
	}
	

	for (int i = 0; i < N - 2; i++) {
		for (int j = 0; j < M-2; j++){
			if (matrix_A[i][j] != matrix_B[i][j]) {
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						matrix_A[i + a][j + b]=!matrix_A[i + a][j + b];
					}
				}
				counter++;
			}
		}
	}

	for (int i = 0; i < N; i++){
		for (int j = 0; j < M; j++) {
			if (matrix_A[i][j] != matrix_B[i][j])
				counter = -1;
		}
	}

	cout << counter;
}