import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
	public static void main(String []args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		int tag=0;
		while(true)
		{
			tag++;
			String s=cin.readLine();
			String [] sa=s.split(" ");
			int S=Integer.parseInt(sa[0]);
			int T=Integer.parseInt(sa[1]);
			int L=Integer.parseInt(sa[2]);
			if(S+T+L==0)break;
			int [] p=new int[S];
			int [] q=new int[S];
			for(int i=0;i<S;i++)
			{
				s=cin.readLine();
				sa=s.split(" ");
				int cs=Integer.parseInt(sa[0]);
				int bc=Integer.parseInt(sa[1]);
				int cc=Integer.parseInt(sa[2]);
				p[cs-1]=bc+cc;
			}
			for(int i=0;i<T;i++)
			{
				s=cin.readLine();
				sa=s.split(" ");
				int ct=Integer.parseInt(sa[0]);
				int cn=Integer.parseInt(sa[1]);
				if(cn>=L)
					q[ct-1]=1;
			}
			int re=0;
			for(int i=0;i<S;i++)
				re+=p[i]+q[i];
			System.out.println("Case "+tag+": "+re);
			//cin.readLine();
		}
		
	}
}
