#include<iostream>

using namespace std;

int refer[10000001];

int min(int a, int b) {
	if (a < b)
		return a;
	else
		return b;
}

int main(int argc, char** argv)
{
	int input;
	cin >> input;
	
	for (int i = 2; i <= input; i++) {
		refer[i] = refer[i - 1] + 1;
		if (i % 2 == 0)
			refer[i] = min(refer[i], refer[i / 2] + 1);
		if (i % 3 == 0)
			refer[i] = min(refer[i], refer[i / 3] + 1);
	}

	cout << refer[input];
	return 0;
}