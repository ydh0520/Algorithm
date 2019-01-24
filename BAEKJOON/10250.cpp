//
// Created by YDH on 2019-01-24.
//
/*
 * 백준 알고리즘 10250 ACM호텔
 * 규칙찾기
 *
 * 해설 : 규칙찾기 특별 케이스에 대비하여 두가지 이상의 예시를 테스트 해볼것
 *        구간이 반복될경우 나누기와 나머지를 활용
 */

#include <iostream>

using namespace std;

int main() {
    int T,H,W,N;
    cin>>T;
    for(int i=0;i<T;i++) {
        cin >> H >> W >>N;
        if(N%H==0)
            printf("%d%02d\n",  H,N/H);
        else
            printf("%d%02d\n",  N % H,N/H+1);
    }
}

