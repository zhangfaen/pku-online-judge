import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main
{
	static int MAX=1000001;
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		boolean [] isPr=new boolean[1000001];
		int [] prime=new int[MAX];
		int primeTotal=0;
		Arrays.fill(isPr,true);
		for(int i=2;i<MAX;i++)
			if(isPr[i])
			{
				prime[primeTotal++]=i;
				for(int j=2;j<MAX/i;j++)
					isPr[i*j]=false;
			}
		
	
		while(cin.hasNextInt())
		{
			int m,n;
			m=cin.nextInt();
			n=cin.nextInt();
			if(m==1)
			{
				System.out.println(n);
				continue;
			}
			n--;
			boolean [] isHu=new boolean[m+1];
			Arrays.fill(isHu,true);
			for(int i=0;i<primeTotal;i++)
			{
				if(m%prime[i]==0)
				{
					for(int j=1;j<(m+1)/prime[i];j++)
						isHu[prime[i]*j]=false;
				}
			}
			int [] hu=new int[m+1];
			int huTotal=0;
			for(int i=1;i<m;i++)
				if(isHu[i])
				{
					hu[huTotal++]=i;
				}
			System.out.println(m*(n/huTotal)+hu[(n)%huTotal]);
			
		}
	}
}
