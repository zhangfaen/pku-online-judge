import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		while(true)
		{
			int n,k,m;
			n=cin.nextInt();
			k=cin.nextInt();
			m=cin.nextInt();
			if(n+k+m==0)
				break;
			int [] mod=new int [1001];
			Arrays.fill(mod,Integer.MAX_VALUE);
			String [] res=new String[k];
			Arrays.fill(res,"");
			int trg=((n+1)%k+k)%k;
			int cur=((n)%k+k)%k;
			mod[cur]=0;
			res[cur]="";
			List<Integer> q=new LinkedList<Integer>();
			q.add(cur);
			while(q.size()>0)
			{
				cur=q.remove(0);
				if(cur%k==trg)
				{
					break;
				}
				int tv;
				tv=(cur+m)%k;
				if(mod[tv]>mod[cur]+1)
				{
					mod[tv]=mod[cur]+1;
					res[tv]=res[cur]+"+";
					q.add(tv);
				}
				tv=((cur-m)%k+k)%k;
				if(mod[tv]>mod[cur]+1)
				{
					mod[tv]=mod[cur]+1;
					res[tv]=res[cur]+"-";
					q.add(tv);
				}
				tv=(cur*m)%k;
				if(mod[tv]>mod[cur]+1)
				{
					mod[tv]=mod[cur]+1;
					res[tv]=res[cur]+"*";
					q.add(tv);
				}
				tv=(cur%m);
				if(mod[tv]>mod[cur]+1)
				{
					mod[tv]=mod[cur]+1;
					res[tv]=res[cur]+"%";
					q.add(tv);
				}
			}
			if(mod[trg]<Integer.MAX_VALUE)
			{
				System.out.println(mod[trg]);
				System.out.println(res[trg]);
			}
			else
			{
				System.out.println(0);
			}
		}
		}
		
	
}
