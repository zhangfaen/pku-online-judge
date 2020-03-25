import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		int testcase=cin.nextInt();
		while(testcase--!=0)
		{
			int n=cin.nextInt();
			String [] sp=new String[2*n];
			int min=1000;
			String mins=null;
			for(int i=0;i<n;i++)
			{
				String s=cin.next();
				String t=new StringBuffer(s).reverse().toString();
				if(s.length()<min)
				{
					min=s.length();
					mins=s;
				}
				sp[i]=s;
				sp[i+n]=t;
			}
			boolean bb=true;
			tag:for(int i=min;i>=1;i--)
			{
				for(int j=0;j+i<=mins.length();j++)
				{
					String sub=mins.substring(j,j+i);
					boolean isok=true;
					for(int k=0;k<n;k++)
					{
						if(sp[k].indexOf(sub)<0&&sp[k+n].indexOf(sub)<0)
						{
							isok=false;
							break;
						}
					}
					if(isok)
					{
						System.out.println(i);
						bb=false;
						break tag;
					}
				}
			}
			if(bb)
				System.out.println(0);
		}
	}
}
