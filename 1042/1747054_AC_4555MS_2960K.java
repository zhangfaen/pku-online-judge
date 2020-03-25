import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main
{
	static int n;
	static int t;
	static int [] fi;
	static int [] di;
	static int [] ti;
	static int [][]memo;
	static int [][] back;
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s ="";
		String[] sa = null;
		while(true)
		{
			s=cin.readLine().trim();
			n=Integer.parseInt(s);
			if(n==0)
				break;
			s=cin.readLine().trim();
			t=Integer.parseInt(s)*12;
			fi=new int[n];
			di=new int[n];
			ti=new int[n];
			s=cin.readLine().trim();
			sa=s.split(" ");
			for(int i=0;i<n;i++)
				fi[i]=Integer.parseInt(sa[i]);
			s=cin.readLine().trim();
			sa=s.split(" ");
			for(int i=0;i<n;i++)
				di[i]=Integer.parseInt(sa[i]);
			s=cin.readLine().trim();
			sa=s.split(" ");
			for(int i=0;i<n-1;i++)
				ti[i]=Integer.parseInt(sa[i]);
			memo=new int[t][n];
			for(int i=0;i<t;i++)
				for(int j=0;j<n;j++)
					memo[i][j]=-1;
			back=new int[t][n];
			int re=dp(0,0);
			int ct=0,ck=0;
			while(ct<t&&ck<n)
			{
				System.out.print(""+back[ct][ck]*5+(ck==n-1?"":", "));
				ct+=back[ct][ck]+ti[ck];
				ck++;
			}
			for(int i=ck;i<n;i++)
				System.out.print(0+(i==n-1?"":", "));
			System.out.println("\nNumber of fish expected: "+re+"\n");
		}
	}
	public static int dp(int ct,int ck)
	{
		if(ct==t)
		{
			return 0;
		}
		if(memo[ct][ck]!=-1)
		{
			return memo[ct][ck];
		}
		int re=0;
		if(ck==n-1)
		{
			back[ct][ck]=t-ct;
			for(int i=ct;i<t;i++)
			{
				if(fi[ck]-di[ck]*(i-ct)<=0)
					break;
				re+=(fi[ck]-di[ck]*(i-ct));
			}
			memo[ct][ck]=re;
			return re;
		}
		if(t-ct>ti[ck])
		{
			int tre=dp(ct+ti[ck],ck+1);
			if(tre>re)
			{
				back[ct][ck]=0;
				re=tre;
			}
		}
		int d=0;
		for(int i=ct;i<t;i++)
		{
			if(fi[ck]-di[ck]*(i-ct)>0)
				d+=fi[ck]-di[ck]*(i-ct);
			int tdp=0;
			if(i+1+ti[ck]<t)
				tdp=dp(i+1+ti[ck],ck+1);
			if(d+tdp>=re)
			{
				re=d+tdp;
				back[ct][ck]=i-ct+1;
			}
		}
		return memo[ct][ck]=re;
	}
}