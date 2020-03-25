#include<stdio.h>
#include<stdlib.h>
char map[30][30];
int vst[30][30];
int dx[]={1,-1,0,0};
int dy[]={0,0,1,-1};
int w,h;
void dfs(int cx,int cy){
	if(vst[cx][cy]==1)return;
	vst[cx][cy]=1;
	for(int k=0;k<4;k++){
		int nx=cx+dx[k],ny=cy+dy[k];
		if(nx<0||ny<0||nx>=h||ny>=w||vst[nx][ny]==1||map[nx][ny]=='#')continue;
		dfs(nx,ny);
	}
}
int main(){
	while(1){
		scanf("%d%d",&w,&h);
		if(w+h==0)break;
		for(int i=0;i<h;i++)
			scanf("%s",map+i);
		for(int i=0;i<h;i++)for(int j=0;j<w;j++)vst[i][j]=0;
		int sx=0,sy=0;
		for(int i=0;i<h;i++)for(int j=0;j<w;j++)if(map[i][j]=='@'){sx=i;sy=j;}
		dfs(sx,sy);
		int count=0;
		for(int i=0;i<h;i++)for(int j=0;j<w;j++)if(vst[i][j]==1)count++;
		printf("%d\n",count);
		
	}
	//system("pause");
	return 0;
}