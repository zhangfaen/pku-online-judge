import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] arsg)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n;
		while(true)
		{
			LinkedList<Cor> king=new LinkedList<Cor>();
			king.add(new Cor(Integer.MIN_VALUE,Integer.MIN_VALUE));
			n=cin.nextInt();
			if(n==0)break;
			for(int i=0;i<n;i++)
			{
				int x,y;
				x=cin.nextInt();
				y=cin.nextInt();
				Cor t=new Cor(x,y);
				boolean tag=false;
				for(int j=0;j<king.size();j++)
				{
					if(t.compareTo(king.get(j))<0)
						break;
					if(t.compareTo(king.get(j))>0)
					{
						king.remove(j);
						tag=true;
						j=-1;
						continue;
					}
					if(t.compareTo(king.get(j))==0)
					{
						if(j==king.size()-1)
						{
							king.add(t);
							break;
						}
					}
				}
				if(tag)
					king.add(t);
			}
			System.out.println(king.size());
		
		}
		
	}
}
class Cor implements Comparable
{
	public int x;
	public int y;
	public Cor(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int compareTo(Object o)
	{
		Cor t=(Cor)o;
		if(x>t.x&&y>t.y)
			return 1;
		if(x==t.x&&y>t.y)
			return 1;
		if(x>t.x&&y==t.y)
			return 1;
		if(t.x>x&&t.y<y)
			return 0;
		if(t.x<x&&t.y>y)
			return 0;
		if(t.x==x&&t.y==y)
			return 0;
		return -1;
	}
}