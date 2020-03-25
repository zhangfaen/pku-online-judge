import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	static boolean[] p = new boolean[1000000 + 1];

	public static void main(String[] args) throws IOException
	{
		Scanner cin = new Scanner(System.in);
		int testcase = cin.nextInt();
		while (testcase-- != 0)
		{
			int n = cin.nextInt();
			int[] data = new int[n];
			for (int i = 0; i < n; i++)
			{
				data[i] = cin.nextInt();
			}
			for (int i = 0; i < n - 1; i++)
			{
				for (int j = i + 1; j < n; j++)
				{
					factor(Math.abs(data[i] - data[j]));
				}
			}
			for (int i = n;; i++)
			{
				if (!p[i])
				{
					boolean flag = true;
					HashSet<Integer> hi = new HashSet<Integer>();
					for (int j = 0; j < n; j++)
					{
						if (hi.contains(data[j] % i))
						{
							flag = false;
							break;
						}
						hi.add(data[j] % i);
					}
					if (flag)
					{
						System.out.println(i);
						break;
					}
				}
			}
		}

	}

	public static void factor(int m)
	{
		for (int i = 1; i < Math.sqrt(m) + 1; i++)
		{
			if (m % i == 0)
			{
				p[i] = true;
				p[m / i] = true;
			}
		}
	}

}
