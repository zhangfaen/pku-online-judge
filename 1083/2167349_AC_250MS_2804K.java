import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{

    static BufferedReader cin = new BufferedReader(new InputStreamReader(
	    System.in));

    public static void main(String[] args) throws IOException
    {
	Scanner sin = new Scanner(System.in);
	// String s = cin.readLine().trim();
	// int ts = Integer.parseInt(s);
	int ts = sin.nextInt();
	while (ts-- > 0)
	{
	    // s = cin.readLine().trim();
	    // int n = Integer.parseInt(s);
	    int n = sin.nextInt();
	    int[] cnt = new int[401];
	    for (int i = 0; i < n; i++)
	    {
		// s = cin.readLine().trim();
		// String[] sa = s.split(" ");
		// int a = Integer.parseInt(sa[0]);
		// int b = Integer.parseInt(sa[1]);
		int a = sin.nextInt();
		int b = sin.nextInt();
		int x = Math.min(a, b);
		int y = Math.max(a, b);
		if (x % 2 == 0)
		    x--;
		if (y % 2 == 1)
		    y++;
		for (int j = x; j <= y; j++)
		{
		    cnt[j]++;
		}
	    }
	    int res = 0;
	    for (int d : cnt)
		res = Math.max(d, res);
	    System.out.println(res * 10);
	}
    }
}
