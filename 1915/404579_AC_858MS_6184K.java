import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int num=cin.nextInt();
		while(num--!=0)
		{
			int n=cin.nextInt();
			int [][]board=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					board[i][j]=-1;
			LinkedList<Cor> queue=new LinkedList<Cor>();
			int x,y;
			x=cin.nextInt();
			y=cin.nextInt();
			board[x][y]=0;
			Cor start=new Cor(x,y);
			x=cin.nextInt();
			y=cin.nextInt();
			Cor dest=new Cor(x,y);
			queue.add(start);
			while(queue.size()>0)
			{
				Cor t=queue.removeFirst();
				if(t.equals(dest))
				{
					System.out.println(board[t.x][t.y]);
					break;
				}
				if(t.x-2>=0&&t.y+1<n&&board[t.x-2][t.y+1]==-1)
				{
					queue.addLast(new Cor(t.x-2,t.y+1));
					board[t.x-2][t.y+1]=board[t.x][t.y]+1;
				}
				if(t.x-1>=0&&t.y+2<n&&board[t.x-1][t.y+2]==-1)
				{
					queue.addLast(new Cor(t.x-1,t.y+2));
					board[t.x-1][t.y+2]=board[t.x][t.y]+1;
				}
				if(t.x+1<n&&t.y+2<n&&board[t.x+1][t.y+2]==-1)
				{
					queue.addLast(new Cor(t.x+1,t.y+2));
					board[t.x+1][t.y+2]=board[t.x][t.y]+1;
				}
				if(t.x+2<n&&t.y+1<n&&board[t.x+2][t.y+1]==-1)
				{
					queue.addLast(new Cor(t.x+2,t.y+1));
					board[t.x+2][t.y+1]=board[t.x][t.y]+1;
				}
				if(t.x+2<n&&t.y-1>=0&&board[t.x+2][t.y-1]==-1)
				{
					queue.addLast(new Cor(t.x+2,t.y-1));
					board[t.x+2][t.y-1]=board[t.x][t.y]+1;
				}
				if(t.x+1<n&&t.y-2>=0&&board[t.x+1][t.y-2]==-1)
				{
					queue.addLast(new Cor(t.x+1,t.y-2));
					board[t.x+1][t.y-2]=board[t.x][t.y]+1;
				}
				if(t.x-1>=0&&t.y-2>=0&&board[t.x-1][t.y-2]==-1)
				{
					queue.addLast(new Cor(t.x-1,t.y-2));
					board[t.x-1][t.y-2]=board[t.x][t.y]+1;
				}
				if(t.x-2>=0&&t.y-1>=0&&board[t.x-2][t.y-1]==-1)
				{
					queue.addLast(new Cor(t.x-2,t.y-1));
					board[t.x-2][t.y-1]=board[t.x][t.y]+1;
				}
					
			}
			
		}
	}
}
class Cor
{
	public int x;
	public int y;
	public Cor(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public Cor()
	{
		this.x=-1;
		this.y=-1;
	}
	public boolean equals(Object o)
	{
		if(o.getClass()!=this.getClass())
			return false;
		Cor t=(Cor)o;
		return t.x==x&&t.y==y;
	}
}