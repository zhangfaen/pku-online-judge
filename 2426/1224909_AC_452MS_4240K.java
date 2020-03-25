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
		while (true)
		{
			int n, k, m;
			n = cin.nextInt();
			k = cin.nextInt();
			m = cin.nextInt();
			if (n ==0&& k==0&& m == 0)
				break;
			int[][] mod = new int[3][1001];
			for(int i=0;i<3;i++)
				Arrays.fill(mod[i], Integer.MAX_VALUE);
			String[][] res = new String[3][k];
			for(int i=0;i<3;i++)
				Arrays.fill(res[i], "");
			int trg = ((n + 1) % k + k) % k;
			for(int i=0;i<3;i++)
			{
				int cur = ((n) % k + k) % k;
				if(i==0)
				{
					cur=((n) % k + k) % k;
					mod[0][cur] = 0;
					res[0][cur]="";
				}
				else
				if(i==1)
				{
					cur=((n%m+m) % m) % k;
					mod[1][cur] = 1;
					res[1][cur]="%";
				}
				else
				{
					cur=0;
					mod[2][cur] = 2;
					res[2][cur]="*%";
				}
				List<Integer> q = new LinkedList<Integer>();
				q.add(cur);
				while (q.size() > 0)
				{
					cur = q.remove(0);
					if (cur %k== trg)
					{
						break;
					}
					int tv;
					tv = (cur + m) % k;
					if (mod[i][tv] > mod[i][cur] + 1)
					{
						mod[i][tv] = mod[i][cur] + 1;
						res[i][tv] = res[i][cur] + "+";
						q.add(tv);
					}
					tv = ((cur - m) % k + k) % k;
					if (mod[i][tv] > mod[i][cur] + 1)
					{
						mod[i][tv] = mod[i][cur] + 1;
						res[i][tv] = res[i][cur] + "-";
						q.add(tv);
					}
					tv = (cur * m) % k;
					if (mod[i][tv] > mod[i][cur] + 1)
					{
						mod[i][tv] = mod[i][cur] + 1;
						res[i][tv] = res[i][cur] + "*";
						q.add(tv);
					}
				}
			}
			if (mod[0][trg] == Integer.MAX_VALUE&&mod[1][trg] == Integer.MAX_VALUE&&mod[2][trg] == Integer.MAX_VALUE)
			{
				System.out.println(0);
			} else
			{
				int tag=Integer.MAX_VALUE;
				String ou="";
				
				for(int j=0;j<3;j++)
				{
					if(mod[j][trg]<tag)
					{
						tag=mod[j][trg];
						ou=res[j][trg];
					}
				}
				System.out.println(tag);
				System.out.println(ou);
				
			}
			
		}
	}
}

