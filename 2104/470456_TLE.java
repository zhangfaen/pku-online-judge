import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int m=cin.nextInt();
		int [] p=new int[n+1];
		for(int i=0;i<n;i++)
			p[i+1]=cin.nextInt();
		while(m--!=0)
		{
			int i,j,k;
			i=cin.nextInt();
			j=cin.nextInt();
			k=cin.nextInt();
			int length=j-i+1;
			int [] t=new int[length];
			for(int x=0;x<length;x++)
			{
				t[x]=p[x+i];
			}
			Arrays.sort(t);
			System.out.println(t[k-1]);
		}
			
		
	} 

	
}
