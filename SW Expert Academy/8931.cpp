#include<iostream>

#include<stack>

 

using namespace std;

 

int main(int argc, char** argv)

{

	int test_case;

	int T;

 

	cin >> T;

 

	for (test_case = 1; test_case <= T; ++test_case)

	{

		int k,input;

		int result = 0;

		stack<int> set;

		cin >> k;

 

		for (int i = 0; i < k; i++) {

			cin >> input;

			if (input != 0)

				set.push(input);

			else

				set.pop();

		}

 

		while (!set.empty())

		{

			result += set.top();

			set.pop();

		}

 

		cout << '#' << test_case << ' ' << result << '\n';

	}

	return 0;

}