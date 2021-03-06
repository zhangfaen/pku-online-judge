import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main
{

    static BufferedReader cin;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    int INF = Integer.MAX_VALUE / 3;
	    int[][] map = new int[n][n];
	    for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		    if(i!=j)map[i][j] = INF;
	    for (int i = 0; i < n; i++)
	    {
		s = cin.readLine();
		String[] sa = s.split(" ");
		for (int j = 1; j < sa.length; j += 2)
		{
		    int to = Integer.parseInt(sa[j]) - 1;
		    int len = Integer.parseInt(sa[j + 1]);
		    map[i][to] = len;

		}
	    }
	    for (int k = 0; k < n; k++)
		for (int i = 0; i < n; i++)
		    for (int j = 0; j < n; j++)
			map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
	    int rei = -1, rmin = INF;
	    for (int i = 0; i < n; i++)
	    {
		int tmax = 0;
		for (int j = 0; j < n; j++)
		{
		    tmax = Math.max(tmax, map[i][j]);
		}
		if (tmax < rmin)
		{
		    rmin = tmax;
		    rei = i;
		}
	    }
	    if (rei == -1)
		System.out.println("disjoint");
	    else
		System.out.println((rei + 1) + " " + rmin);
	}
    }

}
