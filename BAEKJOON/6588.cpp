#include <iostream>
#include <vector>

using namespace std;
bool check[1000001];
vector<int> sosu;
int min_i = 0, min_j = 0,tempelse;

bool find(int temp) {

	for (int i = 0; i < sosu.size(); i++) {
		if (sosu[i] > temp)
			return false;
		tempelse = temp - sosu[i];
		if (tempelse < i)
			return false;
		if (!check[temp - sosu[i]]) {
			min_i = i;
			min_j = temp - sosu[i];
			return true;
		}
	}
	return false;

}

int main() {
	check[0] =check[1]= true;

	int temp;
	scanf("%d", &temp);
	while (temp != 0) {
		if (find(temp))
			printf("%d = %d + %d\n", temp, sosu[min_i], min_j);
		else
			printf("Goldbach's conjecture is wrong.\n");
		scanf("%d", &temp);
	}

}