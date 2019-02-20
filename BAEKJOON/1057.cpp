//
// Created by YDH on 2019-02-20.
//

/*
 * 백준 알고리즘 1057 토너먼트
 * 시뮬레이션
 *
 * 해설 : 시뮬레이션, 토너먼트 가 진행될수록 자신의 번호가 절반으로 작아지는것을 이용 같아질때까지 반복한다.
 *        결승에는 무조건 만나므로 대결하지 않을수 없다.
 */

#include <iostream>

using namespace std;

int main(void) {
    int N,x,y,i;
    cin>>N>>x>>y;
    x-=1,y-=1;
    for(i=0;x!=y;i++){
        x/=2,y/=2;
    }
    cout<<i;
}