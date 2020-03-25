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
			ArrayList<Point> lp=new ArrayList<Point>();
			Point start=new Point(cin.nextInt(),cin.nextInt());
			for(int i=1;i<n;i++)
				lp.add(new Point(cin.nextInt(),cin.nextInt()));
			double min=Double.MAX_VALUE;
			for(int i=0;i<lp.size();i++)
			{
				ArrayList<Point> tlp=(ArrayList<Point>)lp.clone();
				tlp.remove(lp.get(i));
				double tmin=Point.dis(start,lp.get(i))+g(lp.get(i),tlp,start);
				if(min>tmin)
					min=tmin;
			}
			System.out.println(Math.round(min*100)/100.0);
		}
	}
	public static double g(Point k,ArrayList<Point> lp,Point start)
	{
		if(lp.size()==0)
			return Point.dis(k,start);
		double min=Double.MAX_VALUE;
		for(int i=0;i<lp.size();i++)
		{
			ArrayList<Point> tlp=(ArrayList<Point>)lp.clone();
			tlp.remove(lp.get(i));
			double tmin=Point.dis(k,lp.get(i))+g(lp.get(i),tlp,start);
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