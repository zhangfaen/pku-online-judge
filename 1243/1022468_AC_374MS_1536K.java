import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{

	public static int[][]p=new int [31][31];
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		int tag=0;
		for(int i=0;i<31;i++)
			for(int j=0;j<31;j++)
				p[i][j]=-1;
		while(true)
		{
			
			int x,y;
			x=cin.nextInt();
			y=cin.nextInt();
			if(x+y==0)
				break;
			tag++;
			System.out.println("Case "+tag+": "+f(x,y));
		}

		

	}

	public static int f(int x,int y)
	{
		
		if(p[x][y]!=-1)
			return p[x][y];
		if(y==0)
			return p[x][y]=x;
		if(x<y)
		{
			return p[x][y]=f(x,x);
		}
		return p[x][y]=f(x-1,y-1)+1+f(x-1,y);
	}
}
