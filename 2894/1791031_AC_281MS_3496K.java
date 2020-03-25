import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String s = cin.readLine();
		int ts=Integer.parseInt(s);
		while(ts-->0)
		{
			int n=Integer.parseInt(cin.readLine());
			int [] count=new int[1001];
			for(int i=0;i<n;i++)
			{
				s=cin.readLine();
				String [] sa=s.split(" ");
				int a=Integer.parseInt(sa[1]);
				int b=Integer.parseInt(sa[2]);
				for(int j=a;j<b;j++)
					count[j]++;
			}
			for(int i=0;i<1001;i++)
				if(count[i]>0)
				{
					System.out.print((char)(count[i]-1+'A'));
				}
			System.out.println();
		}
	}

	
}
