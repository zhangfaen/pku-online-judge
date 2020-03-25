#include<iostream>
using namespace std;
const int maxn=110;
const int maxint=100000000;
int map[maxn][maxn],link[maxn],lx[maxn],ly[maxn];
bool x[maxn],y[maxn];
int n,m;

int find(int v)
{
    int j,k;
    x[v]=1;
    for(j=1;j<=n;j++)
     if(y[j]==0&&lx[v]+ly[j]==map[v][j])
     {
        y[j]=1;
        k=link[j];link[j]=v;
        if(k==0||find(k))return 1;
        link[j]=k;
     }
    return 0;
}
int main()
{
//freopen("a.in","r",stdin);
//freopen("a.out","w",stdout);
int i,j,k,d,ans;
while(scanf("%d%d",&n,&m)==2)
{
   memset(map,0,sizeof(map));
   memset(link,0,sizeof(link));
   memset(lx,0,sizeof(lx));   memset(ly,0,sizeof(ly));
   while(m--){  scanf("%d%d%d",&i,&j,&k); map[i][j]=k;}
   for(i=1;i<=n;i++)
    for(j=1;j<=n;j++)
     if(map[i][j]>lx[i])lx[i]=map[i][j];
    
   for(k=1;k<=n;k++)
   do{
      memset(x,0,sizeof(x));memset(y,0,sizeof(y));
      if(find(k))break;
      d=maxint;
      for(i=1;i<=n;i++)
      if(x[i])
       for(j=1;j<=n;j++)
        if(!y[j]&&lx[i]+ly[j]-map[i][j]<d)
           d=lx[i]+ly[j]-map[i][j];
      for(i=1;i<=n;i++){if(x[i])lx[i]-=d;if(y[i])ly[i]+=d;}
   }while(1);
  
   for(ans=0,i=1;i<=n;i++)ans+=map[link[i]][i];
   printf("%d\n",ans);
}

return 0;
}