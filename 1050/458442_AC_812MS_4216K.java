import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int p[][]=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				p[i][j]=cin.nextInt();
		int q[][]=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				for(int m=0;m<=i;m++)
					for(int k=0;k<=j;k++)
					{
						q[i][j]+=p[m][k];
					}
			//	System.out.print(" "+q[i][j]);
			}
		int max=0;
	
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				for(int m=i;m<n;m++)
					for(int k=j;k<n;k++)
					{
						int t=0;
						if(i==0&&j==0)
							t=q[m][k];
						else
							if(i==0)
								t=q[m][k]-q[m][j-1];
							else
								if(j==0)
									t=q[m][k]-q[i-1][k];
								else
									t=q[m][k]-q[i-1][k]-q[m][j-1]+q[i-1][j-1];
						if(t>max)max=t;
					}
		System.out.println(max);
	}

}
