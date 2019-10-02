#include <iostream>
#include <stack>

using namespace std;
int sadari[31][12];
int n, m, h;

bool check() {
	int result[12] = { 0,1,2,3,4,5,6,7,8,9,10,11 };
	for (int i = 1; i <= h; i++) {
		for (int j = 1; j < n; j++) {
			if (sadari[i][j]==1) {
				int temp = result[j];
				result[j] = result[j + 1];
				result[j + 1] = temp;
			}
		}
	}
	for (int i = 0; i <= n; i++) {
		if (result[i] != i)
			return false;
	}
	return true;
}

bool select(int count,int starti,int startj) {
	if (count == 0)
		return check();

	for (int i = starti; i <= h; i++) {
		for (int j = i==starti?startj:0; j < n; j++) {
			if (sadari[i][j] == 0) {
				int temp[3] = { sadari[i][j-1],sadari[i][j] ,sadari[i][j+1] };
				sadari[i][j] = 1;
				sadari[i][j-1] = -1;
				sadari[i][j+1] = -1;
				if (select(count - 1, i, j))
					return true;
				sadari[i][j-1] = temp[0];
				sadari[i][j] = temp[1];
				sadari[i][j + 1] = temp[2];
			}
		}
	}
	return false;
}

int find() {
	for (int i = 0; i < 4; i++) {
		if (select(i,1,1))
			return i;
	}
	return -1;
}

int main() {
	cin >> n >> m >> h;
	int temp1, temp2;
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &temp1, &temp2);
		sadari[temp1][temp2] = 1;
		sadari[temp1][temp2-1] = -1;
		sadari[temp1][temp2+1] = -1;
	}

	cout << find();
}