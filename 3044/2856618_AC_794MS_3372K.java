
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(cin.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		List<Integer> stack = new LinkedList<Integer>();
		stack.add(0, -1);
		int re = 0;
		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(cin.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (y > stack.get(0))
				stack.add(0, y);
			else
			{
				while (stack.get(0) >= y)
				{
					if (stack.get(0) > y)
						re++;
					stack.remove(0);
				}
				stack.add(0, y);
			}
		}
		re += stack.size() - 1;
		if (stack.size() > 1 && stack.get(stack.size() - 2) == 0)
			re--;
		System.out.println(re);
	}
}
