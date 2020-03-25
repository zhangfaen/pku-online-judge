#include<stdio.h>
#include<math.h>
int main()
{
  int i,j,k1,k2,a,b,m=0;
  double r,t1,t2,rn;
  while(scanf("%d %d",&a,&b)==2)
  {
	if(m)printf("\n");
	r=(double)a/b;
	j=0;rn=r;j++;
	k1=(int)floor(r*j);k2=(int)ceil(r*j);
	  t1=(double)k1/j;t2=(double)k2/j;
	  if(fabs(t1-rn)<fabs(t2-rn))
	    {printf("%d/%d\n",k1,j);rn=fabs(t1-r);}
	  else {printf("%d/%d\n",k2,j);rn=fabs(t2-r);}
	j++;
	while(j<=b)
	{
	  k1=(int)floor(r*j);k2=(int)ceil(r*j);
	  t1=(double)k1/j;t2=(double)k2/j;
	  if(fabs(t1-rn)<fabs(t2-rn)&&fabs(t1-r)<rn)
	    {printf("%d/%d\n",k1,j);rn=fabs(t1-r);}
	  else if(fabs(t2-r)<rn)
	    {printf("%d/%d\n",k2,j);rn=fabs(t2-r);}
	  j++;
	}
	m++;
  }    
  return 0;
}    