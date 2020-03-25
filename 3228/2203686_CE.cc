#include<stdio.h>
#include<algorithm>
#include<vector>
#include<stdlib.h>
using namespace std;
int *p,*v;
class Endge
{
public:
	int x,y,len;
	Endge(int a,int b,int c)
	{
		x=a;y=b;len=c;
	}
	Endge(){}
};
bool operator<(Endge &a,Endge&b)
{
	return a.len<b.len;
}

int _find(int x)
{
	if(p[x]==x)
		return x;
	int root=_find(p[x]);
	p[x]=root;
	return root;
}
void _union(int x,int y)
{
	int fx=_find(x);
	int fy=_find(y);
	if(fx==fy)return;
	p[fy]=fx;
	v[fx]+=v[fy];
}
bool check(int n)
{
	for(int i=0;i<n;i++)
		if(p[i]==i&&v[i]>0)return false;
	return true;
}
int main()
{
	freopen("c:\\in.txt","r",stdin);
	int n,m,i,j;
	int * store,* gold;
	while(scanf("%d",&n)&&n!=0)
	{
		store=new int[n];
		gold=new int[n];
		p=new int[n];
		v=new int[n];
		for(i=0;i<n;i++)
			p[i]=i;
	
		for(i=0;i<n;i++)
			scanf("%d",gold+i);
		for(i=0;i<n;i++)
			scanf("%d",store+i);
		scanf("%d",&m);
		vector<Endge> es;
		for(i=0;i<m;i++)
		{
			int x,y,len;
			scanf("%d%d%d",&x,&y,&len);
			es.push_back(Endge(x-1,y-1,len));
		}
		sort(es.begin(),es.end());
		for(i=0;i<n;i++)
			v[i]=(gold[i]-store[i]);
		bool find=false;
		if(check(n))
		{
			find=true;
			printf("0\n");
		}
		else
		for(i=0;i<m;i++)
		{
			
			_union(es[i].x,es[i].y);
			if(check(n))
			{
				find=true;
				printf("%d\n",es[i].len);
				break;
			}
		}
		if(find==false)
			printf("No Solution");	
		delete [] p;
		delete [] v;
		delete [] store;
		delete [] gold;
	}
	return 0;
}
