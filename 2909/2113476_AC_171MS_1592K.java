import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main
{
	static int n, m;
	static char[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		boolean[] isP = new boolean[1 << 15];
		Arrays.fill(isP,true);
		for(int i=2;i<(1<<15);i++)
		{
			if(isP[i])
			{
				for(int j=i*i;j<(1<<15);j+=i)
				{
					isP[j]=false;
				}
			}
		}
		List<Integer>ps=new ArrayList<Integer>(100000);
		for(int i=2;i<(1<<15);i++)
			if(isP[i])
				ps.add(i);
		while (true)
		{
			String s = cin.readLine();
			int n = Integer.parseInt(s);
			if (n == 0)
				break;
			int res=0;
			for(int i=0;i<ps.size();i++)
			{
				if(ps.get(i)<n/2)
				{
					int fi=Collections.binarySearch(ps, n-ps.get(i));
					if(fi>=0)
						res++;
				}
			}
			if(isP[n/2])
				res++;
			out.println(res);
		}
		out.flush();
		out.close();
	}
}