import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));

    public static void main(String[] args) throws IOException
    {
	while (true)
	{
	    String s = cin.readLine();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    int[][] map = new int[n][n];
	    for (int i = 0; i < n; i++)
	    {
		s = cin.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for (int j = 0; j < n; j++)
		{
		    int v = Integer.parseInt(st.nextToken());
		    map[i][j] = v;
		}
	    }
	    int ri = -1, rj = -1, cnti = 0, cntj = 0;
	    for (int i = 0; i < n; i++)
	    {
		int t=0;
		for (int j = 0; j < n; j++)
		{
		    t+=map[i][j];
		}
		if(t%2==1)
		{
		    cnti++;
		    ri=i;
		}
	    }
	    for(int j=0;j<n;j++)
	    {
		int t=0;
		for(int i=0;i<n;i++)
		    t+=map[i][j];
		if(t%2==1)
		{
		    cntj++;
		    rj=j;
		}
	    }
	    if(cnti+cntj==0)
	    {
		System.out.println("OK");
	    }
	    else
		if(cnti==1&&cntj==1)
		{
		    System.out.println("Change bit ("+(ri+1)+","+(rj+1)+")");
		}
		else
		{
		    System.out.println("Corrupt");
		}
	}
    }
}
