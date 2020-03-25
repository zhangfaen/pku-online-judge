import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception 
	{
		Scanner cin=new Scanner(System.in);
		
		int n,m;
		List list=new ArrayList();
		n=cin.nextInt();
		m=cin.nextInt();
		for(int i=0;i<m;i++)
		{
			list.add(new DNA(cin.next()));
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		
	}
}
class DNA implements java.lang.Comparable
{
	public String s;
	public int num;
	public DNA(String t)
	{
		s=t;
		int n=0;
		for(int i=0;i<t.length()-1;i++)
			for(int j=i+1;j<t.length();j++)
			{
				if(t.charAt(i)>t.charAt(j))
					n++;
			}
		num=n;
	}
	public int compareTo(Object o)
	{
		DNA temp=(DNA)o;
		if(num<temp.num)
			return -1;
		if(num==temp.num)
			return 0;
		if(num>temp.num)
			return 1;
		return 0;
	}  
	public String toString()
	{
		return s;
	}
	
}