#include<iostream>
using namespace std;
int main()
{
	long n;
	cin>>n;
	char c1[n];
	char c2[n];
	for(int i=0;i<n;i++)
	{	
    	cin>>c1[i]>>c2[i];	
	}
	int jin=0;
	for(int i=n-1;i>=0;i--)
	{
		int tsum=jin+c1[i]+c2[i]-2*'0';
		if(tsum>=10)
			jin=tsum/10;
		c1[i]=tsum%10+'0';
		
	}
	printf("%s",c1);
	int aa;cin>>aa;
	return 0;
}