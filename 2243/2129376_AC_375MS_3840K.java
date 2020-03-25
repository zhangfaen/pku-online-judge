import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static BufferedReader cin;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));

	int[] dx = { 1, 1, -1, -1, 2, 2, -2, -2 };
	int[] dy = { 2, -2, 2, -2, 1, -1, 1, -1 };
	while (true)
	{
	    String s = cin.readLine();
	    if (s == null)
		break;
	    s = s.trim();
	    String[] sa = s.split(" ");
	    int[][] memo = new int[8][8];
	    int sx = sa[0].charAt(0) - 'a';
	    int sy = sa[0].charAt(1) - '1';
	    int tx = sa[1].charAt(0) - 'a';
	    int ty = sa[1].charAt(1) - '1';
	    memo[sx][sy] = 1;
	    List<Integer> q = new LinkedList<Integer>();
	    q.add(sx);
	    q.add(sy);
	    out: while (!q.isEmpty())
	    {
		int cx = q.remove(0);
		int cy = q.remove(0);
		int cs = memo[cx][cy];
		for (int k = 0; k < 8; k++)
		{
		    int nx = cx + dx[k];
		    int ny = cy + dy[k];
		    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8)
			continue;
		    if (memo[nx][ny] == 0)
		    {
			memo[nx][ny] = cs + 1;
			if (nx == tx && ny == ty)
			    break out;
			q.add(nx);
			q.add(ny);
		    }
		}
	    }
	    memo[tx][ty]--;
	    System.out.println("To get from " + sa[0] + " to " + sa[1]
		    + " takes " + memo[tx][ty] + " knight moves.");

	}
    }

}
