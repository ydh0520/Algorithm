#include<iostream>

#include<vector>

 

using namespace std;

 

int main(int argc, char** argv)

{

	int test_case;

	int T;

 

	cin >> T;

 

	for (test_case = 1; test_case <= T; ++test_case)

	{

		int n, m,input;

		int result = -1;

		cin >> n >> m;

		vector<int> set;

 

		for (int i = 0; i < n; i++) {

			cin >> input;

			set.push_back(input);

		}

		

		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {

				int select = set[i] + set[j];

				if (select <= m && select > result) {

					result = select;

				}

			}

		}

 

		cout << '#' << test_case << ' ' << result << '\n';

	}

	return 0;

}