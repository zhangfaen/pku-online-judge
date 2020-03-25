import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int ts=cin.nextInt();
		while(ts-->0)
		{
			int m=cin.nextInt(),n=cin.nextInt();
			List<String> q=new LinkedList<String>();
			for(int i=0;i<m;i++)
				q.add(cin.next());
			String [] p=new String[m];
			boolean [] mve=new boolean[m];
			for(int i=0;i<n;i++)
			{
				int si=cin.nextInt()-1;
				int ti=cin.nextInt()-1;
				p[ti]=q.get(si);
				mve[si]=true;
			}
			int tag=0;
			for(int i=0;i<m;i++)
			{
				if(p[i]!=null)
				{	
					System.out.print(p[i]+" ");
				}
				else
				{
					while(mve[tag]==true)tag++;
					System.out.print(q.get(tag++)+" ");
				}
			}
			System.out.println();
		}
	}
}
