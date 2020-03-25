#include<iostream>
using namespace std;
int p[1000];
int psize=0;
int memo[1200][15][500];
void calcPrime()
{
     p[psize++]=2;
     for(int i=3;i<=1121;i+=2)
	 {
		bool ok=true;
	   	for(int j=2;j*j<=i;j++) 				 				
		{
			if(i%j==0){
				ok=false;
				break;
			}
		}
		if(ok)
			p[psize++]=i;
	}
}
int dp(int left,int ck,int ci)
{
	if(ci==psize)
	{
		if(left==0&&ck==0)return 1;
		return 0;
	}
	if(ck==0&&left==0)
		return 1;
	if(ck==0&&left!=0)
		return 0;
		
	if(memo[left][ck][ci]!=-1)
		return memo[left][ck][ci];
	if(left<p[ci])return 0;
	int re=0;
	re+=dp(left-p[ci],ck-1,ci+1);
	re+=dp(left,ck,ci+1);
	memo[left][ck][ci]=re;
	return re;
}
int main()
{
	int n,k;
	calcPrime();
	while(true)
	{
		cin>>n>>k;
		if(n+k==0)break;
		for(int i=0;i<1200;i++)
			for(int j=0;j<15;j++)
				for(int k=0;k<500;k++)
					memo[i][j][k]=-1;
		int res=dp(n,k,0);
		cout<<res<<endl;
	}
	return 0;
}
