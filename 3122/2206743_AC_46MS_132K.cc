#include<stdio.h>
const double PI=3.1415926535897932384626433832795;
int main()
{
	int ts=0;
	scanf("%d",&ts);
	while(ts-->0)
	{
		int n,f;
		scanf("%d%d",&n,&f);
		int * rddi=new int[n];
		for(int i=0;i<n;i++)
			scanf("%d",rddi+i);
		double left=0,right=1e15;
		while(right-left>1e-6)
		{
			double mid=(left+right)/2;
			int total=0;
			bool ok=false;
			for(int i=0;i<n;i++)
			{
				double v=PI*rddi[i]*rddi[i];
				total+=(int)(v/mid);
				if(total>=f+1)
				{
					ok=true;
					break;
				}
			}
			if(ok)
				left=mid;
			else right=mid;
		}
		printf("%.4lf\n",left);
		delete [] rddi;
	}
}
