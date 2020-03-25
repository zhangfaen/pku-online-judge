import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
            public static void main(String args[]) throws Exception
            {
            		InputStream in=new FileInputStream("c:\\in.txt");
                    Scanner cin=new Scanner(in);
                   	int N,M;
                   	N=cin.nextInt();
                   	M=cin.nextInt();
                   	char[][]map=new char[N][M];
                   	for(int i=0;i<N;i++)
                   	{
                   		String t=cin.next();
                   		for(int j=0;j<M;j++)
                   			map[i][j]=t.charAt(j);
                   	}
                   	for(int i=0;i<N;i++)
                   	{
                   		for(int j=0;j<M;j++)
                   			System.out.print(map[i][j]);
                   		System.out.println();
                   	}
                   	int sum=0;
                   	for(int i=0;i<N;i++)
                   		for(int j=0;j<M;j++)
                   		{
                   			if(map[i][j]=='W')
                   			{
                   				sum++;
                   				LinkedList<Cor> queue=new LinkedList<Cor>();
                   				queue.addLast(new Cor(i,j));
                   				map[i][j]='.';
                   				while(queue.size()>0)
                   				{
                   					Cor cor=queue.removeFirst();
                   					int x=cor.x;
                   					int y=cor.y;
                   					if(x-1>=0&&map[x-1][y]=='W')
                   					{
                   						queue.addLast(new Cor(x-1,y));
                   						map[x-1][y]='.';	
                   					}
                   					if(x-1>=0&&y+1<M&&map[x-1][y+1]=='W')
                   					{
                   						queue.addLast(new Cor(x-1,y+1));
                   						map[x-1][y+1]='.';	
                   					}
                   					if(y+1<M&&map[x][y+1]=='W')
                   					{
                   						queue.addLast(new Cor(x,y+1));
                   						map[x][y+1]='.';	
                   					}
                   					if(x+1<N&&y+1<M&&map[x+1][y+1]=='W')
                   					{
                   						queue.addLast(new Cor(x+1,y+1));
                   						map[x+1][y+1]='.';	
                   					}
                   					if(x+1<N&&map[x+1][y]=='W')
                   					{
                   						queue.addLast(new Cor(x+1,y));
                   						map[x+1][y]='.';	
                   					}
                   					if(x+1<N&&y-1>=0&&map[x+1][y-1]=='W')
                   					{
                   						queue.addLast(new Cor(x+1,y-1));
                   						map[x+1][y-1]='.';	
                   					}
                   					if(y-1>=0&&map[x][y-1]=='W')
                   					{
                   						queue.addLast(new Cor(x,y-1));
                   						map[x][y-1]='.';	
                   					}
                   					if(x-1>=0&&y-1>0&&map[x-1][y-1]=='W')
                   					{
                   						queue.addLast(new Cor(x-1,y-1));
                   						map[x-1][y-1]='.';	
                   					}
                   				}
                   			}
                   		}
					System.out.println(sum);	            
                   	
            }
}
class Cor
{
	public Cor(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int x=-1;
	public int y=-1;
}