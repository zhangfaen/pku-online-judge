
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int step=cin.nextInt();
			int mod=cin.nextInt();
			HashSet<Integer>hs=new HashSet<Integer>();
			hs.add(0);
			int t=0;
			boolean tag=false;
			while(hs.size()<mod)
			{
				int s=(t+step)%mod;
				if(hs.contains(s))
				{
				
					System.out.printf("%10d%10d     Bad Choice\n",step,mod);
					tag=true;
					break;
				}
				else
					hs.add(s);
				t=s;
			}
			if(tag==false)
			{
				System.out.printf("%10d%10d     Good Choice\n",step,mod);
			}
		}
	}
}