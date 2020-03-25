import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		for(int i=1;i<=n;i++)
		{
			int l,r;
			l=cin.nextInt();
			r=cin.nextInt();
			int a=0,b=0;
			while(l!=r)
			{
				if(l>r)
				{
					if(l%r==0)
					{
						a+=l/r-1;
						l=r;
					}
					else
					{
						a+=l/r;
						l=l%r;
					}
				}
				else
				{
					if(r%l==0)
					{
						b+=r/l-1;
						r=l;
					}
					else
					{
						b+=r/l;
						r=r%l;
					}
				}
			}
			System.out.println("Scenario #"+i+":");
			System.out.println(a+" "+b);
			System.out.println();
		}
	}
}