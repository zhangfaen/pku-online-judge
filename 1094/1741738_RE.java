import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main
{
	static boolean[][] map;
	static int n;
	static char [] p;
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		out:while (true)
		{
			String s = cin.readLine();
			String[] sa = s.split(" ");
			n = Integer.parseInt(sa[0]);
			int m = Integer.parseInt(sa[1]);
			if (n + m == 0)
				break;
			map = new boolean[n][n];
			p=new char[n];
			for(int i=1;i<=m;i++)
			{
				s=cin.readLine();
				char c0=s.charAt(0),c2=s.charAt(2);
				map[c0-'A'][c2-'A']=true;
				int re=sort();
				if(re==1)
				{
					System.out.println("Sorted sequence determined after "+i+" relations: "+new String(p)+".");
					for(int j=i+1;j<=m;j++)
						cin.readLine();
					continue out;
				}
				else
					if(re==-1)
					{
						System.out.println("Inconsistency found after "+i+" relations.");
						continue out;
					}
			}
			System.out.println("Sorted sequence cannot be determined.");
		}
	}
	// 0: not determin
	// -1: contradict
	public static int sort()
	{
		int[] into = new int[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (map[i][j])
					into[j]++;
		int tag = 0;
		boolean determined = true;
		while (tag < n)
		{
			boolean find = false;
			int next=-1;
			for (int i = 0; i < n; i++)
			{
				if (into[i] == 0)
				{
					if (find == false)
					{
						find = true;
						next=i;
					}
					else
					{
						determined=false;
					}
					
				}
			}
			if(find==false)
			{
				return -1;//contradict
			}
			into[next]=-1;
			p[tag++]=(char)('A'+next);
			for(int i=0;i<n;i++)
				if(map[next][i])
					into[i]--;
		}
		if(determined)
			return 1;//ok
		return 0;//not determin
	}
}