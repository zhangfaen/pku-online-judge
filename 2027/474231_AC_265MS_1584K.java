import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int nn=cin.nextInt();
		while(nn--!=0)
		{
			int m,n;
			m=cin.nextInt();
			n=cin.nextInt();
			if(m>=n)
				System.out.println("MMM BRAINS");
			else
				System.out.println("NO BRAINS");
		}
	}
}
