import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			if(n==0)break;
			int max=0;
			for(int i=0;i<=54;i++)
				for(int j=1;j<=97;j++)
				{
					int t=i*i*i+(j*j*j-j)/6;
					if(t<=n&&t>max)
						max=t;
				}
			System.out.println(max);
		}	
	
			
	}
	
}
