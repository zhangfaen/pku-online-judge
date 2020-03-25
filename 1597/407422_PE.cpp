#include<iostream>
#include<set>
#include<algorithm>
#include<stdio.h>
using namespace std;
int main()
{
 	int step,mod;
 	while(cin>>step>>mod)
 	{
		set<int> si;
		si.insert(0);
		int t=0;
		bool tag=false;
		while(si.size()<mod)
		{
			int s=(t+step)%mod;
			if(si.find(s)!=si.end())
			{	
				printf("%10d%10d     Bad Choice\n",step,mod);
				tag=true;
				break;
			}
			else
				si.insert(s);
			t=s;
			}
			if(tag==false)
			{
				printf("%10d%10d     Good Choice\n",step,mod);
			}
	}

}
