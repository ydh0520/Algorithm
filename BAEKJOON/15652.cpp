#include <iostream>

#define limit 8

using namespace std;

int n, m;
int selected[limit];

void select(int count,int start) {
	if (count == m) {
		
		for (int i = 0; i < m; i++) {
			printf("%d ", selected[i]+1);
		}
		printf("\n");
		return;
	}

	for (int i = start; i < n; i++) {
		selected[count] = i;
		select(count + 1, i);
	}
}

int main()
{
	scanf("%d %d", &n, &m);
	select(0,0);
}

