import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			boolean [][] p=new boolean[n][n];
			int [] x=new int[n];
			int [] y=new int[n];
			for(int i=0;i<n;i++)
			{
				x[i]=cin.nextInt();
				y[i]=cin.nextInt();
			}
			int max=2;
			for(int i=0;i<n-1;i++)
				for(int j=i+1;j<n;j++)
				{
					int tsum=0;
					if(p[i][j])
						continue;
					p[i][j]=true;
					for(int k=0;k<n;k++)
						if(ok(x[i],y[i],x[j],y[j],x[k],y[k]))
						{
							p[i][k]=p[k][i]=p[k][j]=p[j][k]=true;
							tsum++;
						}
					if(tsum>max)
						max=tsum;
				}
			System.out.println(max);
		}
		
	}
	public static boolean ok(int x1,int y1,int x2,int y2,int x,int y)
	{
		return (y-y1)*(x2-x1)==(x-x1)*(y2-y1);
	}
}
