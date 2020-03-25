import java.io.*;
import java.util.*;
public class Main
{
	private static HashMap<String,Double> hmsd;
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			hmsd=new HashMap<String,Double>();
			LinkedList<Point> lp=new LinkedList<Point>();
			Point start=new Point(cin.nextInt(),cin.nextInt());
			for(int i=1;i<n;i++)
				lp.add(new Point(cin.nextInt(),cin.nextInt()));
			double min=Double.MAX_VALUE;
		/*	for(int i=0;i<lp.size();i++)
			{
				Point tp=lp.get(i);
			lp.remove(tp);
			double tmin=Point.dis(start,tp)+g(tp,lp,start);
			lp.add(i,tp);
				if(min>tmin)
					min=tmin;
			}*/
		//	System.out.println(gets(start,lp));
			min=g(start,lp,start);
			System.out.printf("%.2f\n",(min+0.005));
		}
	}
	public static double g(Point k,LinkedList<Point> lp,Point start)
	{
		String ss=gets(k,lp);
		Double rr=hmsd.get(ss);
		if(rr!=null)
			return rr.doubleValue();
		if(lp.size()==0)
			return Point.dis(k,start);
		double min=Double.MAX_VALUE;
		for(int i=0;i<lp.size();i++)
		{
			Point tp=lp.get(i);
			lp.remove(tp);
			double tmin=Point.dis(k,tp)+g(tp,lp,start);
			lp.add(i,tp);
			if(min>tmin)
				min=tmin;
		}
		hmsd.put(ss,min);
		return min;
	}
	public static String gets(Point k,LinkedList<Point> lp)
	{
		StringBuffer sb=new StringBuffer(1000);
		sb.append(k);
		for(int i=0;i<lp.size();i++)
			sb.append(lp.get(i));
		return sb.toString();
		
	}
}
class Point
{
	int x,y;
	public Point(int a,int b)
	{
		x=a;
		y=b;
	}
	public static double dis(Point a,Point b)
	{
		return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}
	public boolean equals(Object o)
	{
		Point to=(Point)o;
		return x==to.x&&y==to.y;
	}
	public String toString()
	{
		return ""+x+y;
	}
}