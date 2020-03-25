#include<iostream.h>
#include<math.h>
int main()
{
    int i,j,k,m,n;
    cin>>n;
    while(n)
    {
        cin>>m;
        for(i=int(ceil(pow(m,1.0/3)))+1;i>0;i--)
        if(m%i==0)
        {
            m=m/i;
            for(j=int(pow(m,0.5))+1;j>0;j--)if(m%j==0)
            {k=m/j;cout<<2*(i*j+j*k+k*i)<<endl;goto next;}
        }
next:   n--;
    }
    return 0;
}