import java.util.*;
import java.io.*;
public class Main
{
	static int [][] p;
	static int num;
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int total=cin.nextInt()*1000;
		num=cin.nextInt();
		p=new int[num][2];
		for(int i=0;i<num;i++)
		{
			p[i][0]=cin.nextInt();
			p[i][1]=cin.nextInt();
		}
		int rest=Integer.MAX_VALUE;
		for(int i=0;i<num;i++)
		{
			int minb=total/p[i][0];
			if(minb*p[i][1]<=total)
			{
				if(total-minb*p[i][1]<rest)
					rest=total-minb*p[i][1];
			}
			else
				rest=0;
		}
		System.out.println(rest);
		
	}

}