import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int m,n,r,s;
			m=cin.nextInt();
			n=cin.nextInt();
			r=cin.nextInt();
			s=cin.nextInt();
			int rs=r-s;
			int mn=m-n;
			int mp,np,rp,sp,rsp,mnp;
			if(m>=r)
				mp=rp=r+1;
			else
				mp=rp=m+1;
			if(n>=s)
				np=sp=s+1;
			else
				np=sp=n+1;
			if(rs>=mn)
				rsp=mnp=mn+1;
			else
				rsp=mnp=rs+1;
			double re=1;
			while(mp<=m||np<=n||rp<=r||sp<=s||rsp<=rs||mnp<=mn)
			{
				if(rp<=r)
					re/=rp++;
				if(sp<=s)
					re*=sp++;
				if(np<=n)
					re/=np++;
				if(mp<=m)
					re*=mp++;
				if(rsp<=rs)
					re*=rsp++;
				if(mnp<=mn)
					re/=mnp++;
			}
			System.out.printf("%.5f\n",re);
		}
	}
}
