import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter cout = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, m;
		String[] t = cin.readLine().split(" ");
		n = Integer.parseInt(t[0]);
		m = Integer.parseInt(t[1]);
		int[] sum = new int[n];
		Arrays.fill(sum, 1);
		int[] p = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = i;
		SegTree st = new SegTree(2 * n);
		for (int i = 0; i < n; i++)
			st.add(1);
		int gs = n;
		while (m-- != 0)
		{
			t = cin.readLine().split(" ");
			if (t.length == 3)
			{
				int a = Integer.parseInt(t[1]) - 1;
				int b = Integer.parseInt(t[2]) - 1;
				int af = getf(a, p);
				int bf = getf(b, p);
				if (af == bf)
					continue;
				gs--;
				if (sum[af] < sum[bf])
				{
					p[af] = bf;
					st.del(sum[af]);
					st.del(sum[bf]);
					sum[bf] += sum[af];
					st.add(sum[bf]);
				} else
				{
					p[bf] = af;
					st.del(sum[af]);
					st.del(sum[bf]);
					sum[af] += sum[bf];
					st.add(sum[af]);
				}
			} else
			{
				int k = Integer.parseInt(t[1]);
				int d = st.getTheKthNum(gs - k + 1);
				cout.write(d + "\n");
				
			}
		}
		cout.flush();
	}
	public static int getf(int ci, int[] p)
	{
		while (p[ci] != ci)
		{
			ci = p[ci];
		}
		return ci;
	}
}

class SegTree
{
	int[] tree;
	int right;
	public SegTree(int right)
	{
		this.right = right;
		tree = new int[right * 2 + 2];
	}
	public void del(int d)
	{
		del(1, right, 1, d);
	}
	private void del(int left, int right, int node, int d)
	{
		tree[node]--;
		if (left == right)
			return;
		int mid = (left + right) / 2;
		if (d <= mid)
			del(left, mid, node * 2, d);
		else
			del(mid + 1, right, node * 2 + 1, d);
	}
	public void add(int d)
	{
		add(1, right, 1, d);
	}
	private void add(int left, int right, int node, int d)
	{
		tree[node]++;
		if (left == right)
			return;
		int mid = (left + right) / 2;
		if (d <= mid)
		{
			add(left, mid, node * 2, d);
		} else
			add(mid + 1, right, node * 2 + 1, d);
	}
	public int getTheKthNum(int k)
	{
		return getTheKthNum(1, right, 1, k);
	}
	private int getTheKthNum(int left, int right, int node, int k)
	{
		if (tree[node] < k)
			return -1;
		if (left == right)
			return left;
		int ln = tree[node * 2];
		int rn = tree[node * 2 + 1];
		int mid = (left + right) / 2;
		if (ln >= k)
			return getTheKthNum(left, mid, node * 2, k);
		else
			return getTheKthNum(mid + 1, right, node * 2 + 1, k - ln);
	}
}
