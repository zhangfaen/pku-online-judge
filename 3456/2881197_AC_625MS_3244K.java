import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(cin.readLine());
		int end = 1020000;
		boolean[] vst = new boolean[end];
		boolean[] src = new boolean[end];
		while (cnt-- > 0)
		{
			String[] sa = cin.readLine().split(" +");
			int[] vs = new int[4];
			for (int i = 0; i < 4; i++)
				vs[i] = Integer.parseInt(sa[i]);
			Arrays.sort(vs);
			System.arraycopy(src, 0, vst, 0, src.length);
			vst[0] = true;
			int left = 1000000;
			for (int i = 0; i < end; i++)
			{
				if (vst[i])
				{
					for (int k = 0; k < 4; k++)
					{
						int n = i + vs[k];
						if (n < end && vst[n] == false)
						{
							vst[n] = true;
							if (n <= 1000000)
								left--;
						}
					}
				}
			}
			int min = -1;
			for (int i = end - 1; i >= 0; i--)
			{
				if (vst[i] == false)
				{
					min = i;
					break;
				}
			}
			System.out.println(left);
			System.out.println(min >= 1000000 ? -1 : min);
		}
	}
}