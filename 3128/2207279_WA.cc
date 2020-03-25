#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stdio.h>
using namespace std;
int main(){
	freopen("c:\\in.txt","r",stdin);
	int ts;
	cin>>ts;
	while(ts-->0){
		int i;
		string s;
		cin>>s;
		bool vst[26];
		for(i=0;i<26;i++)
			vst[i]=false;
		vector<int> vi;
		for(i=0;i<26;i++)
		{
			if(vst[i])continue;
			vst[i]=true;
			int cur=i;
			int cnt=1;
			while(true)
			{
				char c=s[cur];
				int next=c-'A';
				if(vst[next])break;
				vst[next]=true;
				cnt++;
				cur=next;
			}
			vi.push_back(cnt);
		}
		sort(vi.begin(),vi.end());
		int p[26];
		for(i=0;i<26;i++)
			p[i]=0;
		for(i=0;i<vi.size();i++)
			p[vi[i]]++;
		bool ok=true;
		for(i=0;i<26;i++)
			if(i%2==0&&p[i]%2!=0)
				ok=false;
		if(ok)
			cout<<"Yes"<<endl;
		else cout<<"No"<<endl;
	}
	return 0;
}