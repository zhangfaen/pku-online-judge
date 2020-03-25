import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static int[] dx = { 1, 1, -1, -1, 2, 2, -2, -2 };
    static int[] dy = { 2, -2, 2, -2, 1, -1, 1, -1 };
    static int[][][][] best = new int[8][8][8][8];

    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine().trim();
	int hs = s.length() / 2 - 1;
	int kx, ky;
	int[] hxs = new int[hs];
	int[] hys = new int[hs];
	kx = s.charAt(0) - 'A';
	ky = s.charAt(1) - '1';
	for (int i = 2; i < s.length(); i += 2)
	{
	    hxs[i / 2 - 1] = s.charAt(i) - 'A';
	    hys[i / 2 - 1] = s.charAt(i + 1) - '1';
	}
	calcBest();
//	for(int i=0;i<8;i++)
//	    for(int j=0;j<8;j++)
//		for(int p=0;p<8;p++)
//		    for(int q=0;q<8;q++)
//			System.out.println(i+" "+j+" "+p+" "+q+":"+best[i][j][p][q]);
	int res = Integer.MAX_VALUE;
	for (int i = 0; i < 8; i++)
	    for (int j = 0; j < 8; j++)
	    {
		int t = 0;
		for (int k = 0; k < hs; k++)
		{
		    t += best[hxs[k]][hys[k]][i][j];
		}
		for (int k = 0; k < hs; k++)
		{
		    int d = 0;
		    d = t - best[hxs[k]][hys[k]][i][j];
		    for (int p = 0; p < 8; p++)
			for (int q = 0; q < 8; q++)
			{
			   int dd=d+Math.abs(kx-p)+Math.abs(ky-q)+best[hxs[k]][hys[k]][p][q]+best[p][q][i][j];
			   res=Math.min(res, dd);
			}
		}
	    }
	System.out.println(res);
    }

    public static void calcBest()
    {
	for (int i = 0; i < 8; i++)
	    for (int j = 0; j < 8; j++)
	    {
		int[][] tbest = new int[8][8];
		boolean[][] vst = new boolean[8][8];
		vst[i][j] = true;
		List<Integer> q = new LinkedList<Integer>();
		q.add(i);
		q.add(j);
		while (!q.isEmpty())
		{
		    int ci = q.remove(0);
		    int cj = q.remove(0);
		    int step = tbest[ci][cj];
		    for (int k = 0; k < 8; k++)
		    {
			int ni = ci + dx[k];
			int nj = cj + dy[k];
			if (ni < 0 || ni >= 8 || nj < 0 || nj >= 8)
			    continue;
			if (vst[ni][nj] == false)
			{
			    vst[ni][nj] = true;
			    tbest[ni][nj] = step + 1;
			    q.add(ni);
			    q.add(nj);
			}
		    }
		}
		for (int x = 0; x < 8; x++)
		    for (int y = 0; y < 8; y++)
			best[i][j][x][y] = tbest[x][y];
	    }
    }

}
