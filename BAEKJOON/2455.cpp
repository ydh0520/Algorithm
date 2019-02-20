//
// Created by YDH on 2019-02-20.
//

/*
 * 백준 알고리즘 2455 지능형 기차
 * 시뮬레이션
 *
 * 해설 : 시뮬레이션
 */

#include <iostream>

using namespace std;

int main(void) {
    int in,out,count=0,max=0;
    for(int i=0;i<4;i++){
        cin>>out>>in;
        count=count+in-out;
        if(max<count)
            max=count;
    }
    cout<<max;
}