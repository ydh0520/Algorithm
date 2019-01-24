//
// Created by YDH on 2019-01-24.
//

/*
 * 백준 알고리즘 2775 부녀회장이 될거야
 * 규칙찾기
 *
 * 해설 : 규칙에 따라 미리 값을 배열에 저장하여 해당하는 값을 출력
 *        주어진 크기만큼만 계산한다면 더빠른 시간 안에 가능 하다.
 */

#include <iostream>

using namespace std;

int main() {
    int T,k,n;
    int result[15][15];
    for(int i=0;i<15;i++){
        result[0][i]=i;
        result[i][0]=0;
    }

    for(int i=1;i<15;i++){
        for(int j=1;j<15;j++){
            result[i][j]=result[i-1][j]+result[i][j-1];
        }
    }

    cin>>T;
    for(int i=0;i<T;i++){
        cin>>k>>n;
        cout<<result[k][n]<<endl;
    }
}
