#include<iostream>
using namespace std;
int num[10000000];
int main()
{
	int i,two,three,t1,t2,n;
	two=three=0;
	num[0]=1;
	for(i=1;i<10000000;i++)
	{
		t1=2*num[two]+1;
		t2=3*num[three]+1;
		if(t1<t2)
		{
			num[i]=t1;
			two++;
		}
		else if(t1>t2)
		{
			num[i]=t2;
			three++;
		}
		else
		{
			num[i]=t1;
			three++;
			two++;
		}
	}
	while(cin>>n)
		cout<<num[n-1]<<endl;
	return 0;
}
