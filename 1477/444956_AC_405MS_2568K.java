import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int index=0;
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			index++;
			int [] p=new int[n];
			int sum=0;
			for(int i=0;i<n;i++)
			{
				p[i]=cin.nextInt();
				sum+=p[i];
			}
			int avg=sum/n;
			int moves=0;
			for(int i=0;i<n;i++)
			{
				moves+=Math.abs(avg-p[i]);	
			}
			System.out.printf("Set #%d\nThe minimum number of moves is %d.\n\n",index,moves/2);
			
		}	
	
			
	}

	
}
