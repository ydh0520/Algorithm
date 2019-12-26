#include<iostream>
#include<queue>
#include<string>

#define MAX_DEFAULT -1000000000
#define MIN_DEFAULT 1000000000

using namespace std;
int input[11];
int oper[4];
int N;
int max_value = MAX_DEFAULT, min_value=MIN_DEFAULT;

int cal(int num1, int num2, int op) {
	int result;
	switch (op)
	{
	case 0:
		result = num1 + num2;
		break;
	case 1:
		result = num1 - num2;
		break;
	case 2:
		result = num1 * num2;
		break;
	case 3:
		result = num1 / num2;
		break;
	}
	return result;
}

void calR(int counter,int result) {
	if (counter < N) {
		for (int i = 0; i < 4; i++) {
			if (oper[i] != 0) {
				oper[i]--;
				calR(counter + 1, cal(result,input[counter],i));
				oper[i]++;
			}
		}
	} else {
		if (result < min_value)
			min_value = result;
		if (result > max_value)
			max_value = result;
	}
}

int main(int argc, char** argv)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> input[i];
	}

	for (int i = 0; i < 4; i++) {
		cin>>oper[i];
	}

	calR(1, input[0]);

	cout << max_value << '\n' << min_value;
	return 0;
}