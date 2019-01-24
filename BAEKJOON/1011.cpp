//
// Created by YDH on 2019-01-24.
//

/*
 * 백준 알고리즘 1011 분수찾기
 * 규칙찾기
 *
 * 해설 : 규칙찾기 반복문그대로 실행할 경우 시간 초과
 *          따라서 제곱이과 제곱근을 사용하여 근저 합을 구하여 반복문을 줄임
 */

#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int T,x,y;
    cin>>T;

    for(int i=0;i<T;i++){
        cin>>x>>y;
        int dist=y-x;
        int counter=sqrt(dist);
        int total=counter*counter;
        if(total==dist)
            cout<<2*counter-1<<endl;
        else if(total+counter<dist)
            cout<<2*counter+1<<endl;
        else
            cout<<2*counter<<endl;

    }
}