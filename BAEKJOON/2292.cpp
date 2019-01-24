//
// Created by YDH on 2019-01-24.
//

/*
 * 백준 알고리즘 2292 벌집문제
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
        range+=i*6;
        i++;
    }
    cout<<i;
}