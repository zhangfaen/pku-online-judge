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
	int end = 32768;
	int[] cnt = new int[end];
	for (int i = 1; i * i < end; i++)
	    cnt[i * i]++;
	for (int i = 1; i * i < end; i++)
	    for (int j = i; i * i + j * j < end; j++)
		cnt[i * i + j * j]++;
	for (int i = 1;; i++)
	{
	    int ti = i * i;
	    if (ti >= end)
		break;
	    for (int j = i;; j++)
	    {
		int tj = ti + j * j;
		if (tj >= end)
		    break;
		for (int p = j;; p++)
		{
		    int tp = tj + p * p;
		    if (tp >= end)
			break;
		    cnt[tp]++;
		}
	    }
	}
	for (int i = 1;; i++)
	{
	    int ti = i * i;
	    if (ti >= end)
		break;
	    for (int j = i;; j++)
	    {
		int tj = ti + j * j;
		if (tj >= end)
		    break;
		for (int p = j;; p++)
		{
		    int tp = tj + p * p;
		    if (tp >= end)
			break;
		    for (int q = p;; q++)
		    {
			int tq = tp + q * q;
			if (tq >= end)
			    break;
			cnt[tq]++;
		    }
		}
	    }
	}
	while (true)
	{
	    String s = cin.readLine();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    System.out.println(cnt[n]);
	}
    }
}
