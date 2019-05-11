#include <iostream>
#include <string>
using namespace std;

int main(){
	int temp;
	string input;
	cin >> input;
	int check[26];

	for (int i = 0; i < 26; i++) {
		check[i] = -1;
	}

	for (int i = 0; i < input.length(); i++) {
		temp = (int)(input.at(i)-'a');
		if (check[temp] < 0)
			check[temp] = i;
	}
	for (int i = 0; i < 26; i++) {
		printf("%d ", check[i]);
	}
}