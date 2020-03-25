#include <stdio.h>

int T, N;
int D[750000]={1,1,2};

int main (){
	int i;
	
	for (i=3; i<7500001; i++){
		D[i]=(D[i-1]*3-D[i-2])%100000;
		if (D[i]<0) D[i]+=100000;
	}
	scanf ( "%d", &T );
	
	for (i=0; i<T; i++){
		scanf ( "%d", &N );
		N%=7500001;
		printf ( "%d\n", D[N] );
	}
	
	return 0;
}


