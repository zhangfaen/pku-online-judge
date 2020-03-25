#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
class C
{
	public: 
		char c;
	public:
	C(char t)
	{
		c=t;
	}

};
bool operator<(const C &s,const C &t)
{
	char a=s.c>='a'?s.c-32:s.c;
	char b=t.c>='a'?t.c-32:t.c;
	if(a<b)return true;
	if(a==b)
		return s.c<t.c;
	return false;
}

int main()
{
	int n;cin>>n;
	while(n--)
	{
		string s;cin>>s;
		vector<C>vc;
		vector<C>first;
		for(int i=0;i<s.size();i++)
		{
			vc.push_back(C(s[i]));
		}
		sort(vc.begin(),vc.end());
		first=vc;
		for(int i=0;i<vc.size();i++)
			cout<<vc[i].c;
		cout<<endl;
		while(true)
		{
			next_permutation(vc.begin(),vc.end());
			bool ok=false;
			for(int i=0;i<first.size();i++)
				if(first[i].c!=vc[i].c)ok=true;
			if(ok==false)break;
			for(int i=0;i<vc.size();i++)
				cout<<vc[i].c;
			cout<<endl;
		}
	}
}

