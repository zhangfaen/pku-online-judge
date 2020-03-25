import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		ArrayList<Point> aps=new ArrayList<Point>(201);
		ArrayList<Line> hls=new ArrayList<Line>(n*n/2);
		for(int i=0;i<n;i++)
		{
			aps.add(new Point(cin.nextInt(),cin.nextInt()));
		}
		for(int i=0;i<aps.size()-1;i++)
		{
			for(int j=i+1;j<aps.size();j++)
			{
				hls.add(new Line(aps.get(i),aps.get(j)));
			}
		}
		int max=-1;
		for(int i=0;i<hls.size();i++)
		{
			int tmax=0;
			Line tl=hls.get(i);
			for(int j=0;j<aps.size();j++)
			{
				if(tl.isOnLine(aps.get(j)))
					tmax++;
			}
			if(tmax>max)
				max=tmax;
		}
		System.out.println(max);
	
		
	}
}
class Point
{
	int x,y;
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Line
{
	Point p1;
	Point p2;
	public Line(Point p1,Point p2)
	{
		this.p1=p1;
		this.p2=p2;
		
	}
	public boolean isOnLine(Point p)
	{
		if((p.y-p1.y)*(p2.x-p1.x)==(p.x-p1.x)*(p2.y-p1.y))
			return true;
		return false;
	}
	public boolean equals(Object o)
	{
		Line t=(Line)o;
		return false;
		
	}
	public int hashCode()
	{
		return 0;
	}
}