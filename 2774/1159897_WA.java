import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		String s=cin.next();
		String t=cin.next();
		Ele.s=s+"$";
		Ele.t=t+"$";
		Ele [] p=new Ele[s.length()+t.length()+2];
		int tag=0;
		for(int i=0;i<=s.length();i++)
			p[tag++]=new Ele(i,1);
		for(int j=0;j<=t.length();j++)
			p[tag++]=new Ele(j,2);
		Arrays.sort(p);
		//System.out.println(Arrays.toString(p));
		int max=0;
		tag=1;
		Ele cur=p[0];
		while(tag<p.length)
		{
			if(p[tag].who!=cur.who)
			{
				int tre=cur.get(p[tag]);
				if(tre>max)
					max=tre;
				cur=p[tag];
			}
			tag++;
		}
		System.out.println(max);
	}
	
}
class Ele implements Comparable<Ele>
{
	static String s;
	static String t;
	int index;
	int who;
	public Ele(int a,int b)
	{
		index=a;
		who=b;
	}
	public int compareTo(Ele o)
	{
		if(who==o.who&&index==o.index)
			return 0;
		String ts=who==1?s:t;
		String tt=o.who==1?s:t;
		int index1=index;
		int index2=o.index;
		while(index1<ts.length()&&index2<tt.length())
		{
			if(ts.charAt(index1)<tt.charAt(index2))
				return -1;
			else
				if(ts.charAt(index1)>tt.charAt(index2))
				return 1;
			++index1;
			++index2;
		}
		return ts.length()-tt.length();
	}
	public int get(Ele o)
	{
		String ts=who==1?s:t;
		String tt=o.who==1?s:t;
		int index1=index;
		int index2=o.index;
		int re=0;
		while(index1<ts.length()-1&&index2<tt.length()-1)
		{
			if(ts.charAt(index1)==tt.charAt(index2))
				re++;
			else
				break;
			index1++;
			index2++;
		}
		return re;
	}
	public String toString()
	{
		String ts=who==1?s:t;
		return ts.substring(index)+" "+who;
	}
}

