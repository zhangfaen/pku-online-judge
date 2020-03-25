import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		System.out.println("YES");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		KA [] input=new KA[n];
		KA [] output=new KA[n];
		for(int i=1;i<=n;i++)
		{
			String [] ss=br.readLine().split(" +");
			int t1=Integer.parseInt(ss[0]);
			int t2=Integer.parseInt(ss[1]);
			input[i-1]=new KA(i,t1,t2);
		}
		Arrays.sort(input);
		KATree kaTree=new KATree(input[0]);
		KATree.output=output;
		for(int i=1;i<n;i++)
			kaTree.add(input[i]);
			
		kaTree.pre();
		
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
				p=pf.right;
			else
				p=pf.left;
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
			output[node.index-1]=node;
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
	public KA(int c,int a,int b)
	{
		index=c;
		key=a;
		auk=b;
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
