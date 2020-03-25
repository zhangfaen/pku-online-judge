import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws IOException
	{
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		Scanner cin=new Scanner(System.in);
		int testcase = cin.nextInt();
		while(testcase-- != 0){
			int n = cin.nextInt();
			int r = cin.nextInt();
			int[][] map = new int[n + 2][n + 2];
			boolean[][][] vis = new boolean[n + 1][n + 1][4];
			for(int i = 0; i < r; i++){
				int x = cin.nextInt();
				int y = cin.nextInt();
				map[x][y] = 1;
			}
			int posx = cin.nextInt();
			int posy = cin.nextInt();
			int direct = -1;
			if(posy == 0)
				direct = 1;
			if(posy == n + 1)
				direct = 3;
			if(posx == 0)
				direct = 2;
			if(posx == n + 1)
				direct = 0;
			//System.out.println("hi:" + posx + " " + posy);
			int tx = posx;
			int ty = posy;
			while(true){
				tx = tx + dx[direct];
				ty = ty + dy[direct];
				if(tx < 1 || ty < 1 || tx > n || ty > n){
					System.out.println(tx + " " + ty);
					break;
				}
				else if(vis[tx][ty][direct]){
					System.out.println("0 0");
					break;
				}
				else if(map[tx][ty] == 1){
					vis[tx][ty][direct] = true;
					direct = (direct + 1) % 4;
				}
			}
		} 
		
	}


}
