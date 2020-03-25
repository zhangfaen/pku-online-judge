import java.io.*;
public class Main
{
	static int MAX = 250000;
	static Node[] tree = new Node[MAX];
	static int L, T, O;
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" +");
		L = Integer.parseInt(s[0]);
		T = Integer.parseInt(s[1]);
		O = Integer.parseInt(s[2]);
		tree[1] = new Node(1, L, 2);
		while(O--!=0)
		{
			String st=br.readLine();
			String [] sta=st.split(" +");
			int x=Integer.parseInt(sta[1]);
			int y=Integer.parseInt(sta[2]);
			if(x>y)
			{
				int tt=x;x=y;y=tt;
			}
			if(sta[0].equals("C"))
				set(1,x,y,1<<(Integer.parseInt(sta[3])));
			else
				System.out.println(getFromBit(get(1,x,y));
			
		}	
	}
	public static void set(int cur, int a, int b, int tc)
	{
		if (tree[cur].color == tc)
			return;
		if (tree[cur].x == a && tree[cur].y == b)
		{
			tree[cur].color = tc;
			return;
		}
		if (tree[cur].color != 0)
		{
			tree[cur * 2] = new Node(tree[cur].x, tree[cur].mid,
				tree[cur].color);
			tree[cur * 2 + 1] = new Node(tree[cur].mid + 1, tree[cur].y,
				tree[cur].color);
			tree[cur].color = 0;
		}
		if (a >= tree[cur].mid + 1)
			set(cur * 2 + 1, a, b, tc);
		if (b <= tree[cur].mid)
			set(cur * 2, a, b, tc);
		if (a <= tree[cur].mid && b >= tree[cur].mid + 1)
		{
			set(cur * 2 + 1, tree[cur].mid + 1, b, tc);
			set(cur * 2, a, tree[cur].mid, tc);
		}
	}
	public static int get(int cur,int a,int b)
	{
		if(tree[cur].color!=0)
			return tree[cur].color;
		if(a>=tree[cur].mid+1)
			return get(cur*2+1,a,b);
		if(b<=tree[cur].mid)
			return get(cur*2,a,b);
		if(a<=tree[cur].mid&&b>=tree[cur].mid+1)
		{
			int t1=get(cur*2,a,tree[cur].mid);
			int t2=get(cur*2+1,tree[cur].mid+1,b);
			return t1|t2;
		}
		return -1;
		
	}
	public static int getFromBit(int a)
	{
		int re=0;
		for(int i=1;i<=T;i++)
			if((1<<i&a)!=0)
				re++;
		return re;
	}
}

class Node
{
	int x, y, mid, color;
	public Node(int a, int b, int c)
	{
		x = a;
		y = b;
		color = c;
		mid = (x + y) / 2;
	}
}
