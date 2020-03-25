import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	
	public static void main(String[] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		out:while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int [] p=new int[n];
			for(int i=0;i<n;i++)
				p[i]=cin.nextInt();
			int [] num=new int[102];
			for(int i=0;i<n;i++)
				num[p[i]]++;
			if(n%2==1)
			{
				System.out.println(1);
			}
			else
			{
				for(int i=0;i<102;i++)
					if(num[i]%2==1)
					{
						System.out.println(1);
						continue out;
					}
				System.out.println(0);
			}
		}
	}

}
