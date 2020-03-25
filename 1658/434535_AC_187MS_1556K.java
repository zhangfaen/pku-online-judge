import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			int a[]=new int[5];
			for(int i=0;i<4;i++)
				a[i]=cin.nextInt();
			if(a[1]-a[0]==a[2]-a[1]&&a[1]-a[0]==a[3]-a[2])
			{
				a[4]=a[3]+a[1]-a[0];
			}
			else
				a[4]=a[3]*(a[1]/a[0]);
			for(int i=0;i<5;i++)
				System.out.print(a[i]+" ");
			System.out.println();
		}	
	}
}