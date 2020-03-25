import java.io.*;
import java.util.*;
import java.lang.Math;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			ArrayList<Point> ap=new ArrayList<Point>(1006);
			ArrayList<Point> rp=new ArrayList<Point>(1006);
			rp.add(new Point(cin.nextInt(),cin.nextInt(),cin.nextInt()));
			for(int i=1;i<n;i++)
			{
				ap.add(new Point(cin.nextInt(),cin.nextInt(),cin.nextInt()));
			}
			long fenzi=0;
			double fenmu=0;
			int num=1;
			
			while(num<n)
			{
				double min=Double.MAX_VALUE;
				double tmin;
				int tagi=-1,tagj=-1;
				for(int i=0;i<rp.size();i++)
				{
					Point pw=rp.get(i);
					for(int j=0;j<ap.size();j++)
					{
						Point pn=ap.get(j);
						tmin=(fenzi+Point.ver_dis(pw,pn))/(fenmu+Point.hor_dis(pw,pn));
					//	System.out.println(tmin);
						if(tmin<min)
						{
							min=tmin;
							tagi=i;
							tagj=j;
						}
					}
				}
				fenzi+=Point.ver_dis(rp.get(tagi),ap.get(tagj));
				fenmu+=Point.hor_dis(rp.get(tagi),ap.get(tagj));
				rp.add(ap.remove(tagj));
				num++;
			}
			System.out.printf("%.3f\n",(fenzi)/(fenmu));
		}
	}
}
class Point
{
	int x,y,z;
	public Point(int a,int b,int c)
	{
		x=a;
		y=b;
		z=c;
	}
	public static double hor_dis(Point s,Point t)
	{
		return Math.sqrt((s.x-t.x)*(s.x-t.x)+(s.y-t.y)*(s.y-t.y));
	}
	public static int ver_dis(Point s,Point t)
	{
		return Math.abs(s.z-t.z);
	}
}