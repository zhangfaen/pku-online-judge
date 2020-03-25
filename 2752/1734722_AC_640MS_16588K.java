import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		while(true)
		{
			String s=in.readLine();
			if(s==null)
				break;
			int [] pi=KMP.getPI(s);
			
			int [] re=new int[s.length()+1];
			int tag=0;
			re[tag++]=s.length();
			int cur=s.length();
			while(true)
			{
				if(pi[cur]==0)
					break;
				re[tag++]=pi[cur];
				cur=pi[cur];
			}
			for(int i=tag-1;i>=0;i--)
				out.print(re[i]+" ");
			out.println();
		}
		
		out.flush();
	}
}
class KMP
{
	public static int match(String text,String pattern)
	{
		int n=text.length();
		int m=pattern.length();
		int [] pi=getPI(pattern);
		int q=0;
		for(int i=1;i<=n;i++)
		{
			while(q>0&&pattern.charAt(q)!=text.charAt(i-1))
				q=pi[q];
			if(pattern.charAt(q)==text.charAt(i-1))
				q++;
			if(q==m)
			{
				System.out.println("find it at index:"+(i-m));
				q=pi[q];
			}
		}
		return 0;
	}
	public static int [] getPI(String pattern)
	{
		int m=pattern.length();
		int [] re=new int[m+1];
		int k=0;
		for(int q=2;q<=m;q++)
		{
			while(k>0&&pattern.charAt(k)!=pattern.charAt(q-1))
				k=re[k];
			if(pattern.charAt(k)==pattern.charAt(q-1))
				k++;
			re[q]=k;
		}
		return re;
	}
}