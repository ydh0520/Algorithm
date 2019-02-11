//
// Created by YDH on 2019-02-11.
//

/*
 * 백준 알고리즘 6064 카잉달력
 * 규칙찾기
 *
 * 해설 : 규칙찾기, 최소공배수와 최대공약수를 구하고 해당 조건 안에서 반복하여 결과를 찾아냄
 */

#include <iostream>

using namespace std;

int GCD(int x,int y);
int LCM(int x,int y);

int main(void) {
    int T;
    cin>>T;
    for(int i=0;i<T;i++){
        int M,N,x,y;
        cin>>M>>N>>x>>y;
        int max=LCM(M,N);
        int year=x;
        while(year<max){
            if(((year%N==0)?N:year%N)==y){
                break;
            }
            year+=M;
        }

        if(year<max)
            cout<<year<<endl;
        else
            cout<<-1<<endl;
    }
}

int GCD(int x,int y){
    int c;
    while(y!=0){
        c=x%y;
        x=y;
        y=c;
    }
    return x;
}
int LCM(int x,int y){
    return x*y/GCD(x,y);
}