import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
	
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		ArrayList<Si> asi=new ArrayList<Si>(10001);
		int total=0;
		while(cin.hasNext())
		{
			String s=cin.next();
			asi.add(new Si(s,total++));
		}
		Collections.sort(asi,new Comparator()
			{
				public int compare(Object xx,Object yy)
				{
					Si x=(Si)xx;
					Si y=(Si)yy;
					return x.s.compareTo(y.s);
				}
			});
		for(int i=1;i<total-1;i++)
		{
			String prefix=get(asi.get(i).s,asi.get(i-1).s,asi.get(i+1).s);
			asi.get(i).prefix=prefix;
		}
		asi.get(0).prefix=get(asi.get(0).s,"#",asi.get(1).s);
		asi.get(total-1).prefix=get(asi.get(total-1).s,"#",asi.get(total-2).s);
		Si [] rsi=new Si[total];
		for(int i=0;i<asi.size();i++)
			rsi[asi.get(i).id]=asi.get(i);
		for(int i=0;i<total;i++)
			System.out.println(rsi[i]);
	}
	private static String get(String x,String s,String t)
	{
		int lmax=0;
		int rmax=0;
		int i;
		for(i=0;i<x.length()&&i<s.length();i++)
		{
			if(x.charAt(i)==s.charAt(i))
				continue;
			else
			{
				lmax=i;
				break;
			}
		}
		if(i==x.length()||i==s.length())
		{
			if(x.length()<s.length())
				lmax=x.length()-1;
			else
				lmax=s.length();
		}
		for(i=0;i<x.length()&&i<t.length();i++)
		{
			if(x.charAt(i)==t.charAt(i))
				continue;
			else
			{
				rmax=i;
				break;
			}
		}
		if(i==x.length()||i==t.length())
		{
			if(x.length()<t.length())
				rmax=x.length()-1;
			else
				rmax=t.length();
		}
	//	System.out.println("###\n"+s+"\n"+x+"\n"+t+"\n"+"###");
	//	System.out.println(lmax+" "+rmax);
		return x.substring(0,rmax<lmax?lmax+1:rmax+1);
		
	}

	
}
class Si
{
	public String s;
	public int id;
	public String prefix=null;
	public Si(String s,int id)
	{
		this.s=s;
		this.id=id;
	}
	public String toString()
	{
		return s+" "+prefix;
	}
}

