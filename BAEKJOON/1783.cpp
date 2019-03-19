/*
 * 백준 알고리즘 1783 병든 나이트
 * 
 */

#include <iostream>

using namespace std;

int main() {
	int N, M,result;
	cin >> N >> M;

	if (N == 1)
		result = 1;
	else if (N == 2) {
		if (M < 7)
			result = (M + 1) / 2;
		else
			result = 4;
	}else{
		if (M < 5)
			result = M;
		else if (M < 7)
			result = 4;
		else
			result = M - 2;
	}
	cout << result;
}