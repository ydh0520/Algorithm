#include <iostream>

using namespace std;
int maxvalue = -40000000000;
int minvalue = 40000000000;

int input[11];
int oper[4] = { 0,0,0,0 };
int n;

void cal(int counter,int pre) {
	if (counter == n) {
		if (pre > maxvalue) {
			maxvalue = pre;
		}
		if (pre < minvalue) {
			minvalue = pre;
		}
	}
	for (int i = 0; i < 4; i++) {
		if (oper[i] == 0)continue;
		oper[i]--;
		switch (i){
		case 0:
			cal(counter + 1,pre+input[counter] );
			break;
		case 1:
			cal(counter + 1, pre - input[counter]);
			break;
		case 2:
			cal(counter + 1, pre * input[counter]);
			break;
		case 3:
			cal(counter + 1, pre / input[counter]);
			break;
		}
		oper[i]++;
	}
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> input[i];
	}

	for (int i = 0; i < 4; i++) {
		cin >> oper[i];
	}

	cal(1, input[0]);

	printf("%d\n%d", maxvalue, minvalue);
}