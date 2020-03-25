import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		String [] sa=null;
		int tc=Integer.parseInt(in.readLine());
		out:while(tc--!=0)
		{
			s=in.readLine();
			sa=s.split(" ");
			int N=Integer.parseInt(sa[0]);
			int S=Integer.parseInt(sa[1]);
			int [] p=new int[N];
			s=in.readLine();
			sa=s.split(" ");
			for(int i=0;i<N;i++)
				p[i]=Integer.parseInt(sa[i]);
			Arrays.sort(p);
			int sum=0;
			for(int j=N-1;j>=0;j--)
			{
				sum+=p[j];
				if(sum>=S)
				{
					System.out.println(N-j);
					continue out;
				}
			}
			System.out.println(0);
		}
		
	}
	
	
}