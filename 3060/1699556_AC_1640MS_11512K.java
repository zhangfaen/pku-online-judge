import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
public class Main
{
	static int [][] p;
	static long BASE=1000000000;
	static int [] xkill;
	static int [] ykill;
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s=cin.readLine();
		int ts=Integer.parseInt(s);
		String [] sa=null;
		while(ts--!=0)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int D=Integer.parseInt(sa[0]);
			int N=Integer.parseInt(sa[1]);
			p=new int[D][D];
			xkill=new int[D];
			ykill=new int[D];
			for(int i=0;i<N;i++)
			{
				s=cin.readLine();
				sa=s.split(" ");
				long x=Long.parseLong(sa[0])+BASE;
				long y=Long.parseLong(sa[1])+BASE;
				int xs=(int)(x%D);int ys=(int)(y%D);
				xkill[xs]++;
				ykill[ys]++;
				p[xs][ys]++;
			}
			int re=N;
			for(int i=0;i<D;i++)
				for(int j=0;j<D;j++)
				{
					int d=xkill[i]+ykill[j]-p[i][j];
					re=Math.min(re, d);
				}
			System.out.println(re);
		}
		out.flush();
	}

}