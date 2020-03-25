import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt(),N=cin.nextInt();
		int [][]map=new int[N+1][N+1];
		for(int i=0;i<=N;i++)
			for(int j=0;j<=N;j++)
			{
				if(i!=j)
					map[i][j]=Integer.MAX_VALUE;
				else
					map[i][j]=0;
			}
				
		for(int i=0;i<T;i++)
		{
			int x=cin.nextInt();
			int y=cin.nextInt();
			int t=cin.nextInt();
			if(t<map[x][y])
				map[x][y]=map[y][x]=t;
		}
		List<Integer>left=new ArrayList<Integer>(1001);
		List<Integer>right=new ArrayList<Integer>(1001);
		left.add(1);
		for(int i=2;i<=N;i++)
			right.add(i);
		while(true)
		{
			int min=Integer.MAX_VALUE;
			int v=-1;
			for(int i=0;i<left.size();i++)
			{				
				int k=left.get(i);
				for(int j=0;j<right.size();j++)
				{
					int t=sum(map[1][k],map[k][right.get(j)]);
					if(min>t)
					{
						min=t;
						v=j;
					}
				}

			}
			left.add(right.get(v));
			map[1][right.get(v)]=min;
			if(right.get(v)==N)
				break;
			right.remove(v);					
		}

		System.out.println(map[1][N]);
	}
	private static int sum(int a,int b)
	{
		if(a==Integer.MAX_VALUE||b==Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return a+b;
	}
	private static int min(int a,int b)
	{
		if(a<b)return a;
		return b;
	}
}