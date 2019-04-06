#include <iostream>
#include <queue>


using namespace std;

int input[1001][1001];
queue<pair<int, int>> tomato;
int n, m;

int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,1,0,-1 };

int check() {
	int max = 0;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			switch (input[i][j])
			{
			case 0:
				return -1;
			case -1:
				break;
			default:
				if (input[i][j] > max) {
					max = input[i][j];
				}
			}
		}
	}
	return max-1;
}

void next(int x, int y) {
	for (int i = 0; i < 4; i++) {
		int nextx = x + dx[i];
		int nexty = y + dy[i];
		if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n) continue;

		switch (input[nextx][nexty])
		{
		case 0:
			tomato.push(pair<int, int>(nextx, nexty));
			input[nextx][nexty] = input[x][y] + 1;
			break;
		case -1:
			break;
		default:
			if (input[nextx][nexty] > input[x][y] + 1)
				input[nextx][nexty] = input[x][y] + 1;
		}


	}
}

int main() {
	scanf("%d %d\n", &n, &m);

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &input[i][j]);
			if (input[i][j] == 1) {
				tomato.push(pair<int, int>(i, j));
			}
		}
	}

	while (!tomato.empty()) {
		next(tomato.front().first, tomato.front().second);
		tomato.pop();
	}

	cout << check();
}