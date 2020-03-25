import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int p,t;
		p=cin.nextInt();
		t=cin.nextInt();
		People [] ps=new People[p];
		for(int i=0;i<p;i++)
			ps[i]=new People();
		while(cin.hasNextInt())
		{
			int i=cin.nextInt()-1;
			int j=cin.nextInt();
			ps[i].add(j);
			
		}
		int num=0;
		for(int i=0;i<p-1;i++)
			for(int j=i+1;j<p;j++)
			{
				if(ps[i].equals(ps[j]))
					num++;
			}
		System.out.println(p-num);

	}
}
class People
{
	public HashSet<Integer> trees=new HashSet<Integer>();
	public void add(int x)
	{
		trees.add(x);
	}
	public boolean equals(Object o)
	{
		People t=(People)o;
		return trees.equals(t.trees);
	}
	
}
