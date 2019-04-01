#include <iostream>

using namespace std;

void solve(int n,int x,int y) {
	if (n == 0)
		return;
	int next = 6 - x - y;
	solve(n - 1, x, next);
	printf("%d %d\n", x, y);
	solve(n - 1, next, y);
}

int main() {
	int n;
	cin >> n;
	int counter = 1;
	for (int i = 0; i < n; i++)
		counter *= 2;
	printf("%d\n", counter - 1);
	solve(n, 1, 3);
}
