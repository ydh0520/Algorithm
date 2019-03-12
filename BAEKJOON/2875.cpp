/*
 * 백준 알고리즘 2875 대회 or 인턴
 * 규칙찾기
*/

#include <iostream>

using namespace std;

int main() {
	int N, M, K, result = 0;
	cin >> N >> M >> K;

	result = (N / 2) < M ? N / 2 : M;

	N -= result * 2;
	M -= result;

	K -= (N + M);

	while (K>0) {
		result--;
		K -= 3;
	}

	cout << result;

}