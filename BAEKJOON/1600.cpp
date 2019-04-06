#include <iostream>
#include <queue>


using namespace std;

struct location {
	int x;
	int y;
	int horsecount;
	int count;
};

bool input[201][201];
int check[201][201][31];


queue<location> monky;
int h, w, c;

int dx[12] = { 0, 1, 0, -1, -2, -1, 1, 2, 2, 1, -1, -2 };
int dy[12] = { -1, 0, 1, 0, -1, -2, -2, -1, 1, 2, 2, 1 };

bool next(location current) {
	int nextx, nexty,nexthorse;
	int limt = (current.horsecount > 0) ? 12 : 4;
	for (int i = 0; i < limt; i++) {
		nextx = current.x + dx[i];
		nexty = current.y + dy[i];
		nexthorse = current.horsecount - 1 > 0 ? current.horsecount - 1 : 0;
		if(i<4)
			nexthorse = current.horsecount;
		else
			nexthorse = current.horsecount - 1 > 0 ? current.horsecount - 1 : 0;
		if (nextx < 0 || nexty < 0 || nextx >= h || nexty >= w || input[nextx][nexty])continue;

		if (nextx == h - 1 && nexty == w - 1) {
			return true;
		}
		int nextcount = check[nextx][nexty][nexthorse];
		if (nextcount == 0) {
			check[nextx][nexty][nexthorse] = current.count + 1;
			location next{ nextx,nexty,nexthorse,current.count + 1 };
			monky.push(next);
		}

	}
	return false;
}
	
int main() {
	int result = -1, temp;
	scanf("%d", &c);
	scanf("%d %d", &w, &h);

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			scanf("%d", &input[i][j]);
		}
	}

	location initloc{ 0,0,c,0 };
	monky.push(initloc);

	while (!monky.empty()) {
		if (next(monky.front())) {
			result = monky.front().count + 1;
			break;
		}
		if (monky.size() > 10000000) {
			result = -1;
			break;
		}
		monky.pop();
	}

	cout << result;
}