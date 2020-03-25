import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)
				break;
			ArrayList<Cor> ac=new ArrayList<Cor>();
			int m=cin.nextInt();
			for(int i=0;i<m;i++)
			{
				ac.add(new Cor(cin.nextInt(),cin.nextInt()));
			}
			for(int i=1;i<=n;i++)
			{
				m=cin.nextInt();
				ArrayList<Cor> act=new ArrayList<Cor>();
				for(int j=0;j<m;j++)
				{
					act.add(new Cor(cin.nextInt(),cin.nextInt()));
				}
				if(isOk(ac,act)||isOk(ac,rever(act)))
					System.out.println(i);
			}
			System.out.println("+++++");
		}
	}
	public static ArrayList<Cor> rever(ArrayList<Cor> s)
	{
		ArrayList<Cor> re=new ArrayList<Cor>();
		for(int i=s.size()-1;i>=0;i--)
		{
			re.add(s.get(i));
		}
		return re;
	}
	public static boolean isOk(ArrayList<Cor> s,ArrayList<Cor> t)
	{
		if(s.size()!=t.size())
			return false;
		int cx=s.get(0).x-0;
		int cy=s.get(0).y-0;
		for(int i=0;i<s.size();i++)
			s.get(i).sub(cx,cy);
		cx=t.get(0).x-0;
		cy=t.get(0).y-0;
		for(int i=0;i<t.size();i++)
			t.get(i).sub(cx,cy);
		if(made(s,t))
			return true;
		for(int i=0;i<t.size();i++)
		{
			int x=t.get(i).x;
			int y=t.get(i).y;
			int nx,ny;
			nx=-y;
			ny=x;
			t.get(i).x=nx;
			t.get(i).y=ny;
		}
		if(made(s,t))
			return true;
		
		for(int i=0;i<t.size();i++)
		{
			int x=t.get(i).x;
			int y=t.get(i).y;
			int nx,ny;
			nx=-y;
			ny=x;
			t.get(i).x=nx;
			t.get(i).y=ny;
		}
		if(made(s,t))
			return true;
		
		for(int i=0;i<t.size();i++)
		{
			int x=t.get(i).x;
			int y=t.get(i).y;
			int nx,ny;
			nx=-y;
			ny=x;
			t.get(i).x=nx;
			t.get(i).y=ny;
		}
		if(made(s,t))
			return true;
		
		return false;
		
	}
	public static boolean made(ArrayList<Cor> s,ArrayList<Cor> t)
	{
		for(int i=0;i<s.size();i++)
		{
			if(!s.get(i).equals(t.get(i)))
				return false;
		}
		return true;
	}
}
class Cor
{
	public int x,y;
	public Cor(int a,int b)
	{
		x=a;
		y=b;
	}
	public void sub(int cx,int cy)
	{
		x-=cx;
		y-=cy;
	}
	public boolean equals(Cor c)
	{
		return x==c.x&&y==c.y;
	}
}
