#include<stdio.h>


#define MAX 50005
#define MAXINT 1000000
struct EDGE{
	int st,ed,val;
}edge[MAX];
int dis[MAX],n,min,max;
int bellman_ford()
{
	int i,k;
	for(i=min;i<=max;i++)
		dis[i]=MAXINT;
	dis[max]=0;
	bool over;
	for(k=0;k<=max-min;k++)
	{
		over=true;
		for(i=0;i<n;i++)
			if(dis[edge[i].st]!=MAXINT&&dis[edge[i].st]+edge[i].val<dis[edge[i].ed])
			{
				dis[edge[i].ed]=dis[edge[i].st]+edge[i].val;
				over=false;
			}
		for(i=max-1;i>=min;i--)
			if(dis[i+1]!=MAXINT&&dis[i+1]<dis[i])
			{
				dis[i]=dis[i+1];
				over=false;
			}
		for(i=min+1;i<=max;i++)
			if(dis[i-1]!=MAXINT&&dis[i-1]+1<dis[i])
			{
				dis[i]=dis[i-1]+1;
				over=false;
			}
		if(over)
			break;
	}
	return dis[min];
}

int main()
{

	int i;
	while(scanf("%d",&n)!=EOF)
	{
		min=MAXINT;
		max=0;
		for(i=max;i<n;i++)
		{
			scanf("%d%d%d",&edge[i].ed,&edge[i].st,&edge[i].val);
			edge[i].st++;
edge[i].val*=-1;
			if(edge[i].st>max)
				max=edge[i].st;
			if(edge[i].ed<min)
				min=edge[i].ed;
		}
		printf("%d\n",-bellman_ford());
	}
	return 0;
}