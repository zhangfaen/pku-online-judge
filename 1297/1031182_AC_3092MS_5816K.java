

import java.io.*;
import java.util.*;

public class Main
{
	static double[] last;
	static double[] cur ; 

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		while (true)
		{
			int n, m;
			n = cin.nextInt();
			m = cin.nextInt();
			if (n + m == 0)
				break;
			int[] buy = new int[n];
			for (int i = 0; i < n; i++)
				buy[i] = cin.nextInt();
			int[] prod = new int[m];
			double[] price = new double[m];
			for (int i = 0; i < m; i++)
			{
				prod[i] = cin.nextInt();
				price[i] = cin.nextDouble();
			}
			
			last = new double[n];
			cur = new double[n];
			for (int i = 0; i < n; i++)
				last[i] = 1000000000000.0;
			if (buy[n - 1] == prod[m - 1])
				last[n - 1] = price[m - 1];
			for (int j = m - 2; j >= 0; j--)
			{
				
				for (int i = n - 1; i >= 0; i--)
				{
					if (i == n - 1)
					{
						if (buy[i] == prod[j])
						{
							cur[i] = Math.min(last[i], price[j]);
						}
						else
							cur[i] = last[i];
					}
					else
					{
						if(buy[i]==prod[j])
							cur[i]=Math.min(last[i], last[i+1]+price[j]);
						else
							cur[i]=last[i];
					}
				}
				double [] t=last;
				last=cur;
				cur=t;
			}
			if(last[0]>=1000000000000.0)
				System.out.println("Impossible");
			else
				System.out.printf("%.2f\n",last[0]);
		}
	}
}
