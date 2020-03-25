import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(cin.readLine());
		boolean[] vst = new boolean[1000001];
		boolean[] src = new boolean[1000001];
		while (cnt-- > 0)
		{
			String[] sa = cin.readLine().split(" +");
			int[] vs = new int[4];
			for (int i = 0; i < 4; i++)
				vs[i] = Integer.parseInt(sa[i]);
			System.arraycopy(src, 0, vst, 0, src.length);
			vst[0] = true;
			int left = 1000000;
			for (int i = 0; i <= 1000000; i++)
			{
				if (vst[i])
				{
					for (int k = 0; k < 4; k++)
					{
						int n = i + vs[k];
						if (n <= 1000000 && vst[n] == false)
						{
							vst[n] = true;
							left--;
						}
					}
				}
			}
			int min = -1;
			for (int i = 1000000; i >= 0; i--)
			{
				if (vst[i] == false)
				{
					min = i;
					break;
				}
			}
			System.out.println(left);
			System.out.println(min);
		}
	}
}