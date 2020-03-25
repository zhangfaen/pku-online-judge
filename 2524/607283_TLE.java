import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int cases=0;
		while(true)
		{
			int n=cin.nextInt();
			int m=cin.nextInt();
			if(n+m==0)
				break;
			cases++;
			List<HashSet<Integer> > list=new ArrayList<HashSet<Integer> >();
			for(int j=0;j<m;j++)
			{
				int a=cin.nextInt();
				int b=cin.nextInt();
				boolean find=false;
				for(int i=0;i<list.size();i++)
				{
					HashSet<Integer> tset=list.get(i);
					if(tset.contains(a))
					{
						find=true;
						tset.add(b);
					}
					else
						if(tset.contains(b))
						{
							find=true;
							tset.add(a);
						}
						
				}
				if(find==false)
				{
					HashSet<Integer> tset=new HashSet<Integer>();
					tset.add(a);
					tset.add(b);
					list.add(tset);
				}
			}
			int sum=0;
			for(int j=0;j<list.size();j++)
			{
				sum+=((HashSet)(list.get(j))).size();
			}
			int r=n-sum+list.size();
			System.out.println("Case "+cases+": "+r);
		}
	}
}