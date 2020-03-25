import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{


	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String s=cin.readLine();
			String [] sa=s.split(" ");
			int t1=Integer.parseInt(sa[0]);
			int t2=Integer.parseInt(sa[1]);
			int a=Math.min(t1, t2);
			int b=Math.max(t1, t2);
			if(a+b==0)break;
			int [] pb=get(b);
			int [] pa=get(a-1);
			for(int i=0;i<10;i++)
				pb[i]-=pa[i];
			for(int i=0;i<10;i++)
				System.out.print(pb[i]+" ");
			System.out.println();
		}
		out.flush();
		out.close();
	}
	public static int [] get(int n)
	{
		int [] p=new int[10];
		if(n==0)return p;
		char [] ca=(""+n).toCharArray();
		for(int i=0;i<ca.length;i++)
		{
			String right="0";
			String left="0";
			for(int j=0;j<i;j++)
				right+=ca[j];
			for(int j=i+1;j<ca.length;j++)
				left+=ca[j];
			int ri=Integer.parseInt(right);
			int li=Integer.parseInt(left);
			int fac=(int)Math.pow(10, left.length()-1);
			for(int j=0;j<10;j++)
				p[j]+=ri*fac;
			if(ri>0)p[0]-=fac;
			int j=1;
			if(ri!=0)
				j=0;
			for(;j<ca[i]-'0';j++)
			{
				p[j]+=fac;
			}
			p[ca[i]-'0']+=li+1;
		}
		return p;
	}
	public static boolean check(int [] p)
	{
		for(int i=1;i<p.length;i++)
			if(p[i]!=p[0])return false;
		return true;
	}

	
}