//
// Created by YDH on 2019-01-23.
//

/*
 * 카카오 코드페스티벌 2018 예선
 * 인형들
 * 문제 https://www.acmicpc.net/problem/15954
 */

#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int N,K;
    long double m,result,min=1000000;
    cin>>N>>K;

    int like[N];

    for(int i=0;i<N;i++)
        cin>>like[i];

    for(int i=K;i<=N;i++){
        for(int j=0;j<=N-i;j++){
            m=0,result=0;
            for(int k=0;k<i;k++){
                m+=like[k+j];
            }
            m/=i;
            for(int k=0;k<i;k++){
                result+=pow(like[k+j]-m,2);
            }
            result/=i;
            if(result<min){
                min=result;
            }
        }
    }
    cout.precision(12);
    cout<<sqrt(min)<<endl;
}