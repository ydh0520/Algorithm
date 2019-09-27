#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

#define DIV_NUMBER 42

using namespace std;

int counter[DIV_NUMBER];

int main() {
	int input, result = 0;

	for (int i = 0; i < 10; i++) {
		scanf("%d", &input);
		counter[input%DIV_NUMBER]++;
	}

	for (int i = 0; i < DIV_NUMBER; i++) {
		if (counter[i] != 0) {
			result++;
		}
	}

	printf("%d", result);
}