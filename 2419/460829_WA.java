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
		String [] ps=new String[p];
		for(int i=0;i<p;i++)
			ps[i]="";
		while(cin.hasNextInt())
		{
			int i,j;
			i=cin.nextInt();
			i--;
			j=cin.nextInt();
			ps[i]=ps[i]+""+j;
		}
		for(int i=0;i<p;i++)
		{
			char [] ts=ps[i].toCharArray();
			Arrays.sort(ts);
			ps[i]=new String(ts);
		}
		HashSet<String> num=new HashSet<String>();
		for(int i=0;i<p;i++)
			num.add(ps[i]);
		System.out.println(num.size()-1);
	}
}
