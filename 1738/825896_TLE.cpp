#include <cstdio>
#include <iostream>
using namespace std;

const int size = 64000;
int w[size]; /* node weights */
int l[size],r[size]; /* left and right children */
//辅助数组，仅仅为了列印方便 
int d[size]; /* depth */
int q[size]; /* working region */
int v[size]; /* number of node in working region */
//辅助数组，仅仅为了列印方便
int t; /* current size of working region */
//标记当前未处理的节点个数 
int m; /* current node */


int ans;
void combine(int t);
void mark(int k, int p);
void build(int b);
int main()
{
    int i, j, k, n;
    for(; ;)
    {
        scanf("%d", &n);
        if(!n) break;
        --n;
           
        for(j = 0; j <= n; j++)
        {
            scanf("%d", &w[j]);
            l[j] = r[j] = -1;
        }
        if(!n)
        {
            printf("0\n");
            continue;
        } 
        m=n;
        t=1;
        ans = 0;
        q[0]=1000000000; /* infinity */
        q[1]=w[0]; v[1]=0;
        for(k=1;k<=n;k++) 
        {
            while(q[t-1] <= w[k]) //从左往右扫描，第一次遇到a, b, c且a > b, c > a，则将a, b合并 
            combine(t);
            t++; 
            q[t]=w[k]; 
            v[t]=k;
           // for (j=1;j<=t;j++) printf("%d ",q[j]); printf("\n");
        }
        while(t > 1) 
           combine(t);
        cout << ans << endl;
       /* mark(v[1],0);
        t=0; m=2*n;
        build(1);*/
    }    
}    

void combine(int k)
{
  int j,d,x;
  m++; l[m]=v[k-1]; r[m]=v[k]; w[m]=x=q[k-1]+q[k];//注意合并成为一棵树，新节点放在w数组的后面 
  //printf(" node %d(%d)=%d(%d)+%d(%d)\n",m,x,l[m],w[l[m]],r[m],w[r[m]]);//原程序中的列印 
  ans += x;
  t--;
  for (j=k;j<=t;j++) q[j]=q[j+1],v[j]=v[j+1];
  for (j=k-2;q[j]<x;j--) q[j+1]=q[j],v[j+1]=v[j];
  q[j+1]=x; v[j+1]=m;
 //for (d=1;d<=t;d++) printf("%d ",q[d]);
  //printf("\n");
  while (j>0 && q[j-1]<=x) {
    d=t-j; combine(j); j=t-d;
  }
}


void mark(int k, int p)//int k; /* node */int p; /* starting depth */
{
  //printf(" node %d(%d) has depth %d\n",k,w[k],p);
  d[k]=p;
  if (l[k]>=0) mark(l[k],p+1);
  if (r[k]>=0) mark(r[k],p+1);
}



/*
@ The |build| subroutine rebuilds a tree from the depth table,
by doing a depth-first search according a slick idea by Bob Tarjan.
It creates a tree rooted at node~|m| having leftmost leaf~|t|.

@<Sub...@>=*/
void build(int b)
{
  int j=m;
  if (d[t]==b) l[j]=t++;
  else {
    m--; l[j]=m; build(b+1);
  }
  if (d[t]==b) r[j]=t++;
  else {
    m--; r[j]=m; build(b+1);
  }
 // printf(" node %d = %d + %d\n", j,l[j],r[j]);
}
  