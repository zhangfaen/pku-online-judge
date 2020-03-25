import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			int x=cin.nextInt();
			int y=cin.nextInt();
			if(x-y==2||x==y)
			{
				if(x==y)
				{
					if(x%2==0)
						System.out.println(x*2);
					else
						System.out.println((x-1)*2+1);
				}
				else
				{
					if(x%2==0)
						System.out.println(x*2-2);
					else
						System.out.println((x-1)*2-2+1);
				}
				
				
			}
			else
				System.out.println("No Number");
		}
	}
}