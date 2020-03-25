import java.io.File;
import java.util.LinkedList;
import java.util.*;
import java.util.Scanner;
public class Main
{

	static HashMap<Integer,Node> tree;
	static boolean [] tag;
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int cs=cin.nextInt();
		while(cs--!=0)
		{
			
			int n=cin.nextInt();
			int [] lx=new int[n];
			int [] ly=new int[n];
			int size=0;
			for(int i=0;i<n;i++)
			{
				lx[i]=cin.nextInt();
				ly[i]=cin.nextInt();
				if(ly[i]>size)
					size=ly[i];
			}
			tag=new boolean[n+1];
			tree=new HashMap<Integer,Node>(5000000);
			tree.put(1,new Node(1,size,0));
			for(int i=0;i<n;i++)
			{
				set(1,lx[i],ly[i],i+1);
			}
			get(1);
			int sum=0;
			for(int i=1;i<tag.length;i++)
				if(tag[i])
					sum++;
			
			System.out.println(sum);
		}
	}
	public static void get(int cur)
	{
		if(tree.get(cur).ln>=0)
		{
			tag[tree.get(cur).ln]=true;
			return;
		}
		get(cur*2);
		get(cur*2+1);
	}
	public static void set(int cur,int a,int b,int num)
	{
		if(tree.get(cur).x==a&&tree.get(cur).y==b)
		{
			tree.get(cur).ln=num;
			return ;
		}
		if(tree.get(cur).ln>=0)
		{
			tree.put(cur*2,new Node(tree.get(cur).x,tree.get(cur).mid,tree.get(cur).ln));
			tree.put(cur*2+1,new Node(tree.get(cur).mid+1,tree.get(cur).y,tree.get(cur).ln));
			tree.get(cur).ln=-1;
		}
		
		if(b<=tree.get(cur).mid)
		{
			
			set(cur*2,a,b,num);
		}
		if(a>=tree.get(cur).mid+1)
		{
			set(cur*2+1,a,b,num);
		}
		if(a<=tree.get(cur).mid&&b>=tree.get(cur).mid+1)
		{
			set(cur*2,a,tree.get(cur).mid,num);
			set(cur*2+1,tree.get(cur).mid+1,b,num);
		}
	}
}
class Node
{
	int x,y,mid;
	int ln;
	public Node(int a,int b,int nln)
	{
		x=a;y=b;mid=(x+y)/2;
		ln=nln;
	}
}

