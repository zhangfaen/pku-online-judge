package com.util;

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
		int n = Integer.parseInt(cin.readLine());
		Map<Integer, Integer> mii = new HashMap<Integer, Integer>();
		int res = 0;
		for (int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(cin.readLine());
			int num = Integer.parseInt(st.nextToken());
			int correct = Integer.parseInt(st.nextToken());
			int explanation = Integer.parseInt(st.nextToken());
			if (correct == 0)
			{
				res += 10;
			} else
			{
				if (mii.containsKey(num))
				{
					if (explanation == 1)
						res += 50;
					else
						res += 10;
				} else
				{
					mii.put(num, 0);
					if (explanation == 1)
						res += 40;
					else
						res += 20;
				}
			}
		}
		System.out.println(res);
	}
}
