//
// Created by YDH on 2019-01-25.
//

/*
 * 백준 알고리즘 1475 방 번호
 * 규칙찾기
 *
 * 해설 : 규칙찾기 카운트를 위해 횟수를 저장하는 배열을 사용
 *        0에대한 예외 추가
 */

#include <iostream>
using namespace std;

int main(void) {
    int N;
    int counter[10]={0,};
    cin>>N;
    if(N==0)
        counter[0]++;
    while(N>0){
        counter[N%10]++;
        N/=10;
    }
    counter[6]=counter[6]+counter[9];
    counter[6]=counter[6]%2==0?counter[6]/2:counter[6]/2+1;
    int max=0;
    for(int i =0;i<9;i++){
        if(counter[i]>max)
            max=counter[i];
    }

    cout<<max<<endl;
}