import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
public class Main
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s=cin.readLine();
		int ts=Integer.parseInt(s);
		String [] sa=null;
		while(ts--!=0)
		{
			s=cin.readLine();
			sa=s.split(" ");
			int P=Integer.parseInt(sa[0]);
			int G=Integer.parseInt(sa[1]);
			int [][] score=new int[P][G];
			for(int i=0;i<P;i++)
			{
				s=cin.readLine();
				sa=s.split(" ");
				for(int j=0;j<G;j++)
				{
					score[i][j]=Integer.parseInt(sa[j]);
				}
				Arrays.sort(score[i]);
			}
			int [] maxs=new int[P];
			int [] mins=new int[P];
			for(int i=0;i<P;i++)
			{
				int max=0;
				int [] tags=new int[P];
				for(int j=0;j<G;j++)
				{
					boolean ok=true;
					for(int k=0;k<P;k++)
					{
						if(k==i)
							continue;
						if(score[i][j]<=score[k][tags[k]])
						{
							ok=false;
							break;
						}
					}
					if(ok)
					{
						max++;
						for(int k=0;k<P;k++)
							tags[k]++;
					}
				}
				maxs[i]=max;
			}
			for(int i=0;i<P;i++)
			{
				int min=0;
				int [] tags=new int[P];
				Arrays.fill(tags, G-1);
				out:for(int j=G-1;j>=0;j--)
				{
					boolean fail=false;
					for(int k=0;k<P;k++)
					{
						if(i==k)
							continue;
						if(score[i][j]<=score[k][tags[k]])
						{
							tags[k]--;
							continue out;
						}
					}
					min++;
				}
				mins[i]=min;
			}
			for(int i=0;i<P;i++)
			{
				System.out.println(mins[i]+" "+maxs[i]);
			}
			
			
		}
		out.flush();
	}

}