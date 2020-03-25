
#include<iostream>
#include<cstdlib>
using namespace std;

int main()
{
	int n;
	int memo[220]={1,2,4,6};
	for(int i=4;i<220;i++)
		memo[i]=(memo[i-1]+memo[i-3]+memo[i-4])%2005;
	while(cin>>n)
	{
		n%=200;
		cout<<memo[n]<<endl;
	}
	
	return 0;

}
