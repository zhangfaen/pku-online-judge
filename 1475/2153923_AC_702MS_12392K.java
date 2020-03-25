import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static BufferedReader cin;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static char[] dirL = { 'e', 'w', 's', 'n' };
    static char[] dirU = { 'E', 'W', 'S', 'N' };

    public static void main(String[] args) throws IOException
    {

	cin = new BufferedReader(new InputStreamReader(System.in));
	int m, n;
	char[][] map;
	int ts = 0;
	while (true)
	{
	    ts++;
	    String s = cin.readLine();
	    String[] sa = s.split(" ");
	    m = Integer.parseInt(sa[0]);
	    n = Integer.parseInt(sa[1]);
	    if (m + n == 0)
		break;
	    map = new char[m][n];
	    int sx = -1, sy = -1, tx = -1, ty = -1, bx = -1, by = -1;
	    for (int i = 0; i < m; i++)
	    {
		s = cin.readLine();
		for (int j = 0; j < n; j++)
		{
		    map[i][j] = s.charAt(j);
		    if (map[i][j] == 'S')
		    {
			sx = i;
			sy = j;
		    }
		    if (map[i][j] == 'B')
		    {
			bx = i;
			by = j;
		    }
		    if (map[i][j] == 'T')
		    {
			tx = i;
			ty = j;
		    }
		}
	    }
	    int[][][][] memo = new int[m][n][m][n];
	    char[][][][] back = new char[m][n][m][n];
	    for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
		    for (int p = 0; p < m; p++)
			for (int q = 0; q < n; q++)
			    memo[i][j][p][q] = Integer.MAX_VALUE;
	    memo[sx][sy][bx][by] = 0;
	    List<Integer> q = new LinkedList<Integer>();
	    addQ(q, sx, sy, bx, by);
	    while (!q.isEmpty())
	    {
		int csx = q.remove(0), csy = q.remove(0), cbx = q.remove(0), cby = q
			.remove(0);
		if(cbx==tx&&cby==ty)continue;
		int step = memo[csx][csy][cbx][cby];
		for (int k = 0; k < 4; k++)
		{
		    int nsx = csx + dx[k];
		    int nsy = csy + dy[k];
		    if (nsx < 0 || nsx >= m || nsy < 0 || nsy >= n
			    || map[nsx][nsy] == '#')
			continue;
		    if (!(nsx == cbx && nsy == cby))
		    {
			if (step < memo[nsx][nsy][cbx][cby])
			{
			    memo[nsx][nsy][cbx][cby] = step;
			    back[nsx][nsy][cbx][cby] = dirL[k];
			    addQ(q, nsx, nsy, cbx, cby);
			}
		    }
		    else
		    {
			int nbx = cbx + dx[k];
			int nby = cby + dy[k];
			if (nbx < 0 || nbx >= m || nby < 0 || nby >= n
				|| map[nbx][nby] == '#')
			    continue;
			if (step + 1 < memo[nsx][nsy][nbx][nby])
			{
			    memo[nsx][nsy][nbx][nby] = step + 1;
			    back[nsx][nsy][nbx][nby] = dirU[k];
			    addQ(q, nsx, nsy, nbx, nby);
			}
		    }
		}
	    }
	    int best = Integer.MAX_VALUE;
	    int backsx = -1, backsy = -1, backbx = -1, backby = -1;
	    for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
		{
		    if (memo[i][j][tx][ty] < best)
		    {
			best = memo[i][j][tx][ty];
			backsx = i;
			backsy = j;
			backbx = tx;
			backby = ty;
		    }
		}
	    System.out.println("Maze #" + ts);
	    if (best == Integer.MAX_VALUE)
	    {
		System.out.println("Impossible.\n");
	    }
	    else
	    {
		StringBuilder sb = new StringBuilder("");
		while (backsx != sx || backsy != sy || backbx != bx
			|| backby != by)
		{
		    char c = back[backsx][backsy][backbx][backby];
		    sb.append(c);
		    if (Character.isUpperCase(c))
		    {
			int di = -1;
			for (int k = 0; k < 4; k++)
			    if (dirU[k] == c)
				di = k;
			backsx -= dx[di];
			backsy -= dy[di];
			backbx -= dx[di];
			backby -= dy[di];
		    }
		    else
		    {
			int di = -1;
			for (int k = 0; k < 4; k++)
			    if (dirL[k] == c)
				di = k;
			backsx -= dx[di];
			backsy -= dy[di];
		    }
		}
		sb.reverse();
		System.out.println(sb + "\n");
	    }
	}
    }

    public static void addQ(List<Integer> q, int a, int b, int c, int d)
    {
	q.add(a);
	q.add(b);
	q.add(c);
	q.add(d);
    }
}
