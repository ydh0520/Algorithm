#include <iostream>
#include <algorithm>

#define limit 8

using namespace std;

int n, m;
int input[limit];
int selected[limit];


void select(int count,int start) {
	if (count == m) {
		
		for (int i = 0; i < m; i++) {
			printf("%d ", selected[i]);
		}
		printf("\n");
		return;
	}

	for (int i = start; i < n; i++) {

		selected[count] = input[i];
		select(count + 1,i+1);

	}
}

int main()
{
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &input[i]);
	}
	sort(input, input + n);
	select(0,0);
}

