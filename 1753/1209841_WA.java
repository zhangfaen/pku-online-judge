import java.io.*;
import java.util.*;
public class Main
{
	static int BIG = Integer.MAX_VALUE / 2;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int[] p = new int[1 << 17];
		for (int i = 0; i < (1 << 17); i++)
			p[i] = BIG;
		int cur = 0;
		for (int i = 0; i < 4; i++)
		{
			String s = cin.next();
			for (int j = 0; j < 4; j++)
			{
				char c = s.charAt(j);
				if (c == 'b')
				{
					cur = cur | (1 << (i * 4 + j));
				}
			}
		}
		p[cur] = 0;
		List<Integer> q = new LinkedList<Integer>();
		q.add(cur);
		while (q.size() > 0)
		{
			cur = q.remove(0);
			for (int i = 0; i < 16; i++)
			{
				int ncur=cur;
				if ((ncur & (1 << i)) != 0)
				{
					ncur=ncur&(~(1<<i));
				}
				else
					ncur=ncur|(1<<i);
				int cx, cy;
				cx = i / 4;
				cy = i % 4;
				for (int j = 0; j < 4; j++)
				{
					int ncx = cx + dx[j];
					int ncy = cy + dy[j];
					if (ncx >= 0 && ncx < 4 && ncy >= 0 && ncy < 4)
					{
						if ((ncur & (1 << (ncx * 4 + ncy))) != 0)
						{
							ncur = ncur & (~(1 << (ncx * 4 + ncy)));
						} else
						{
							ncur = ncur | (1 << (ncx * 4 + ncy));
						}
					}
				}
				if (p[cur] + 1 < p[ncur])
				{
					p[ncur] = p[cur] + 1;
					q.add(ncur);
				}
			}
		}
		if (p[0] >= BIG)
			System.out.println("Impossible");
		else
			System.out.println(p[0]);
	}
}
