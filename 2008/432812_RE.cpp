#include<iostream>
#include<stdio.h>
using namespace std;
	int deep(int * a,int b)
	{
		int level=0;
		while(a[b]!=0)
		{
			level++;
			b=a[b];
			
		}
		return level;
	}
	int father(int * a,int b)
	{
		while(a[b]!=0)
			b=a[b];
		return b;
	}
	int main()
	{
		//freopen("c:\\in.txt","r",stdin);
		int T;scanf("%d",&T);
		while(T--!=0)
		{
			int N;scanf("%d",&N);
			int M;scanf("%d",&M);
			int * a=new int[N+1];
			for(int i=0;i<N+1;i++)
				a[i]=0;
			while(M--!=0)
			{
				char c;scanf("%c%c",&c,&c);
				int p;scanf("%d",&p);
				int q;scanf("%d",&q);
				if(p>q)
				{
					int t=p;p=q;q=t;
				}
				if(c=='A')
				{
					if(p==q)
						printf("In the same gang.\n");
					else
					if(a[p]==0&&a[q]==0)
					{
						printf("Not sure yet.\n");
					}
					else
					{
						
						int pd=deep(a,p);
						
						int qd=deep(a,q);
						
						int pf=father(a,p);
						int qf=father(a,q);
						if(pf!=qf)
							printf("Not sure yet.\n");
						else
							if((pd-qd)%2==0)
								printf("In the same gang.\n");
							else
								printf("In different gangs.\n");
					}
				}
				else
				{
					a[q]=p;
				}
			}
		}
		return 0;
	}

	
