import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int tt=cin.nextInt();
		while(tt--!=0)
		{
			int n=cin.nextInt();
			if(n%2!=0)
				System.out.println("YES");
			else
			{
				int a=0,b=0;
				for(int i=0;i<n;i++)
				{
					int t=cin.nextInt();
					if(t==0)
					{
						if(i%2==0)a++;
						else b++;
					}	
				}
				if(a-b==1||a-b==-1||a==b)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

}
