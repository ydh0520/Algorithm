#include <iostream>

using namespace std;

int main() {
	int e, s, m;
	cin >> e >> s >> m;
	s = (s == 28) ? 0 : s;
	m = (m == 19) ? 0 : m;

	while (true) {
		if (e % 28 == s&&e % 19 == m)
			break;
		e += 15;
	}

	cout << e;
}