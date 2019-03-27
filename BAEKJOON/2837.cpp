#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	int r, c;
	bool right = true;
	cin >> r >> c;
	int black_x, black_y,temp;
	string L = "", R = "";
	string case1 = "DRUR",case2="RURD";

	for (int i = 1; i < c; i++) {
		L += "L";
		R += "R";
	}

	if (r % 2 == 0 && c % 2 == 0) {
		int min = 1001, temp, min_r=0, min_c=1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cin >> temp;
				if (temp < min&&(i+j)%2==1){
					min = temp;
					min_r = i;
					min_c = j;
				}
			}
		}

		for (int i = 0; i < r; i++) {
			if (i / 2 != min_r / 2) {
				cout << (right ? R : L);
				right = !right;
			} else {
				bool check = true;
				for (int j = 0; j < c; j+=2) {
					if (j / 2 == min_c / 2) {
						if (min_c % 2 == 0) {
							cout << 'R' << 'D';
						}else {
							cout << 'D' << 'R';
						}
						check = !check;
					}
					else {
						cout << (check ? case1 : case2);
					}
				}
				right = false;
				i++;
			}

			if (i != r - 1) {
				cout << 'D';
			}
		}
	}
	else {
		if (r % 2 == 0) {
			for (int i = 2; i < r; i++) {
				cout << (right ? R : L);
				right = !right;
				cout << 'D';
			}
			c /= 2;
			for (int i = 0; i < c; i++)
				cout << case1;
			cout << 'D';
		}
		else {
			for (int i = 0; i < r; i++) {
				cout << (right ? R : L);
				right = !right;
				if(i!=r-1)
					cout << 'D';
			}
		}
	}
}