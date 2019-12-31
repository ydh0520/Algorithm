#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{

		int N, K;
		int max = 0;
		cin >> N >> K;
		int input[10001] = { 0, };

		int temp;
		for (int i = 0; i < N; i++) {
			cin >> temp;
			input[temp]++;
		}

		for (int i = 0; i < 10001 - K; i++) {
			int counter = 0;
			for (int j = 0; j <= K; j++) {
				counter += input[i + j];
			}
			if (counter > max)
				max = counter;
		}
		cout << "#" << test_case << " " << max << '\n';
	}
	return 0;
}