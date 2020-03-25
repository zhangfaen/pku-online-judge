
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(cin.readLine());
		int n = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> mii = new HashMap<Integer, Integer>();
		st = new StringTokenizer(cin.readLine());
		for (int i = 0; i < n; i++)
		{
			int t = Integer.parseInt(st.nextToken()) % L;
			if (mii.containsKey(t))
				mii.put(t, mii.get(t) + 1);
			else
				mii.put(t, 1);
		}
		int cnt = 0;
		int num = 0;
		for (int key : mii.keySet())
			if (mii.get(key) > cnt)
			{
				cnt = mii.get(key);
				num = key;
			} else if (mii.get(key) == cnt)
			{
				if (key == 0 || num != 0 && key > num)
				{
					num = key;
				}
			}
		if (num == 0)
			System.out.println(0);
		else
			System.out.println(L - num);
	}
}
