int[][] bd = new int[4][4];
	int[] memo = new int[1 << 16];
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	int BIG = Integer.MAX_VALUE / 2; 
	public int maximize(String[] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			String[] sa = board[i].split(" ");
			for (int j = 0; j < sa.length; j++)
				bd[i][j] = Integer.parseInt(sa[j]);
		}
		for (int i = 0; i < (1 << 16); i++)
			memo[i] = BIG;
		memo[0] = 0;
		int re = dp((1 << 16) - 1, 136);
		return re * 2 - 136;
	}
	public int dp(int state, int cs)
	{
		if (memo[state] != BIG)
			return memo[state];
		boolean[][] left = new boolean[4][4];
		for (int i = 0; i < 16; i++)
		{
			int fac = (1 << i) & state;
			if (fac != 0)
				left[i / 4][i % 4] = true;
			else
				left[i / 4][i % 4] = false;
		}
		int re = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
			{
				if (left[i][j])
				{
					boolean out = false;
					if (i == 0 || i == 3 || j == 0 || j == 3)
						out = true;
					else
						for (int k = 0; k < 4; k++)
						{
							int ni = i + dx[k];
							int nj = j + dy[k];
							if (left[ni][nj] == false)
							{
								out = true;
								break;
							}
						}
					if (out)
					{
						int ns = (1 << (i * 4 + j)) ^ state;
						re = Math.max(cs - dp(ns, cs - bd[i][j]), re);
					}
				}
			}
		return memo[state] = re;
	}