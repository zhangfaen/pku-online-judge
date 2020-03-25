import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine();
	int ts = Integer.parseInt(s);
	while (ts-- > 0)
	{
	    s=cin.readLine();
	    int n=Integer.parseInt(s);
	    s=cin.readLine();
	    String [] sa=s.split(" ");
	    int [] p=new int[n];
	    for(int i=0;i<n;i++)
		p[i]=Integer.parseInt(sa[i]);
	    s=cin.readLine();
	    sa=s.split(" ");
	    int m=Integer.parseInt(sa[0]);
	    int k=Integer.parseInt(sa[1]);
	    int left=1,right=100000000;
	    while(left<right)
	    {
		int mid=(left+right)/2;
		if(check(p,mid,1L*mid*(k-1)*m,k-1))
		{
		    right=mid;
		}
		else
		{
		    left=mid+1;
		}
	    }
	    System.out.println(right);
	}

    }
    public static boolean check(int [] p,int mid,long as,int k)
    {
	for(int i=0;i<p.length;i++)
	    if(p[i]>mid)
	    {
		int d=p[i]-mid;
		
		if(d%k==0)
		    as-=d;
		else as-=k*(d/k+1);
		if(as<0)return false;
	    }
	return true;
    }
}
