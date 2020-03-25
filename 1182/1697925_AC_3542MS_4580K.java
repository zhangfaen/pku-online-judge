

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	static int SIZE= 50010;

	static int [] nd=new int[SIZE];
	static int []st=new int[SIZE];
	static int D, X, Y, cnt, hdX, hdY, N, K;
	static void init()
	{
		int i;
		cnt = 0;
		for (i = 0; i <= N; i++)
		{
			nd[i] = st[i] = 0;
		}
	}

	static int get_id(int x)
	{
		int root;
		if (nd[x] == 0)
		{
			st[x] = 0;
			return x;
		}

		root = get_id(nd[x]);
		st[x] = (st[x] + st[nd[x]]) % 3;
		nd[x] = root;
		return root;
	}

	public static void main(String [] args)throws Exception
	{
		int i;
		BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
		String s = cin.readLine();
		String [] sa=s.split(" ");
		int n,m;
		N=Integer.parseInt(sa[0]);
		K=Integer.parseInt(sa[1]);
		init();
		for (i = 0; i < K; i++)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int D=Integer.parseInt(sa[0]);
			int X=Integer.parseInt(sa[1]);
			int Y=Integer.parseInt(sa[2]);
			if (X > N || Y > N)
			{
				cnt++;
				continue;
			}
			if (X == Y && D == 2)
			{
				cnt++;
				continue;
			}
			hdX = get_id(X);
			hdY = get_id(Y);
			if (hdX != hdY)
			{
				nd[hdY] = hdX;
				st[hdY] = (st[X] + D + 2 - st[Y]) % 3;
			}
			else
			{
				if((st[Y] - st[X] + 3) % 3 != D - 1)
				{
					cnt++;
				}
			}
		}
		System.out.printf("%d\n", cnt);
	}
}
