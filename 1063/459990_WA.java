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
				int c=0,d=0;
				for(int i=0;i<n;i++)
				{
					int t=cin.nextInt();
					if(t==0)
					{
						if(i%2==0)a++;
						else b++;
					}
					else
					{
						if(i%2==0)
							c++;
						else
							d++;
					}	
				}
				if(a==b&&c==d||(a-b==1&&d-c==1)||(a-b==-1&&c-d==1))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

}
