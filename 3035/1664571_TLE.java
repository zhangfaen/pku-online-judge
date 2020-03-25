import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	
	static double [][]memo;
	static int[][] map;
	static int k,n,e;
	static int all;
	static int [] sum;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner cin = new Scanner(System.in);
		while(true)
		{
			String[] t = in.readLine().split(" ");
			k=Integer.parseInt(t[0]);
			n=Integer.parseInt(t[1]);
			e=Integer.parseInt(t[2]);
			if(k+n+e==0)
				break;
			all=1<<n;
			memo=new double[1<<n][k];
			map = new int[1<<n][1<<n];
			sum=new int[all];
			for(int i = 0; i < e; i++){
				t = in.readLine().split(" ");
				int a = Integer.parseInt(t[0]);
				int b = Integer.parseInt(t[1]);
				map[a][b]++;
				map[b][a]++;
				sum[a]++;
				sum[b]++;
			}
			for(int i=0;i<(1<<n);i++)
				memo[i][0]=1.0/all;			
			for(int i=1;i<k;i++){
				for(int j=0;j<all;j++)
				{
					for(int g=0;g<all;g++)
					{
						if(j != g && map[j][g]>0)
						{
							memo[j][i]+=memo[g][i-1] * map[j][g]/sum[g];
						}
					}					
				}
			}
			boolean flag = true;
			out:for(int i=0;i<k;i++)
			{			
				for(int g = 0; g < n; g++){
					double re = 0.0;
					for(int j=0;j<all;j++)
					{
						if(((1<<g) & j) != 0)
							re+=memo[j][i];
					}
					if(re <= 0.25 || re >= 0.75){
						System.out.println("No");
						flag = false;
						break out;
					}
				}
			}
			if(flag){
				System.out.println("Yes");
			}
		}
	}
}
