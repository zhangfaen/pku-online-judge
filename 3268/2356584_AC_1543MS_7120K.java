import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(cin.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int x = Integer.parseInt(st.nextToken());
	int[][] map = new int[n][n];
	for (int i = 0; i < m; i++)
	{
	    st = new StringTokenizer(cin.readLine());
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    int t = Integer.parseInt(st.nextToken());
	    map[a - 1][b - 1] = t;
	}
	int[] memo1 = new int[n];
	int[] memo2 = new int[n];
	List<Integer> q = new LinkedList<Integer>();
	x--;
	Arrays.fill(memo1, Integer.MAX_VALUE/2);
	Arrays.fill(memo2, Integer.MAX_VALUE/2);
	memo1[x]=0;
	memo2[x]=0;
	q.add(x);
	while(q.isEmpty()==false)
	{
	    int cur=q.remove(0);
	    int tb=memo1[cur];
	    for(int i=0;i<n;i++)
	    {
		if(map[cur][i]>0&&tb+map[cur][i]<memo1[i])
		{
		    memo1[i]=tb+map[cur][i];
		    q.add(i);
		}
	    }
	}
	q.add(x);
	while(q.isEmpty()==false)
	{
	    int cur=q.remove(0);
	    int tb=memo2[cur];
	    for(int i=0;i<n;i++)
	    {
		if(map[i][cur]>0&&tb+map[i][cur]<memo2[i])
		{
		    memo2[i]=tb+map[i][cur];
		    q.add(i);
		}
	    }
	}
	int res=0;
	for(int i=0;i<n;i++)
	{
	    int d=memo1[i]+memo2[i];
	    res=Math.max(res, d);
	}
	System.out.println(res);
	
    }
}
