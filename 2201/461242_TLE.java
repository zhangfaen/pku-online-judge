import java.io.*;
import java.util.*;
public class Main
{
	private static KA [] output;
	private static int flag=0;
	public static void main(String [] args)throws Exception
	{
		System.out.println("YES");
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		KA [] input=new KA[n];
		output=new KA[n];
		for(int i=1;i<=n;i++)
		{
			input[i-1]=new KA(i,cin.nextInt(),cin.nextInt());
		}
		Arrays.sort(input);
		KATree kaTree=new KATree(input[0]);
		KATree.output=output;
		for(int i=1;i<n;i++)
			kaTree.add(input[i]);
		kaTree.pre();
		Arrays.sort(output,new Comparator()
			{
				public int compare(Object a,Object b)
				{
					KA ta=(KA)a;
					KA tb=(KA)b;
					if(ta.index<tb.index)return -1;
					if(ta.index>tb.index)return 1;
					return 0;
				}
				
			});
		for(int i=0;i<n;i++)
		{
			if(output[i].parent==null)
				System.out.print(0);
			else
				System.out.print(output[i].parent.index);
			System.out.print(" ");
			
			if(output[i].left==null)
				System.out.print(0);
			else
				System.out.print(output[i].left.index);
			System.out.print(" ");
			
			if(output[i].right==null)
				System.out.print(0);
			else
				System.out.print(output[i].right.index);
			System.out.println();
		}

	}
}
class KATree
{
	public static KA [] output;
	private static int flag=0;
	KA root=null;
	public KATree(KA root)
	{
		this.root=root;
	}
	public void add(KA t)
	{
		
		KA p=root,pf=root;
		while(p!=null)
		{
			pf=p;
			if(t.key>p.key)
			{			
				p=pf.right;
			}
			else
			{
				p=pf.left;
			}
		}
		if(t.key>pf.key)
			pf.right=t;
		else
			pf.left=t;
		t.parent=pf;
	}
	public void pre()
	{
		preprint(root);
	}
	private void preprint(KA node)
	{
		if(node!=null)
		{
		//	System.out.println(node);
			output[flag++]=node;
			preprint(node.left);
			preprint(node.right);
		}
	}
}
class KA implements java.lang.Comparable
{
	public int index;
	public int key;
	public int auk;
	public KA left=null;
	public KA right=null;
	public KA parent=null;
	public KA(int index,int a,int b)
	{
		this.index=index;
		key=a;auk=b;
	}
	public int compareTo(Object o)
	{
		KA t=(KA)o;
		if(auk<t.auk)return -1;
		if(auk>t.auk)return 1;
		return 0;
	}
	public String toString()
	{
		return "["+index+" "+key+" "+auk+"]";
	}

}

