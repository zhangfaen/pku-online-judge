import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int p[][]=new int[16][3];
		for(int i=0;i<16;i++)
			for(int j=0;j<3;j++)
				p[i][j]=cin.nextInt();
		while(true)
		{
			int r=cin.nextInt(),g=cin.nextInt(),b=cin.nextInt();
			if(r==-1)break;
			double min=Double.MAX_VALUE;
			int index=-1;
			for(int i=0;i<16;i++)
			{
				double temp=Math.sqrt(pow(r-p[i][0])+pow(g-p[i][1])+pow(b-p[i][2]));
				if(temp<=min)
				{
					min=temp;
					index=i;
				}
			}
			System.out.println("("+r+","+g+","+b+") maps to ("+p[index][0]+","+p[index][1]+","+p[index][2]+")");
		}
	}
	public static double pow(int a)
	{
		int t=a*a;
		return (double)t;
	}
}
