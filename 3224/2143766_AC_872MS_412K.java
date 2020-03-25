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

	String s = cin.readLine();
	int n = Integer.parseInt(s);
	int[][] map = new int[n][n];
	for (int i = 0; i < n; i++)
	{
	    s = cin.readLine();
	    String[] sa = s.split(" ");
	    for (int j = 0; j < n; j++)
		map[i][j] = Integer.parseInt(sa[j]);
	}
	int res = 0;
	int max = 0;
	for (int i = 0; i < n; i++)
	{
	    int cnt = 0;
	    for (int j = 0; j < n; j++)
		if (map[i][j] == 3)
		    cnt++;
	    if (cnt > max)
	    {
		max = cnt;
		res = i;
	    }
	}
	System.out.println(res+1);

    }

}
