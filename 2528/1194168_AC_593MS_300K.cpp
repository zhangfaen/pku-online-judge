#include <cstdio>
#include <iostream>
using namespace std;
struct stru
{
    int l;
    int r;
    int b;
}gai[10001],stick[10001];    

int main()
{
    int c,n,l,r;
    scanf("%d",&c);
    while(c--)
    {
        scanf("%d",&n);
        int i;
        for(i=0;i<n;i++)
        {
            scanf("%d%d",&l,&r);
            gai[i].l=l;
            gai[i].r=r;
            gai[i].b=1;
            stick[i]=gai[i];
        }
        for(i=n-1;i>0;i--)
        {
            int j;
            for(j=i-1;j>=0;j--)
            {
                //gai[i],gai[j]
                if((gai[j].r+1>=gai[i].l)&&(gai[j].l<=gai[i].r+1))
                {
                    if(gai[j].r<gai[i].r)
                      gai[j].r=gai[i].r;
                    if(gai[j].l>gai[i].l) gai[j].l=gai[i].l;
                    gai[i].b=0;
                    break;
                }    
            }     
        }
        int result=0;
        for(i=0;i<n;i++)
        {
            int re=1;
            int j;
            for(j=i+1;j<n;j++)
            {
                if((stick[i].l>=gai[j].l)&&(stick[i].r<=gai[j].r))
                {
                    re=0;
                    break;
                }
            }
            if(re==1) 
            {
                result++;
            }    
        }
        cout<<result<<endl;
    }
    return 0;
} 