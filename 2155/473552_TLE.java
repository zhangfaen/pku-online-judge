import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int testcase=cin.nextInt();
		while(testcase--!=0)
		{
			int n=cin.nextInt();
			int t=cin.nextInt();
			byte [][] p=new byte[n+1][n+1];
			while(t--!=0)
			{
				String instr=cin.next();
				if(instr.equals("C"))
				{
					int a,b,c,d;
					a=cin.nextInt();
					b=cin.nextInt();
					c=cin.nextInt();
					d=cin.nextInt();
					for(int i=a;i<=c;i++)
						for(int j=b;j<=d;j++)
							p[i][j]=(byte)((p[i][j]+1)%2);
					
				}
				else
				{
					int x,y;
					x=cin.nextInt();
					y=cin.nextInt();
					System.out.println(p[x][y]);
				}
			}
			System.out.println();
		}
	}
			
	
}
