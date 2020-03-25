import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String args[]) throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		for(int i=0;i<n;i++)
		{
			int t=cin.nextInt();
			int []a=new int[t];
			for(int j=0;j<t;j++)
			{
				a[j]=cin.nextInt();
			}
			int total=0;
			for(int j=1;j<t;j++)
				for(int k=0;k<j;k++)
				{
					if(a[j]<a[k])
						total++;
				}
			System.out.println("Scenario #"+(i+1)+":");
			System.out.println(total);
			System.out.println();
		}
	
		
	}
}
