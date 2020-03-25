import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception 
	{
		Scanner cin=new Scanner(new File("System.in"));
		int n;
		while((n=cin.nextInt())!=0)
		{
		//	System.out.println("begin:");
			int total=2*n;
			int a[]=new int[total+1];
			for(int i=0;i<total+1;i++)
				a[i]=i;
			for(int m=n+1;;m++)
			{
				int num=0;
				int kouhao=0;
				int[]b=a.clone();
				for(int k=1;k<=total;k++,k%=(total+1))
				{
					if(b[k]!=0)
						kouhao++;
					if(kouhao==m)
					{
						b[k]=0;
						kouhao=0;
						if(k<=n)
						{
							//System.out.println(m+"is not ok");
							break;
						}
						num++;
						//System.out.println(k);
					}
					if(num==n)break;
				}
				if(num==n)
				{
					System.out.println(m);
					break;
				}
			}
		}
		
	}
}
