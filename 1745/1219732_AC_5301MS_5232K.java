import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class Main
{
	
	public static void main(String[] args) throws Exception
	{
		
		Scanner cin = new Scanner(System.in);
		int n=cin.nextInt();
		int k=cin.nextInt();
		boolean [][] p=new boolean[n][k];
		int fir=cin.nextInt();
		p[0][((fir%k)+k)%k]=true;
		for(int i=1;i<n;i++)
		{
			int t=cin.nextInt();
			for(int j=0;j<k;j++)
			{
				if(p[i-1][j])
				{
					p[i][((j+t)%k+k)%k]=true;
					p[i][((j-t)%k+k)%k]=true;
				}
			}
		}
		if(p[n-1][0])
			System.out.println("Divisible");
		else
			System.out.println("Not divisible");
	}
}
