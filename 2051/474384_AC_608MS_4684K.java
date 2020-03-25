import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		ArrayList<R> ai=new ArrayList<R>();
		while(true)
		{
			String s=cin.next();
			if(s.equals("#"))
				break;
			ai.add(new R(cin.nextInt(),cin.nextInt()));
		}
		Collections.sort(ai);
		int k=cin.nextInt();
		for(int i=1;;i++)
		{
			for(int j=0;j<ai.size();j++)
				if(i%ai.get(j).inter==0)
				{
					System.out.println(ai.get(j).id);
					k--;
				}
			if(k==0)break;
		}
	}
}
class R implements Comparable
{
	public int id;
	public int inter;
	public R(int a,int b)
	{
		id=a;
		inter=b;
	}
	public int compareTo(Object t)
	{
		R tt=(R)t;
		if(id==tt.id)
			return 0;
		if(id<tt.id)
			return -1;
		return 1;
	}
}

