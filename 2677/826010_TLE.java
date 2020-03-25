import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			LinkedList<Point> lp=new LinkedList<Point>();
			Point start=new Point(cin.nextInt(),cin.nextInt());
			for(int i=1;i<n;i++)
				lp.add(new Point(cin.nextInt(),cin.nextInt()));
			double min=Double.MAX_VALUE;
			for(int i=0;i<lp.size();i++)
			{
				Point tp=lp.get(i);
			lp.remove(tp);
			double tmin=Point.dis(start,tp)+g(tp,lp,start);
			lp.add(i,tp);
				if(min>tmin)
					min=tmin;
			}
			System.out.printf("%.2f\n",(min+0.005));
		}
	}
	public static double g(Point k,LinkedList<Point> lp,Point start)
	{
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
		return min;
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
}