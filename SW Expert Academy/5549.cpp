
#include<string>
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		string input;
		cin >> input;

		if (input.at(input.size() - 1) % 2 == 0) {
			cout << "#" << test_case << " Even\n";
		}
		else {
			cout << "#" << test_case << " Odd\n";

		}
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}