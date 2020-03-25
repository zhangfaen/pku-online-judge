import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.*;
public class Main
{

	static int [][] map=new int[1001][1001];
	static int n,m;
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);	
	int T=cin.nextInt();
		dd:while(T--!=0)
		{
			
			n=cin.nextInt();
			m=cin.nextInt();
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					map[i][j]=map[i][j]=-1;
			for(int i=0;i<m;i++)
			{
				int a,b;
				a=cin.nextInt()-1;
				b=cin.nextInt()-1;
				map[a][b]=1;
			}
			//boolean isok=true;
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(j!=i)
					{
						if(f(i,j)!=1&&f(j,i)!=1)
						{
							//isok=false;
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
			for(int i=0;i<n;i++)
				if(i!=a&&map[a][i]==1)
					if(f(i,b)==1)
					{
						tag=1;
						break;
					}
			return map[a][b]=tag;
	
	}

	
}
