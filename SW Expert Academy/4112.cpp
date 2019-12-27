#include<iostream>
#include<vector>

#define INPUT_LIMIT 10000

using namespace std;

vector<int> sum_set;

int cal_sum(int n) {
	return n*(n + 1) / 2;
}

void make_sum_set() {
	int index = 0;
	int sum = cal_sum(0);
	while (sum < INPUT_LIMIT) {
		sum = cal_sum(index);
		sum_set.push_back(sum);
		index++;
	}

}

pair<int, int> convert_num(int num) {
	int level = 0;
	while (num > sum_set[level]) {
		level ++;
	}
	return{ level,num - sum_set[level - 1] };
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	int top,bottom;

	cin >> T;
	make_sum_set();
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> top >> bottom;

		if (top > bottom) {
			int temp = top;
			top = bottom;
			bottom = temp;
		}


		pair<int, int> converted_top = convert_num(top);
		pair<int, int> converted_bottom = convert_num(bottom);

		int level_diff = converted_bottom.first - converted_top.first;
		
		int offset_diff;
		
		if (converted_bottom.second < converted_top.second) {
			//offset_diff = converted_bottom.first - converted_bottom.second - converted_top.first + converted_top.second;
			offset_diff = level_diff - converted_bottom.second + converted_top.second;
		}
		else {
			offset_diff = converted_bottom.second - converted_top.second;
		}

		int result;
		if (level_diff > offset_diff)
			result =  level_diff;
		else
			result = offset_diff;
		
        cout<<"#"<<test_case<<" "<<result<<'\n';
	}
	return 0;
}