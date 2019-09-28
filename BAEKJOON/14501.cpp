#include <iostream>

using namespace std;

pair<int, int> input[14];
int maxValue = 0;
int n;

void cal(int day, int value) {
	if (day > n ) {
		return;
	}

	if (maxValue < value)
		maxValue = value;

	if (day < n) {
		cal(day + input[day].first, value + input[day].second);
		cal(day + 1, value);
	}
}


int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d %d", &input[i].first, &input[i].second);
	
	cal(0, 0);

	printf("%d",maxValue);
}