#include<iostream>
#include<queue>
#include<string>

using namespace std;
int set[20];

int main(int argc, char** argv)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string commend;
	int parameter;
	int M;
	cin >> M;
	for (int commend_num = 0; commend_num < M; commend_num++) {
		cin >> commend;
		if (commend == "all") {
			for (int i = 0; i < 20; i++) {
				set[i] = 1;
			}
		}
		else if (commend == "empty") {
			for (int i = 0; i < 20; i++) {
				set[i] = 0;
			}
		} else {
			cin >> parameter;
			if (commend == "add") {
				set[parameter - 1] = 1;
			}else if (commend == "remove") {
				set[parameter - 1] = 0;
			}else if (commend == "check") {
				cout<<set[parameter - 1]<<'\n';
			}else if (commend == "toggle") {
				set[parameter - 1] = !set[parameter - 1];
			}
		}

	}
	
	return 0;
}