#include<stdio.h>
#define pi 3.1415927
void main() {
	int a,i=0;
	float x,b,e,f;
	scanf ("%f",&x);
	scanf ("%d",&a);
         scanf ("%f",&b);
	while (a!=0&&b!=0) {
		i++;
		e=pi*x*a/(12*5280);
		f=3600*e/b;
		printf ("Trip #%d: %.2f %.2f\n",i,e,f);
		
	    scanf ("%f %d %f",&x,&a,&b);
	}
}
