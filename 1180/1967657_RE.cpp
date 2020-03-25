#include<iostream>
using namespace std;
int main()
{
        int mincost,s,t[5000],f[5000],tt[5000],tc[5000],min[5000],tf[5000],N;
        cin>>N;
        cin>>s;
        for( int i = 0; i < N; i++ )
                cin>>t[i]>>f[i];
        int temp;
        min[N-1] = ( s + t[N-1] ) * f[N-1];
        for( i = N-2; i >= 0; i-- )
        {
                temp = s+t[i];
                tt[i] = temp;
                tf[i] = f[i];
                for( int j = i+1; j < N; j++ )
                {
                        temp+=t[j];
                        tt[j] = temp;
                        tf[j] = tf[j-1] + f[j];
                }
                tc[N-1] = f[N-1] * tt[N-2];
                temp = f[N-1];
                for( j = N-2; j > i; j-- )
                {
                        temp += f[j];
                        tc[j] = tt[j-1] * temp;
                }
                temp += f[i];
                mincost = temp * tt[N-1];
                for( j = i; j < N - 1; j++ )
                {
                        temp = tt[j] * tf[j];
                        if( temp + min[j+1] + tc[j+1] < mincost )
                        {
                                mincost = temp + min[j+1] + tc[j+1];
                        }
                }
                min[i] = mincost;
        }
        cout<<min[0]<<endl;
        return 0;
}