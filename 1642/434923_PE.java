import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		//System.setOut(new PrintStream("c:\\out.txt"));
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int [][][]a=new int[21][21][21];
			for(int i=0;i<n;i++)
			{
				int x=0;
				while(true)
				{
					int t=cin.nextInt();
					if(t==0)
						break;
					for(int k=0;k<t;k++)
						a[x][i][k]=1;
					x++;
				}
			}
			for(int z=0;z<21;z++)
			{
				boolean tag=false;
				boolean first=true;
				for(int y=0;y<21;y++)
				{
					int sum=0;
					for(int x=0;x<21;x++)
						if(a[x][y][z]==1)
							sum++;
					if(sum>0)
					{
						if(first)
						{
							System.out.print(sum);
							first=false;
						}
						else
							System.out.print(" "+sum);
						tag=true;
					}
						
				}
				if(tag)
					System.out.println();
			}
			System.out.println(); 
			for(int x=0;x<21;x++)
			{
				boolean tag=false;
				boolean first=true;
				for(int z=0;z<21;z++)
				{
					int sum=0;
					for(int y=0;y<21;y++)
						if(a[x][y][z]==1)
							sum++;
					if(sum>0)
					{
						if(first)
						{
							System.out.print(sum);
							first=false;
						}
						else
							System.out.print(" "+sum);
						tag=true;
					}
						
				}
				if(tag)
					System.out.println();
			}
			System.out.println();
			
		}
	}
}