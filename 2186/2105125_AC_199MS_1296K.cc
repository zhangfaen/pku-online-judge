#include <stdio.h>
#include <algorithm>
#include <stack>
#define size 11000
using namespace std;

int N, M;

typedef struct Node
{
    int id;
    int next;
} Node;

typedef struct Edge
{
    int s, e;
}Edge;

Edge E[size * 6];
Node G[size * 7];
int pre[size], id[size];
typedef stack<int> Stack;
Stack S, path;
int end;
int cnt, scnt;
int vis[size];
int in[size];

void Insert(int s, int e)
{
    int p = s;
    while (G[p].next)
    {
        p = G[p].next;
        if (G[p].id == e)
        {
            return;
        }
    }
    G[p].next = end;
    G[end].id = e;
    end++;
}

void scR(int w)
{
    int v;
    int p, t;
    pre[w] = cnt++;
    S.push(w);
    path.push(w);
    p = G[w].next;
    while (p)
    {
        t = G[p].id;
        p = G[p].next;
        if (pre[t] == -1)
            scR(t);
        else if (id[t] == -1)
            while (pre[path.top()] > pre[t])
                path.pop();
    }
    if (path.top() == w)
        path.pop();
    else
        return;
    do
    {
        id[v = S.top()] = scnt;
        S.pop();
    }
    while (v != w);
    scnt++;
}

void Gabow()
{
    int i;
    memset(pre, -1, sizeof(pre));
    memset(id, -1, sizeof(id));
    cnt = 0;
    scnt = 0;
    while (!S.empty())
        S.pop();
    while (!path.empty())
        path.pop();
    for (i = 1; i <= N; i++)
    {
        if (pre[i] == -1)
        {
            scR(i);
        }
    }
}

void DFS(int w, int d)
{
    int p = G[w].next;
    d++;
    pre[w] = 1;
    if (d > cnt)
    {
        cnt = d;
    }
    while (p)
    {
        if (pre[G[p].id] != 1)
        {
            DFS(G[p].id, d);
        }
        p = G[p].next;
    }
}

void Solve()
{
    int i, s, e;
    int pos;
    memset(G, 0, sizeof(G));
    end = N + 10;
    memset(in, 0, sizeof(in));
    for (i = 0; i < M; i++)
    {
        scanf("%d %d", &s, &e);
        E[i].s = s;
        E[i].e = e;
        Insert(s, e);
    }
    Gabow();
    memset(G, 0, sizeof(G));
    memset(pre, 0, sizeof(pre));
    end = scnt + 10;
    for (i = 0; i < M; i++)
    {
        s = id[E[i].s];
        e = id[E[i].e];
        if (s != e)
        {
            in[s]++;
        }
    }
    cnt = 0;
    for (i = 0; i < scnt; i++)
    {
        if (in[i] == 0)
        {
            pos = i;
            cnt++;
        }
    }
    if (cnt != 1)
    {
        printf("0\n");
    }
    else
    {
        cnt = 0;
        for (i = 1; i <= N; i++)
        {
            if (id[i] == pos)
            {
                cnt++;
            }
        }
        printf("%d\n", cnt);
    }
}

int main()
{
    while (scanf("%d %d", &N, &M) != EOF)
        Solve();
    
    return 0;
}