import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{

		Scanner cin = new Scanner(System.in);
		while(true)
		{
			int tot=cin.nextInt();
			int n=cin.nextInt();
			if(tot+n==0)
				break;
			tot++;
			for(int i=0;i<n;i++)
			{
				int x=cin.nextInt();
				int y=cin.nextInt();
				tot-=y-x+1;
			}
			System.out.println(tot);
		}

	}
	
}

