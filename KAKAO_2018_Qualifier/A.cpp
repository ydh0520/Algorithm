//
// Created by YDH on 2019-01-22.
//

/*
 * 카카오 코드페스티벌 2018 예선
 * 상금 헌터
 * 문제 https://www.acmicpc.net/problem/15953
 */

#include <iostream>

using namespace std;

int main() {
    //reward data
    int reward17[21]={500,300,300,200,200,200,50,50,50,50,30,30,30,30,30,10,10,10,10,10,10};
    int reward18[31]={512,256,256,128,128,128,128,64,64,64,64,64,64,64,64,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32};

    int T,a,b;
    cin>>T;

    for(int i=0;i<T;i++){
        cin>>a>>b;
        int result=0;
        if(a<22&&a!=0){
            result+=reward17[a-1];
        }
        if(b<32&&b!=0){
            result+=reward18[b-1];
        }
        cout<<result*10000<<endl;
    }
}

/*
 * 수식을 통해 등수를 순위로 바꿀수 있으나 연산시간이 오래걸릴것으로 판단.
 */