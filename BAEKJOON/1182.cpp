#include<iostream>
#include<queue>
#include<string>

using namespace std;
int input[20];
int match_counter = 0;
int N,S;

void solve(int index, int pre_result) {
	if (index < N) {
		solve(index + 1, pre_result);
		solve(index + 1, pre_result+input[index]);
	}
	else {
		if (pre_result == S) {
			match_counter++;
		}
	}
}

int main(int argc, char** argv)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	cin >> N >> S;
	for (int i = 0; i < N; i++) {
		cin >> input[i];
	}

	solve(0, 0);
	if (S == 0)
		match_counter -= 1;
	cout << match_counter;
	return 0;
}