#include <iostream>
#include <vector>

using namespace std;

int n, m;
int selected[7];

void select(int count) {
	if (count == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", selected[i] + 1);
		}
		printf("\n");
		return;
	}

	for (int i = 0; i < n; i++) {
		selected[count] = i;
		select(count + 1);
	}

}

int main()
{
	scanf("%d %d", &n, &m);
	select(0);
}

