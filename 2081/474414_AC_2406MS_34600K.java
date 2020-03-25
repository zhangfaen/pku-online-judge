import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		ArrayList<Integer> ai=new ArrayList<Integer>();
		ai.add(0);
		HashSet<Integer> hi=new HashSet<Integer>();
		hi.add(0);
		for(int i=1;i<=500000;i++)
		{
			int t=ai.get(i-1);
			int d=t-i;
			if(d>0&&!hi.contains(d))
			{
				ai.add(d);
				hi.add(d);
			}
			else
			{
				ai.add(t+i);
				hi.add(t+i);
			}
		}
		while(true)
		{
			int n=cin.nextInt();
			if(n==-1)break;
			System.out.println(ai.get(n));

		}
	}
	
}

