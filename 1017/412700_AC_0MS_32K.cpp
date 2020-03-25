#include <iostream.h>
void main(){
	int nBox = 0, nSize[7], nEsc = 0, nRemain32, nRemain21;
	for(int i = 1; i <= 6; i++){
		cin >> nSize[i];
		if(nSize[i] > 0) nEsc ++;
	}
	while(nEsc !=0){
		nEsc = 0;
		nBox = 0;
		nBox += nSize[6] + nSize[5] + nSize[4];
		if(nSize[3] % 4 != 0){
			nBox += nSize[3] / 4 + 1;
			nRemain32 = (4 - nSize[3] % 4) * 2 - 1;
		}
		else{
		nBox += nSize[3] / 4;
		nRemain32 = 0;
		}
		if(nSize[2] > nSize[4] * 5 + nRemain32){
			int t = (nSize[2] - nSize[4] * 5 - nRemain32);
			nBox += (t % 9) ? (t / 9 + 1) : t / 9;
		}
		nRemain21 = (nBox - nSize[6]) * 36 - (nSize[5] * 25 + nSize[4] * 16 + nSize[3] * 9 + nSize[2] * 4);
		//cout<<nRemain21<<(nSize[1] - nRemain21)  <<endl;
		if(nSize[1] > nRemain21)
			nBox += ((nSize[1] - nRemain21) % 36) ?((nSize[1] - nRemain21) / 36 + 1) : (nSize[1] - nRemain21) / 36;
		cout << nBox << endl;
		for(int i = 1; i <= 6; i++){
			cin >> nSize[i];
			if(nSize[i] > 0) nEsc ++;
		}
	}
}
