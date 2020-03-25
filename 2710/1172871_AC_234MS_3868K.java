import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner cin = new Scanner(System.in);
		int n=cin.nextInt();
		for(int set=1;set<=n;set++)
		{
			int fenz=cin.nextInt();
			int fenmu=cin.nextInt();
			int base=cin.nextInt();
			int throu=cin.nextInt();
			int sfenz=fenz,sfenmu=fenmu,sbase=base,sthrou=throu;
			fenz%=fenmu;
			fenz=Integer.parseInt(Integer.toString(fenz,7));
			fenmu=Integer.parseInt(Integer.toString(fenmu,7));
			String re=".";
			for(int i=0;i<300;i++)
			{
				fenz*=10;
				int t=0;
				while(fenz>=fenmu)
				{
					fenz=sub(fenz,fenmu);
					t++;
				}
				re+=t;
				
			}
			System.out.printf("Problem set %d: %d / %d, base 7 digits %d through %d: %s\n",set,sfenz,sfenmu,sbase,sthrou,re.substring(base+1,throu+2));
		}
	}
	public static int sub(int a,int b)
	{
		int a10=0,b10=0;
		int base=1;
		while(a!=0)
		{
			a10+=base*(a%10);
			a/=10;
			base*=7;
		}
		base=1;
		while(b!=0)
		{
			b10+=base*(b%10);
			b/=10;
			base*=7;
		}
		int t=a10-b10;
		return Integer.parseInt(Integer.toString(t,7));
		
	}
}
