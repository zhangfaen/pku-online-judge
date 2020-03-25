import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class Main
{
	static char[] sc;
	static char[] tc;
	static HashMap<String, Byte> hsb = new HashMap<String, Byte>(10000);
	public static void main(String[] args) throws IOException
	{
		//Scanner cin = new Scanner(new File("c:\\in.txt"));
		//BufferedReader br=new BufferedReader(new FileReader(new File("c:\\in.txt")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int L,T,O;
		String [] s=br.readLine().split(" +");
		L=Integer.parseInt(s[0]);T=Integer.parseInt(s[1]);O=Integer.parseInt(s[2]);
		LineTree tree=new LineTree(1,L);
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
			{
				int ct=Integer.parseInt(sta[3]);	
				tree.set(x,y,ct);
				//tree.print(tree.root);
				//System.out.println();
			}
			else
			{
				int re=tree.get(x,y);
				System.out.println(re);
				
			}
		}	
	}
}
class LineTree
{
	Node root;
	public LineTree(int a,int b)
	{
		root=make(a,b);
	}
	public int get(int a,int b)
	{
		int re= root.get(a,b);
		int sum=0;
		for(int i=1;i<31;i++)
		{
			if(((1<<i)&re)!=0)
				sum++;
		}
		return sum;
	}
	public void set(int a,int b,int col)
	{
		col=1<<col;
		root.set(a,b,col);
	}
	private Node make(int a,int b)
	{
		
		Node node=new Node(a,b,2);
		if(a==b)
			return node;
		int mid=(a+b)/2;
		node.left=make(a,mid);
		node.right=make(mid+1,b);
		return node;
	}
	public void print(Node node)
	{
		if(node.x==node.y)
		{
			node.print();
			return;
		}
		print(node.left);
		print(node.right);
			
	}
}
class Node
{
	int x,y,color,mid;
	Node left,right;
	public Node(int x,int y,int color)
	{
		this.x=x;
		this.y=y;
		this.color=color;
		mid=(x+y)/2;
	}
	public void set(int a,int b,int col)
	{
		if(x==y)
		{
			color=col;
			return;
		}
		if(a==x&&b==y)
		{
			color=col;
			left.set(a,mid,col);
			right.set(mid+1,b,col);
		}
		if(a>=mid+1)
		{
			color=this.get(x,a-1)|col;
			right.set(a,b,col);
		}
		if(b<=mid)
		{
			color=this.get(b+1,y)|col;
			left.set(a,b,col);
		}
		if(a<=mid&&b>=mid+1)
		{
			color=this.get(x,a-1)|this.get(b+1,y)|col;
			left.set(a,mid,col);
			right.set(mid+1,b,col);
		}
	}
	public int get(int a,int b)
	{
		if(a>b)
			return 0;
		if(x==y)
			return color;
		if(a==x&&b==y)
		{
			return color;
		}
		if(a>=mid+1)
		{
			return right.get(a,b);
		}else
		if(b<=mid)
		{
			return left.get(a,b);
		}else
		if(a<=mid&&b>=mid+1)
		{
			int tl=left.get(a,mid);
			int tr=right.get(mid+1,b);
			return tl|tr;
		}
		return -1;
	}
	public void print()
	{
		for(int i=1;i<31;i++)
		{
			if((color&(1<<i))!=0)
				System.out.print(" *"+x+y+i);
		}
	}
	
}
