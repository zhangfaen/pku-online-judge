import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int speed=cin.nextInt();
		int time=cin.nextInt()*60;
		ArrayList<Point> ap=new ArrayList<Point>();
		while(cin.hasNextDouble())
		{
			double x=cin.nextDouble();
			double y=cin.nextDouble();
			ap.add(new Point(x,y));
		}
		boolean [][] map=new boolean[ap.size()][ap.size()];
		
		int n=ap.size();
		for(int i=0;i<ap.size()-1;i++)
			for(int j=i+1;j<ap.size();j++)
			{
				if(isOk(ap.get(i),ap.get(j),time,speed))
					map[i][j]=map[j][i]=true;
			}
		LinkedList<Integer> lp=new LinkedList<Integer>();
		int [] tag=new int[n];
		lp.add(0);
		tag[0]=1;
	//	System.out.println(map[3][1]);
		while(lp.size()>0)
		{
			int cur=lp.removeFirst();
		//	System.out.println(cur);
			for(int i=0;i<n;i++)
			{
				if(map[cur][i]&&tag[i]==0)
				{
					lp.add(i);
					tag[i]=tag[cur]+1;
				}
			}
		}
		if(tag[1]==0)
			System.out.println("No.");
		else
			System.out.println("Yes, visiting "+(tag[1]-2)+" other holes.");
		
	}
	static boolean isOk(Point a,Point b,int time,int speed)
	{
		double dis=Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
		if(dis/speed<=time)
			return true;
		return false;
	}

}
class Point
{
	double x,y;
	public Point(double a,double b)
	{
		x=a;
		y=b;
	}
	
}