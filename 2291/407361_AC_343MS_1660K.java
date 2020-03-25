
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int num=cin.nextInt();
		while(num--!=0)
		{
			int n=cin.nextInt();
			int max=0;
			int ropes=0;
			int[]a=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=cin.nextInt();
			}
			Arrays.sort(a);
			for(int i=a.length-1;i>=0;i--)
			{
				int t=(ropes+1)*a[i];
				if(t>=max)
				{
					
					max=t;
				}
				ropes++;
				
				
			}
			System.out.println(max);
		}		
	}
}