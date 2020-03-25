import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
	static String up, down;
	static String target;
	static boolean[][] memo;
	static boolean[][] vst;

	static boolean dp(int i, int j)
	{
		if (i == target.length())
			return true;
		if (j == up.length())
			return false;
		if (vst[i][j])
			return memo[i][j];
		vst[i][j] = true;
		boolean re = false;
		char c1 = target.charAt(i);
		char c2 = up.charAt(j);
		char c3 = down.charAt(j);
		if (c1 == c2 || c1 == c3 || c2 == '*')
			re |= dp(i + 1, j + 1);
		else
			re |= dp(i, j + 1);
		return memo[i][j] = re;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(cin.readLine());
		while (cnt-- > 0)
		{
			target = cin.readLine();
			up = cin.readLine();
			down = cin.readLine();
			memo = new boolean[target.length()][up.length()];
			vst = new boolean[target.length()][up.length()];
			if (dp(0, 0))
			{
				System.out.println("win");
			} else
				System.out.println("lose");
		}
	}
}