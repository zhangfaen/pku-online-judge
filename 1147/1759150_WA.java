import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main
{
	public static void main(String [] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		String s=cin.readLine();
		int n=Integer.parseInt(s);
		char [] p=new char[n];
		char [] q=new char[n];
		s=cin.readLine().trim();
		String [] sa=s.split(" +");
		for(int i=0;i<n;i++)
		{
			p[i]=(char)(Integer.parseInt(sa[i])+'0');
			q[i]=p[i];
		}
		Arrays.sort(q);
		int [] next=new int[n];
		int tag0=0,tag1=0;
		for(int i=0;i<n;i++)
		{
			if(q[i]=='0')
			{
				while(p[tag0]!='0')tag0++;
				next[i]=tag0++;
			}
			else
			{
				while(p[tag1]!='1')tag1++;
				next[i]=tag1++;
			}
		}
		int cur=0;
		while(true)
		{
			System.out.print(q[cur]+" ");
			int nc=next[cur];
			if(nc==0)break;
			cur=nc;
		}
		
		
	}
}
