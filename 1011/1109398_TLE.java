import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	static int n;

	static int[] sticks;

	static boolean[] state;

	static boolean re = false;

	static int aver;

	static int sum;

	static int max;

	static int min;

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			n = cin.nextInt();
			if (n == 0)
				break;
			re = false;
			sticks = new int[n];
			sum = 0;
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++)
			{
				sticks[i] = cin.nextInt();
				if (sticks[i] < min)
					min = sticks[i];
				if (sticks[i] > max)
					max = sticks[i];
				sum += sticks[i];
			}
			Arrays.sort(sticks);
			for (aver = min; aver <= sum; aver++)
			{
				if (sum % aver != 0 || max > aver || max != aver
					&& max + min > aver)
					continue;
				state = new boolean[n];
				int d = sum / aver;
				for (int i = 0; i < n; i++)
					if (sticks[i] == aver)
					{
						state[i] = true;
						d--;
					}
				try
				{
					f(d);
				}
				catch (Exception e)
				{
				}
				if (re)
				{
					System.out.println(aver);
					break;
				}
			}

		}
	}

	public static void f(int d) throws Exception
	{
		if (d == 0)
		{
			re = true;
			throw new Exception();

		}
		g(0, d, n-1);

	}

	public static void g(int len, int d, int index) throws Exception
	{
		if (len == aver)
		{
			int minIndex=getMin();
			int maxIndex=getMax();
			if(minIndex==maxIndex&&minIndex<n)
				return;
			if(minIndex<n&&sticks[minIndex]+sticks[maxIndex]>aver)
				return;
			f(d - 1);
			return;
		}

		for (; index >=0; index--)
			if (state[index] == false&&len+sticks[index]<=aver)
				break;
		if (index == -1)
			return;
	//	if (len + sticks[index] < aver)
		//	return;
		
		state[index] = true;
		g(len + sticks[index], d, index - 1);
		state[index] = false;
		g(len, d, index - 1);

	}

	public static int getMax()
	{
		for (int i = n - 1; i >= 0; i--)
			if (state[i] == false)
				return i;
		return 10000;
	}

	public static int getMin()
	{
		for (int i = 0; i < n; i++)
			if (state[i] == false)
				return i;
		return 10000;
	}
}
