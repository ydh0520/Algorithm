//
// Created by YDH on 2019-02-20.
//

/*
 * 백준 알고리즘 1094 막대기
 * 시뮬레이션
 *
 * 해설 : 시뮬레이션, 일일이 실행할 필요없이 이진법이라는것 파악하면 쉬움
 */

#include <iostream>

using namespace std;

int main(void) {
    int x,count=0;
    cin>>x;
    while(x>0){
        if(x%2==1)
            count++;
        x/=2;
    }
    cout<<count;
}