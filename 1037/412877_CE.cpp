#include <stdio.h>

long long T,N;
long long C;
long long a[21];
long long up[21][21];
long long down[21][21];

void print();
void init()
{
  up[1][1] = 1;
  for(long long i=2;i<=20;i++)
  {  long long j;
     for(j=2;j<=i;j++)
       down[i][j] = down[i][j-1] + up[i-1][j-1];
 
     for(j=1;j<i;j++)
       up[i][j] = down[i][i+1-j];

// print();
  }
}

void go_up(long long n,long long c,long long lmt);
void go_down(long long n,long long c,long long lmt)
{
  if(n==1) {printf(" %d",a[n]);return;}

  for(long long i=lmt;i<=n;i++)
  {
   c -= down[n][i];
   if(c<1)
   {
    printf(" %d",a[i]);
    for(long long j=i;j<=n;j++) a[j] = a[j+1];
    go_up(n-1,c+down[n][i],i-1);
    break;
   }
  }
}
void go_up(long long n,long long c,long long lmt)
{
 if(n==1) {printf(" %d",a[n]);return;}

  for(int i=1;i<=lmt;i++)
  {
   c -= up[n][i];
   if(c<1)
   {
    printf(" %d",a[i]);
    for(int j=i;j<=n;j++) a[j] = a[j+1];
    go_down(n-1,c+up[n][i],i);
    break;
   }
  }
}
void solve(long long n,long long c)
{
  if(n==1) printf("%d",a[n]);

  for(long long i=2;i<=n;i++)
  {
  c -= up[n][i-1];
  if(c<1)
  { 
   printf("%d",a[i-1]);
   for(int j=i-1;j<n;j++) a[j] = a[j+1];
   go_down(n-1,c+up[n][i-1],i-1);
   break;
  }

  c -= down[n][i];
  if(c<1)
  {
   printf("%d",a[i]);
   for(int j=i;j<n;j++) a[j] = a[j+1];
   go_up(n-1,c+down[n][i],i);
   break;
  }
  }
}

int main()
{
//  freopen("in.txt","r",stdin);
//  freopen("out.txt","w",stdout);
  init();
  scanf("%Ld",&T);
 
  while(T--)
  {
    scanf("%Ld%Ld",&N,&C);
    for(long long i=1;i<=20;i++) a[i] = i;
      solve(N,C);
    printf("%c",13);
    printf("\n");
  }
  return 1;
}

void print()
{
  int u,v;
  for(u=1;u<=6;u++)
  {  for(v=1;v<=6;v++)
   {  printf("%4d ",up[v][u]);
   
   } printf("\n");
  }
 printf("\n");
  for(u=1;u<=6;u++)
  {  for(v=1;v<=6;v++)
   {  printf("%4d ",down[v][u]);
   
   } printf("\n");
  }   
  printf("------------------\n");
}
