

#include<stdio.h>
#include<math.h>
void main () {
    int i,j=0,m,n,a[20];
    for(;;)
{
   for(i=0;;i++)
{
scanf("%d",&a[i]);
if(a[i]==0) goto l;
else if(a[i]==-1) goto end;
}l:
for(m=0;m<i;m++)
for(n=0;n<i;n++)
if(2*a[m]==a[n]) j=j+1;
else continue;
}
printf("%d\n",j);
end:;
}  
 
