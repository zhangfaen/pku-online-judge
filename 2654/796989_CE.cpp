#include<iostream>
#include<string>
#include<stdio.h>
using namespace std;
int f(char m,char n)
	{
		if(m=='p')
		{
			if(n=='s')
				return -1;
			if(n=='r')
				return 1;
			if(n=='p')
				return 0;
		}
		else
		if(m=='s')
		{
			if(n=='s')
				return 0;
			if(n=='r')
				return -1;
			if(n=='p')
				return 1;
		}
		else
		{
			if(n=='s')
				return 1;
			if(n=='r')
				return 0;
			if(n=='p')
				return -1;
		}
		return -2;
	}


	int main() 
	{
		while(true)
		{

			int num;
			cin>>num;
			if(num==0)
				break;
			int k;
			cin>>k;
			int * win=new int[num+1];
			int * lost=new int[num+1];
			for(int i=0;i<=num;i++)
			   win[i]=lost[i]=0;
			for(int i=0;i<k;i++)
			{
				int m;
				int n;
				string cm;
				string cn;
				cin>>m>>cm>>n>>cn;
				int r=f(cm[0],cn[0]);
				if(r==1)
				{
					win[m]++;
					lost[n]++;
				}
				else
				if(r==-1)
				{
					win[n]++;
					lost[m]++;
				}
			}
			for(int i=1;i<=num;i++)
			{
				if(win[i]+lost[i]>0)
					printf("%.3f\n",(win[i]/(win[i]+lost[i]+0.0)));
				else
					printf("-\n");
			}
			printf("\n");
		}
	}
