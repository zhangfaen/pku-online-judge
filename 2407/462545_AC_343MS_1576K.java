import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		boolean [] p=new boolean[100000];
		for(int i=2;i<100000/2;i++)
			for(int j=2;i*j<100000;j++)
				p[i*j]=true;
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			int end=(int)Math.sqrt(n);
			int sum=n;
			int tn=n;
			for(int i=2;i<=end;i++)
			{
				if(!p[i]&&n%i==0)
				{
					sum=sum/i*(i-1);
					while(tn%i==0)
						tn/=i;
				}
			}
			if(tn>end)sum=sum/tn*(tn-1);
			if(sum==n)sum--;
			System.out.println(sum);
		}

	}



	
}