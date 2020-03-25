#include<iostream>
#include<fstream>
#include<iomanip>
#define MAXNUM 21000000
using namespace std;

unsigned int Edge[1001][1001];
unsigned int dist[1001];
bool s[1001];

void shortPath(int n,int v){
    int i,j,w;
    for(i=1;i<=n;i++){
        dist[i]=Edge[i][v];
        s[i]=0;
    }
    s[v]=1;dist[v]=0;
    for(i=0;i<n-1;i++){
        unsigned int min=MAXNUM;
        int u=v;
        for(j=1;j<=n;j++){
            if(!s[j]&&dist[j]<min){
                u=j;
                min=dist[j];
            }
        }
        s[u]=1;
        for(w=1;w<=n;w++){
            if( !s[w] &&  Edge[u][w]<MAXNUM && dist[w]>Edge[u][w]+dist[u]){
                dist[w]=Edge[u][w]+dist[u];
            }
        }
    }
}

int main(){
    int T,N;
    //ifstream cin("tmp.txt");
    cin>>T>>N;
    int i,j;
    for(i=1;i<=N;i++){
        for(j=1;j<=N;j++){
            Edge[i][j]=MAXNUM;
        }
    }
    for(i=1;i<=N;i++){
        Edge[i][i]=0;
    }    
    for(i=0;i<T;i++){
        int x,y,tmp;
        scanf("%d %d %d",&x,&y,&tmp);
        if(tmp<Edge[x][y]){
            Edge[x][y]=tmp;
            Edge[y][x]=tmp;
        }
    }
    shortPath(N,N);
    /* for(i=1;i<=N;i++){
        for(j=1;j<=N;j++){
            cout<<setw(5)<<Edge[i][j]<<' ';
        }
        cout<<endl;
    }    */ 
    cout<<dist[1]<<endl;
    system("pause");
    return 0;
}            
