import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    if(s==null)break;
	    StringTokenizer st = new StringTokenizer(s);
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    int[] memo = new int[500000];
	    Arrays.fill(memo, Integer.MAX_VALUE);
	    memo[n] = 0;
	    List<Integer> q = new LinkedList<Integer>();
	    q.add(n);
	    int up=Math.max(n, 3*k)+10;
	    while (!q.isEmpty())
	    {
		int cur = q.remove(0);
		int pre = cur - 1;
		int next = cur + 1;
		int mul = cur * 2;
		if (pre >= 0 && pre < up && memo[cur] + 1 < memo[pre])
		{
		    memo[pre] = memo[cur] + 1;
		    q.add(pre);
		}
		if (next >= 0 && next < up && memo[cur] + 1 < memo[next])
		{
		    memo[next] = memo[cur] + 1;
		    q.add(next);
		}
		if (mul >= 0 && mul < up && memo[cur] + 1 < memo[mul])
		{
		    memo[mul] = memo[cur] + 1;
		    q.add(mul);
		}
	    }
	    System.out.println(memo[k]);
	}
    }
}
