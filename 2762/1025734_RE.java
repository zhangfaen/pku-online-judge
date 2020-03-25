import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{

	static int [][] map=new int[1001][1001];
	static int n,m;
	public static void main(String[] args) throws IOException
	{
		//BufferedWriter bw=new BufferedWriter(new FileWriter("c:\\out.txt"));
		//for(int i=1;i<=1000;i++)
		//	bw.write(i+" "+(i+1)+"\r\n");
		//bw.close();
		Scanner cin = new Scanner(System.in);
		int T=cin.nextInt();
		dd:while(T--!=0)
		{
			n=cin.nextInt();
			m=cin.nextInt();
			for(int i=0;i<=n;i++)
				for(int j=0;j<=n;j++)
					map[i][j]=-1;
			for(int i=0;i<m;i++)
			{
				int a,b;
				a=cin.nextInt();
				b=cin.nextInt();
				map[a][b]=1;
			}
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					if(j!=i)
					{
						if(f(i,j)!=1&&f(j,i)!=1)
						{
							System.out.println("No");
							continue dd;
						}
					}
			System.out.println("Yes");
		}

	}
	static int f(int a,int b)
	{
			if(map[a][b]!=-1)
				return map[a][b];
			int tag=0;
			for(int i=1;i<=n;i++)
				if(i!=a&&map[a][i]==1)
					if(f(i,b)==1)
					{
						tag=1;
						break;
					}
			return map[a][b]=tag;
	
	}

	
}
