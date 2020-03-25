#include <stdio.h>
#include <stdlib.h>
//#include <iostream.h>


int main()
{
	int w=0,h=0;
//	char p[20][20],c;
//	int  mark[20][20]={0};
	char **p,c;
	int **mark;
	int i=0,j=0,count_all;
	int x=0,y=0;
	
	while(scanf("%d %d",&w,&h)==2)
	{
		count_all=1;//初始化
		
		
		if(w==0&&h==0)
			break;
		//	  int   **p;   
		//	 int   m,n;   
		// m=3;n=5;//行3,列5   
		p   =   (char   **)malloc((sizeof(char))   *   h); //先开3行  
		mark=	(int   **)malloc((sizeof(int))   *   h);
		
		for   (i=0;i<h;i++)   
		{   
			*(p   +   i)   =   (char  *)malloc((sizeof(char))   *   w); //再在每一行上面开辟5列   
	           *(mark +   i)   =   (int  *)malloc((sizeof(int))   *   w);
		}
		
		for(j=0;j<h;j++)
		{
			for(i=0;i<w;i++)
			{
				//	cin<<c;
				scanf("%c",&c);
				while(c=='\n')
					scanf("%c",&c);
				
				p[j][i]=c;
				mark[j][i]=0;
			}
		}	
		
		for(j=0;j<h;j++)			//寻找探险者起点位置
			for(i=0;i<w;i++)
			{  
				if(p[j][i]=='@')
					x=i,y=j;
			}
			
			//printf("hello");
			
			while (1)
			{
				if(y>=1 &&p[y-1][x]=='.'&& mark[y-1][x]==0)//up
					{count_all++,mark[y][x]=1;y--;}
				else if(x<w-1 &&p[y][x+1]=='.' && mark[y][x+1]==0)//right
					{count_all++,mark[y][x]=1;x++;}
				else if(y<h-1 &&p[y+1][x]=='.' && mark[y+1][x]==0)//down
					{count_all++,mark[y][x]=1;y++;}
				else if(x>=1 &&p[y][x-1]=='.' && mark[y][x-1]==0)//left
					{count_all++,mark[y][x]=1;x--;}
				else 
				{
					if(y>=1 && mark[y-1][x]==1 && (p[y-1][x]=='.'|| p[y-1][x]=='@'))//up
					{
						mark[y][x]=4;
						y--;
					}
					else 
						if(x<w-1 && mark[y][x+1]==1 && (p[y][x+1]=='.'|| p[y][x+1]=='@'))//right
						{
							mark[y][x]=4;
                            x++;
						}
						else
							if(y<h-1 && mark[y+1][x]==1 && (p[y+1][x]=='.'|| p[y+1][x]=='@'))//down
							{
								mark[y][x]=4;
								y++;
							}
							else 
								if(x>=1 && mark[y][x-1]==1 && (p[y][x-1]=='.'|| p[y][x-1]=='@'))//left
								{
									mark[y][x]=4;
									x--;
								}
								else
								{
									printf("%d\n",count_all);
									break;
								}
				}	
			}
			
			
			//	printf("%d\n",count_all);
			
			
			
	}
	return 0;
}