#define max 1000001
#include"stdio.h"


void main()
{  long n,i,j;
   int a[max][2],b[max]={0};
   
   scanf("%ld",&n);
    for(i=0;i<n;i++)
        {scanf("%d%d",&a[i][0],&a[i][1]);
        b[i]=a[i][0]+a[i][1];}
     for(i=n-1;i>0;i--)
         if(b[i]>=10)  {b[i-1]+=1;b[i]=b[i]%10;}
    for(i=0;i<n;i++)
     printf("%d",b[i]);
    printf("\n");
  
}