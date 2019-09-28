#include <iostream>

using namespace std;

int n,minvalue=400000000;
int input[20][20];
bool man[20];


void calmin() {
	int start = 0, link = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (man[i] == man[j])
				if (man[i])
					start += input[i][j];
				else
					link += input[i][j];
		}
	}
	int result = (start - link) > 0 ? start - link : link - start;
	if (result < minvalue)
		minvalue = result;
}

int check(int count,int pre) {
	int temp;

	if (count == 0) {
		calmin();
	}

	for (int i = pre+1; i < n; i++) {
		man[i] = true;
		temp=check(count - 1, i);
		man[i] = false;
	}

}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &input[i][j]);
		}
	}

	for (int i = 0; i < n; i++) {
		man[i] = true;
		check(n / 2 - 1, i);
		man[i] = false;
	}

	cout << minvalue;
}