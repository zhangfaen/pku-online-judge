#include<stdio.h>

	int minc(int a,int b)
	{
		if(a<b)
			return a;
		return b;
	}
	int main()  
	{
		//freopen("c:\\in.txt","r",stdin);
		while(true){
			int n1,n2,n;
			int t;
			int i,j;
			scanf("%d%d%d%d",&n1,&n2,&n,&t);
			if(n1+n2+n == 0)
				break;
			int max[11];
			int min[11];
			int index1 = 0;
			int index2 = 0;
			__int64 sum = t;
			max[index1++] = t;
			min[index2++] = t;
			for(i = 1; i < n; i++){
				scanf("%d",&t);
				bool flag = false;
				for(j = index1 - 1; j >= 0; j--){
					if(max[j] >= t){
						max[j + 1] = t;
						flag = true;
						break;
					}
					else{
						max[j + 1] = max[j];
					}
				}
				if(!flag){
					max[0] = t;
				}
				index1 = minc(index1 + 1, n1);
				flag = false;
				for(j = index2 - 1; j >= 0; j--){
					if(min[j] <= t){
						min[j + 1] = t;
						flag = true;
						break;
					}
					else{
						min[j + 1] = min[j];
					}
				}
				if(!flag){
					min[0] = t;
				}
				index2 = minc(index2 + 1, n2);
				sum += t;
			}
			for(i = 0; i < n1; i++){
				sum -= max[i];
			}
			for(i = 0; i < n2; i++){
				sum -= min[i];
			}
			
			printf("%.6lf\n", 1.0 * sum / (n - n1 - n2));
		}
		return 0;
	}
	


