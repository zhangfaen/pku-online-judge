import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int [][]a=new int[101][101];
		int n=cin.nextInt();
		while(n--!=0)
		{
			String comm=cin.next();
			int x=cin.nextInt(),y=cin.nextInt(),L=cin.nextInt();
			if(comm.equals("BLACK"))
			{
				for(int i=x;i<x+L;i++)
					for(int j=y;j<y+L;j++)
						a[i][j]=1;
			}
			else
			if(comm.equals("WHITE"))
			{
				for(int i=x;i<x+L;i++)
					for(int j=y;j<y+L;j++)
						a[i][j]=0;
			}
			else
			{
				int sum=0;
				for(int i=x;i<x+L;i++)
					for(int j=y;j<y+L;j++)
						if(a[i][j]==1)
							sum++;
				System.out.println(sum);
			}
		}
		
	}
}