#include<iostream>
#include<stdio.h>
using namespace std;
 void mul(int *a,int n,int m)
	{
		for(int i=m;i>=n;i--)
		{
			a[i]=a[i-n]+a[i];
		}
	}
	 int main() 
	{
		//freopen("c:\\in.txt","r",stdin);

		while(true)
		{
			int n,m;
			int i,j;
			cin>>n>>m;
			if(n==0)break;
			int *a=new int[m+1];
			memset(a,0,sizeof(a));
			a[0]=1;
			int *b=new int[n];
			for(i=0;i<n;i++)
				cin>>b[i];
			for(i=0;i<n;i++)
			{
				int t;
				cin>>t;
				for(j=0;j<t;j++)
					mul(a,b[i],m);
			}
			int sum=0;
			for(i=1;i<=m;i++)
				if(a[i]>0)
					sum++;
			cout<<sum;
			
		}
		//system("pause");

		
	}



