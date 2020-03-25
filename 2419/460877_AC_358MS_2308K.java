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
		Set<People> hp=new HashSet<People>();
		for(int i=0;i<p;i++)
			hp.add(ps[i]);
		System.out.println(hp.size());

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
	public int hashCode()
	{
		return trees.hashCode();
	}
	
}
