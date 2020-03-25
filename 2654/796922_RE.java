import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String [] s=cin.readLine().split(" +");
			int num=Integer.parseInt(s[0]);
			if(num==0)
				break;
			int k=Integer.parseInt(s[1]);
			int [] win=new int[num+1];
			int [] lost=new int[num+1];
			for(int i=0;i<k;i++)
			{
				s=cin.readLine().split(" +");
				int m=Integer.parseInt(s[0]);
				int n=Integer.parseInt(s[2]);
				char cm=s[1].charAt(0);
				char cn=s[3].charAt(0);
				int r=f(cm,cn);
				if(r==1)
				{
					win[m]++;
					lost[n]++;
				}
				else
				if(r==-1)
				{
					win[n]++;
					lost[m]++;
				}
			}
			for(int i=1;i<=num;i++)
			{
				if(win[i]+lost[i]>0)
					System.out.printf("%.3f\n",(win[i]/(win[i]+lost[i]+0.0)));
				else
					System.out.println("-");
			}
			System.out.println();
		}
	}
	private static int f(char m,char n)
	{
		if(m=='p')
		{
			if(n=='s')
				return -1;
			if(n=='r')
				return 1;
			if(n=='p')
				return 0;
		}
		else
		if(m=='s')
		{
			if(n=='s')
				return 0;
			if(n=='r')
				return -1;
			if(n=='p')
				return 1;
		}
		else
		{
			if(n=='s')
				return 1;
			if(n=='r')
				return 0;
			if(n=='p')
				return -1;
		}
		return -2;
	}
}