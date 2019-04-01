#include <iostream>

using namespace std;

int inorder[100000];
int postorder[100000];

void preorder(int is, int ie, int ps, int pe) {
	if (is > ie)
		return;

	printf("%d ", postorder[pe]);

	int i = 0;
	while (inorder[is + i] != postorder[pe])
		i++;


	preorder(is,is+i-1,ps,ps+i-1);
	preorder(is+i+1,ie,ps+i,pe-1);


}

int main() {
	int n;
	scanf("%d", &n);
	for(int i=0;i<n;i++)
		scanf("%d", &inorder[i]);
	for (int i = 0; i < n; i++)
		scanf("%d", &postorder[i]);

	preorder(0, n-1,0,n-1);
}