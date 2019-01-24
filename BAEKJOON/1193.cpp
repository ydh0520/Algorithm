//
// Created by YDH on 2019-01-24.
//

/*
 * 백준 알고리즘 1193 분수찾기
 * 규칙찾기
 *
 * 해설 : 등차수열
 */

#include <iostream>

using namespace std;

int main() {
    int N;
    cin>>N;
    int i=1,range=1;
    while(N>range){
        i++;
        range+=i;
    }
    range=range-N;
    if(i%2==0)
        cout<<i-range<<"/"<<range+1<<endl;
    else
        cout<<range+1<<"/"<<i-range<<endl;
}