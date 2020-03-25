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
			for(int i=0;i<n;i++)
				ap.add(new Point(cin.nextInt(),cin.nextInt(),cin.nextInt()));
			LenCost[][] map=new LenCost[n][n];
			for(int i=0;i<ap.size()-1;i++)
				for(int j=i+1;j<ap.size();j++)
				{
					map[j][i]=map[i][j]=new LenCost(Point.hor_dis(ap.get(i),ap.get(j)),Point.ver_dis(ap.get(i),ap.get(j)));
				}
			ArrayList<Integer> ais=new ArrayList<Integer>(1002);
			ArrayList<Integer> aie=new ArrayList<Integer>(1002);
			for(int j=1;j<n;j++)
				aie.add(j);
			ais.add(0);
			long fenzi=0;
			double fenmu=0;
			int num=1;
			
			while(ais.size()<n)
			{
				double min=Double.MAX_VALUE;
				double tmin;
				int tagi=-1,tagj=-1;
				for(int i=0;i<ais.size();i++)
				{
					for(int j=0;j<aie.size();j++)
					{
						tmin=(fenzi+map[ais.get(i)][aie.get(j)].cost)/(fenmu+map[ais.get(i)][aie.get(j)].len);
						if(tmin<min)
						{
							min=tmin;
							tagi=i;
							tagj=j;
						}
					}
				}
				fenzi+=map[ais.get(tagi)][aie.get(tagj)].cost;
				fenmu+=map[ais.get(tagi)][aie.get(tagj)].len;
				ais.add(aie.remove(tagj));
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

class LenCost
{
	double len;
	int cost;
	public LenCost(double t,int s)
	{
		len=t;
		cost=s;
	}
}