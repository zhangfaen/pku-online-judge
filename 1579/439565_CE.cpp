import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int p[][][]=new int[21][21][21];
		for(int i=0;i<21;i++)
			for(int j=0;j<21;j++)
			{
				p[i][j][0]=1;
				p[i][0][j]=1;
				p[0][i][j]=1;
			}		
		for(int i=1;i<21;i++)
			for(int j=1;j<21;j++)
				for(int k=1;k<21;k++)
				{
					if(i<j&&j<k)
						p[i][j][k]=p[i][j][k-1]+p[i][j-1][k-1]-p[i][j-1][k];
					else
						p[i][j][k]=p[i-1][j][k]+p[i-1][j-1][k]+p[i-1][j][k-1]-p[i-1][j-1][k-1];
				}
		while(true)
		{
			int a,b,c;
			a=cin.nextInt();b=cin.nextInt();c=cin.nextInt();
			if(a==-1&&b==-1&&c==-1)break;
			System.out.printf("w(%d, %d, %d) = ",a,b,c);
			if(a<=0||b<=0||c<=0)
				System.out.println(1);
			else
				if(a>20||b>20||c>20)
					System.out.println(p[20][20][20]);
				else
					System.out.println(p[a][b][c]);
		}
	}
}