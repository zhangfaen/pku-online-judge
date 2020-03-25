import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    static char[][] map;
    static boolean [] vst;
    static int m,n;
    public static void main(String[] args) throws IOException
    {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	String s = cin.readLine().trim();
	String[] sa = s.split(" ");
	m = Integer.parseInt(sa[0]);
	n = Integer.parseInt(sa[1]);
	map = new char[m][n];
	for (int i = 0; i < m; i++)
	{
	    s = cin.readLine().trim();
	    for (int j = 0; j < n; j++)
		map[i][j] = s.charAt(j);
	}
	vst=new boolean[26];
	vst[map[0][0]-'A']=true;
	dfs(0,0,1);
	System.out.println(max);
    }
    static int max=0;
    static int [] dx= {1,-1,0,0};
    static int [] dy= {0,0,1,-1};
    public static void dfs(int ci,int cj,int cnt)
    {
	max=Math.max(max, cnt);
	for(int k=0;k<4;k++)
	{
	    int ni=ci+dx[k];
	    int nj=cj+dy[k];
	    if(ni<0||ni>=m||nj<0||nj>=n)continue;
	    if(vst[map[ni][nj]-'A']==false)
	    {
		vst[map[ni][nj]-'A']=true;
		dfs(ni,nj,cnt+1);
		vst[map[ni][nj]-'A']=false;
	    }
	}
    }
}
