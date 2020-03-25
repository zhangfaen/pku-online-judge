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
		String s=cin.readLine();
		int ts=Integer.parseInt(s);
		while(ts-->0)
		{
			s=cin.readLine();
			if(s==null)break;
			int n=Integer.parseInt(s);
			int [] p=new int[n+1];
			String [] sa=cin.readLine().split(" ");
			for(int i=1;i<n+1;i++)
			{
				p[i]=Integer.parseInt(sa[i-1]);
			}
			boolean [] vst=new boolean[n+1];
			int res=0;
			for(int i=1;i<=n;i++)
			{
				if(vst[i])continue;
				vst[i]=true;
				int cur=i;
				int cnt=0;
				while(vst[p[cur]]==false) {
					cur=p[cur];
					vst[cur]=true;
					cnt++;
				}
				res+=cnt;
			}
			out.println(res);
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