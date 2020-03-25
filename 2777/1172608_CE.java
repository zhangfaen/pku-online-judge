import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
public class Main
{
	static int MAXN = 100020;
	// #define ISCOVER(x) (x)
	static int INITCOLOR = 2;
	static int l, t, o;
	static int odder;
	static int a, b, c, temp;
	static int color;
	static class TreeNode
	{
		int color;
		int left;
		int right;
	};
	static TreeNode[] segtree = new TreeNode[MAXN * 4];
	static
	{
		for(int i=0;i<MAXN*4;i++)
			segtree[i]=new TreeNode();
	}
	static void initfill(int index, int a, int b)
	{
		segtree[index].color = INITCOLOR;
		if (a == b)
		{
			segtree[index].left = segtree[index].right = a;
			return;
		}
		int mid = (a + b) / 2;
		segtree[index].left = a;
		segtree[index].right = b;
		initfill(index * 2, a, mid);
		initfill(index * 2 + 1, mid + 1, b);
	}
	static void update(int index, int a, int b)
	{
		if (color == segtree[index].color)
			return;
		if (a == segtree[index].left && b == segtree[index].right)
		{
			segtree[index].color = color;
		} else
		{
			if ((segtree[index].color) != 0)
			{
				segtree[index * 2].color = segtree[index].color;
				segtree[index * 2 + 1].color = segtree[index].color;
			}
			segtree[index].color = 0;
			int mid = (segtree[index].left + segtree[index].right) / 2;
			if (a <= mid)
			{
				if (b < mid)
					update(index * 2, a, b);
				else
					update(index * 2, a, mid);
			}
			if (b > mid)
			{
				if (a > mid)
					update(index * 2 + 1, a, b);
				else
					update(index * 2 + 1, mid + 1, b);
			}
		}
	}
	static int getcolor(int index, int a, int b)
	{
		if (segtree[index].color != 0)
		{
			return segtree[index].color;
		}
		int result = 0;
		int mid = (segtree[index].left + segtree[index].right) / 2;
		if (a <= mid)
			result |= getcolor(index * 2, a, mid);
		if (b > mid)
			result |= getcolor(index * 2 + 1, mid + 1, b);
		return result;
	}
	static int getColorKindNum(int color)
	{
		int i;
		int result = 0;
		for (i = 1; i <= t; i++)
		{
			if ((color & (1 << i)) != 0)
				result++;
		}
		return result;
	}
	public static void main(String[] args) throws IOException
	{
		//BufferedReader br = new BufferedReader(new FileReader(new File(
			"c:\\in.txt")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i;
		String[] s = br.readLine().split(" +");
		l = Integer.parseInt(s[0]);
		t = Integer.parseInt(s[1]);
		o = Integer.parseInt(s[2]);
		initfill(1, 1, l);
		for (i = 0; i < o; i++)
		{
			String st = br.readLine();
			String[] sta = st.split(" +");
			int x = Integer.parseInt(sta[1]);
			int y = Integer.parseInt(sta[2]);
			if (x > y)
			{
				int tt = x;
				x = y;
				y = tt;
			}
			if (sta[0].equals("C"))
			{
				color = 1 << Integer.parseInt(sta[3]);
				update(1, a, b);
			} else
			{
				System.out.printf("%d\n", getColorKindNum(getcolor(1, a, b)));
			}
		}
	}
}
