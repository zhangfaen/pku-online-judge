import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static int n;
	static int[] map;
	static int[] len;
	static int tar;

	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int ts = cin.nextInt();
		while (ts-- != 0)
		{
			n = cin.nextInt();
			map = new int[n];
			len = new int[4];
			int sum = 0;
			for (int i = 0; i < n; i++)
			{
				map[i] = cin.nextInt();
				sum+=map[i];
			}
			Arrays.sort(map);
			if(sum%4!=0)
			{
				System.out.println("no");
				continue;
			}
			tar=sum/4;
			try
			{
				dfs(0);
			}
			catch (Exception e)
			{
				System.out.println("yes");
				continue;
			}
			System.out.println("no");
		}
	}

	public static void dfs(int index) throws Exception
	{
		if (index == n)
		{
			throw new Exception();
		}
		out:for(int i=0;i<4;i++)
		{
			if(len[i]==tar)
				continue;
			if(len[i]+map[index]>tar)return;
			for(int j=0;j<i;j++)
				if(len[j]==len[i])
					continue out;
			if(len[i]+map[index]<=tar)
			{
				len[i]+=map[index];
				dfs(index+1);
				len[i]-=map[index];
			}
		}
	}
}
