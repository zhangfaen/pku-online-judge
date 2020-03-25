#include <stdio.h>
#include <math.h>
#define N 250000
long a[N];
long p(long l,long r)
{
   long i=l-1,j=r+1,tmp=a[l],tmp2;
   while(i<j) 
   {
      while(a[++i]<tmp);
      while(a[--j]>tmp);
      if(i<j)
      {
          tmp2=a[i];
          a[i]=a[j];
          a[j]=tmp2;       
      }          

   } 
    return j;



}
void qsort(long l,long r)
{
   long mid; 
   if(l<r)
   {
     mid=p(l,r);
     qsort(l,mid-1);
     qsort(mid+1,r);      
   }  
}




int main()
{
   long n,i;
   double result; 
   scanf("%ld",&n);
   for(i=1;i<=n;i++)
       scanf("%ld",&a[i]);
   qsort(1,n);
   if(n%2==1)
     printf("%ld.0\n",a[(n+1)/2]);
   else 
   {
       result=1.0*a[n/2]+1.0*a[(n+2)/2];
       result/=2.0;
       printf("%.1lf\n",result)   ;
   }    
   return 0;
}