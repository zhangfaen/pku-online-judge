import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		int MAX=70000;
		Scanner cin=new Scanner(System.in);
		int []p=new int[MAX];
		int []sumk=new int[MAX];
		sumk[1]=1;
		for(int i=0;i<MAX;i++)
		{
			if(i<10)p[i]=1;
			else
			if(i<100)p[i]=2;
			else
			if(i<1000)p[i]=3;
			else
			if(i<10000)p[i]=4;
			else
			p[i]=5;
		}
		for(int i=2;i<MAX;i++)
			sumk[i]=sumk[i-1]+p[i];
		int t=cin.nextInt();
		while(t--!=0)
		{
			int n=cin.nextInt();
			int index=0;
			for(;index<MAX;index++)
			{
				if(n>sumk[index])
					n-=sumk[index];
				else
					break;
			}
			for(int i=1;i<=index;i++)
			{
				if(n>p[i])n-=p[i];
				else
				{
					String s=Integer.toString(i);
					System.out.println(s.charAt(n-1));
					break;
				}
			}
			
		}
	}
}