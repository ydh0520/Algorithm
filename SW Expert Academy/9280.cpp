#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	int check[100];

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, m, temp;
		cin >> n >> m;

		vector<int> parking_area;
		vector<int> car;
		queue<int> wait;

		for (int i = 0; i < n; i++) {
			cin >> temp;
			parking_area.push_back(temp);
			check[i] = 0;
		}

		car.push_back(0);
		for (int i = 0; i < m; i++) {
			cin >> temp;
			car.push_back(temp);
		}

		int result = 0;

		for (int i = 0; i < 2 * m; i++) {
			cin >> temp;
			if (temp < 0) {
				temp = -temp;
				int index = 0;
				while (index < n) {
					if (check[index] == temp) {
						if (wait.empty()) {
							check[index] = 0;
						}
						else {
							check[index] = wait.front();
							wait.pop();
						}
						break;
					}
					index++;
				}
				result += parking_area[index] * car[temp];
			}
			else {
				int index = 0;
				while (index < n) {
					if (check[index] == 0) {
						check[index] = temp;
						break;
					}
					index++;
				}
				if (index == n) {
					wait.push(temp);
				}
			}
		}


		cout << '#' << test_case << ' ' << result << '\n';
	}
	return 0;
}