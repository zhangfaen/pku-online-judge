#include<vector>
#include<iostream>
#include<stdio.h>
#include<stdlib.h>
using namespace std;
class Job
{
public:
	int index, prior;
	Job(int a,int b)
	{
		index=a;prior=b;
	}
};
int main()
{
//	freopen("c\\in.txt","r",stdin);
	int ts;
	cin>>ts;
	while(ts-->0)
	{
		int n,m;
		cin>>n>>m;
		vector<Job> vj;
		for(int i=0;i<n;i++)
		{
			int prior;cin>>prior;
			vj.push_back(Job(i,prior));
		}
		int cur=0;
		while(true)
		{
			Job cj=vj[0];
			vj.erase(vj.begin());
			bool find=false;
			for(int i=0;i<vj.size();i++)
				if(vj[i].prior>cj.prior)
				{
					find=true;
					break;
				}
			if(find)
				vj.push_back(cj);
			else if(cj.index==m)
			{
				cur++;
				break;
			}
			else
			{
				cur++;
			}
		
		}
		cout<<cur<<endl;

	}
	return 0;
}