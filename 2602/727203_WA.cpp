#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{
	long n;
	cin>>n;
	char *c1=new char[n];
	char *c2=new char[n];
	memset(c1,0,sizeof(c1));
	memset(c2,0,sizeof(c2));
	for(int i=0;i<n;i++)
	{	
    	cin>>c1[i]>>c2[i];	
	}
	int jin=0;
	for(i=n-1;i>=0;i--)
	{
		int tsum=jin+c1[i]+c2[i]-2*'0';
		jin=0;
		if(tsum>=10)
			jin=tsum/10;
		c1[i]=tsum%10+'0';
		
	}
	printf("%s",c1);
	delete c1;
	delete c2;
	int aa;cin>>aa;
	return 0;
}