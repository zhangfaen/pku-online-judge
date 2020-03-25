import java.util.*;
import java.io.*;
public class Main
{
	@SuppressWarnings("unchecked")
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int testcase=cin.nextInt();
		while(testcase--!=0)
		{
			int n=cin.nextInt();
			List<Wood> lw=new ArrayList<Wood>();
			for(int i=0;i<n;i++)
			{
				lw.add(new Wood(cin.nextInt(),cin.nextInt()));
			}
			Collections.sort(lw,new Comparator(){
				public int compare(Object o1,Object o2)
				{
					Wood w1=(Wood)o1;
					Wood w2=(Wood)o2;
					if(w1.x<w2.x) return -1;
					if(w1.x>w2.x) return 1;
					if(w1.y<w2.y) return -1;
					if(w1.y>w2.y) return 1;
					return 0;
				}
			});
			int sum=0;
			while(lw.size()>0)
			{
				sum++;
				Wood cur=lw.remove(0);
				for(int i=0;i<lw.size();i++)
				{
					Wood t=lw.get(i);
					if(isLow(cur,t))
					{
						cur=lw.remove(i);
						i--;
						continue;
					}
				}
				
			}
			System.out.println(sum);
		}
	}
	public static boolean isLow(Wood w1,Wood w2)
	{
		return w1.x<=w2.x&&w1.y<=w2.y;
	}
}

class Wood
{
	int x,y;
	public Wood(int a,int b)
	{
		x=a;
		y=b;
	}
	public String toString()
	{
		return "x="+x+" ;y="+y;
	}
}
