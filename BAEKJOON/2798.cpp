#include <iostream>

using namespace std;

int input[100];
int N, M, maxValue;

void select(int start,int sum,int count) {
	if (count == 3) {
		if (sum <= M) {
			if (maxValue < sum) {
				maxValue = sum;
			}
			if (maxValue == M)
				return;
		}
	} else {
		for (int i = start; i < N; i++) {
			select(i+1, sum + input[i], count + 1);
		}
	}
	
}

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++) {
		scanf("%d", &input[i]);
	}

	maxValue = 0;
	select(0, 0, 0);

	printf("%d\n", maxValue);
}