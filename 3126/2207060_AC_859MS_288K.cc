#include<iostream>
#include<vector>
#include<string>
#include<sstream>
#include<stdio.h>
#include<algorithm>
#include<math.h>
using namespace std;
const int INF=100000000;
vector<int> ps;
int _min(int a,int b)
{
	if(a<b)return a;return b;
}
void calcP()
{
	for(int i=1001;i<=9999;i+=2)
	{
		bool find=false;
		for(int j=2;j*j<=i;j++)
		{
			if(i%j==0)
			{
				find=true;
				break;
			}
		}
		if(find==false)
			ps.push_back(i);
	}
}
vector< vector<int> > map;
int main()
{

	calcP();
	int i,j,k;
	for(i=0;i<ps.size();i++)
		map.push_back(vector<int>());
	//cout<<ps.size()<<endl;
	char p[20],q[20];
	for(i=0;i<ps.size();i++)
		for(j=i+1;j<ps.size();j++)
		{
			sprintf(p,"%d",ps[i]);
			sprintf(q,"%d",ps[j]);
			
			int cnt=0;
			for(k=0;k<4;k++)
				if(p[k]!=q[k])
					cnt++;
			if(cnt==1)
			{
				map[i].push_back(j);
				map[j].push_back(i);
			}
		}
	int ts;
	cin>>ts;
	while(ts-->0)
	{
		int sn,tn;cin>>sn>>tn;
		int si,ti;
		for(i=0;i<ps.size();i++)
		{
			if(ps[i]==sn)
				si=i;
			if(ps[i]==tn) ti=i;
		}
		int * best=new int[ps.size()];
		bool * vst=new bool[ps.size()];
		for(i=0;i<ps.size();i++)
		{
			best[i]=INF;
			vst[i]=false;
		}
		best[si]=0;
		for(i=0;i<ps.size();i++)
		{
			int tmin=INF;
			int next=-1;
			for(j=0;j<ps.size();j++)
			{
				if(vst[j]==false&&best[j]<tmin)
				{
					tmin=best[j];
					next=j;
				}
			}
			if(next==ti||next==-1)break;
			vst[next]=true;
			for(j=0;j<map[next].size();j++)
			{
				int d=map[next][j];
				best[d]=_min(best[d],best[next]+1);
			}
		}
		if(best[ti]!=INF)
			cout<<best[ti]<<endl;
		else cout<<"Impossible"<<endl;
		delete [] best;
		delete [] vst;
	}
	return 0;
}