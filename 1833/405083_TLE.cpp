#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
using namespace std;
int main()
{
    int n;cin>>n;
    while(n--)
    {
        int a;cin>>a;
        int k;cin>>k;
        vector<int>vi;
        int i;
        for(i=0;i<a;i++)
        {
            int c;
            cin>>c;
            vi.push_back(c);
        }
        for(i=0;i<k;i++)
        {
            next_permutation(vi.begin(),vi.end());
        }
        for(i=0;i<vi.size();i++)
        {
            cout<<vi[i]<<" ";
        }
        cout<<endl;    
               
    }    
    return 0;
}


