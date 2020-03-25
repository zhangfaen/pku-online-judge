import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{


	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String s=cin.readLine();
			int n=Integer.parseInt(s);
			if(n==0)break;
			int [] p=new int[n];
			for(int i=0;i<n;i++)
				p[i]=Integer.parseInt(cin.readLine());
			int cnt=0;
			while(check(p)==false)
			{
				int [] q=new int[n];
				for(int i=0;i<n;i++)
					q[i]=p[i]/2;
				for(int i=0;i<n-1;i++)
					p[i]=p[i]+q[i+1]-q[i];
				p[n-1]=p[n-1]+q[0]-q[n-1];
				for(int i=0;i<n;i++)
					if(p[i]%2==1)p[i]++;
				cnt++;
			}
			System.out.println(cnt+" "+p[0]);
		}
		out.flush();
		out.close();
	}
	public static boolean check(int [] p)
	{
		for(int i=1;i<p.length;i++)
			if(p[i]!=p[0])return false;
		return true;
	}

	
}