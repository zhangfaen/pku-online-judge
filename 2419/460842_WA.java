import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int p=cin.nextInt();
		int t=cin.nextInt();
		ArrayList [] ps=new ArrayList[p];
		for(int i=0;i<p;i++)
			ps[i]=new ArrayList<Integer>();
		while(cin.hasNextInt())
		{
			int i,j;
			i=cin.nextInt();
			i--;
			j=cin.nextInt();
			ps[i].add(j);
		}
		for(int i=0;i<p;i++)
		{
			Collections.sort(ps[i]);
		}
		Set< ArrayList > num=new HashSet<ArrayList>();
		for(int i=0;i<p;i++)
			num.add(ps[i]);
		System.out.println(num.size()-1);
	}
}
