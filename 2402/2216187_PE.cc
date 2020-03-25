#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
int pow(int d)
{
	int re=1;
	while(d-->0)re*=10;
	return re;
}
int get(int ds,int rank)
{
	int re=1;
	ds--;
	while(ds-->0)
		re*=10;
	re+=rank-1;
	return re;
}
int main()
{
	int memo[30];
	memo[1]=9;
	memo[2]=9;
	for(int i=3;i<30;i++)
	{
		if(i%2==1)
		{
			memo[i]=10*9*pow(i/2-1);
		}
		else
		{
			memo[i]=9*pow(i/2-1);
		}
	}
	int n;
	while(true)
	{
		scanf("%d",&n);
		if(n==0)break;
		if(n<10)
		{
			printf("%d",n);
			continue;
		}
		if(n<19)
		{
			n-=9;
			printf("%d%d",n,n);
			continue;
		}
		int cur=1;
		while(n>memo[cur])
			n-=memo[cur++];
		char buff[20];
		if(cur%2==1)
		{
			n--;
			int mid=(int)(n%10);
			int half=9*pow(cur/2-1);
			n/=10;
			n++;
			int left=get(cur/2,n);
			printf("%d%d",left,mid);
			sprintf(buff,"%d",left);
			string s(buff);
			reverse(s.begin(),s.end());
			printf("%s",s.c_str());
		}
		else
		{
			int left=get(cur/2,n);
			printf("%d",left);
			sprintf(buff,"%d",left);
			string s(buff);
			reverse(s.begin(),s.end());
			printf("%s",s.c_str());
		}
	}
	return 0;
}