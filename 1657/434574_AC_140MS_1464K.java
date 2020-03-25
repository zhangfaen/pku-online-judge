import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		while(T--!=0)
		{
			String s=cin.next();
			String t=cin.next();
			int x1=s.charAt(0)-'a';
			int y1=s.charAt(1)-'0';
			int x2=t.charAt(0)-'a';
			int y2=t.charAt(1)-'0';
			System.out.print(wang(x1,y1,x2,y2)+" ");
			System.out.print(hou(x1,y1,x2,y2)+" ");
			System.out.print(ju(x1,y1,x2,y2)+" ");
			if(xiang(x1,y1,x2,y2)>=0)
				System.out.print(xiang(x1,y1,x2,y2));
			else
				System.out.print("Inf");
			System.out.println();
		}	
	}
	private static int wang(int x1,int y1,int x2,int y2)
	{
		if(x1==x2&&y1==y2)
			return 0;
		return Math.max(Math.abs(x1-x2),Math.abs(y1-y2));
	}
	private static int hou(int x1,int y1,int x2,int y2)
	{
		if(x1==x2&&y1==y2)
			return 0;
		if(x1==x2||y1==y2)
			return 1;
		if(Math.abs(x1-x2)==Math.abs(y1-y2))
			return 1;
		return 2;
	}
	private static int ju(int x1,int y1,int x2,int y2)
	{
		if(x1==x2&&y1==y2)
			return 0;
		if(x1==x2||y1==y2)
			return 1;		
		return 2;
	}
	private static int xiang (int x1,int y1,int x2,int y2)
	{
		if(x1==x2&&y1==y2)
			return 0;
		if((Math.abs(x1-x2)-Math.abs(y1-y2))%2!=0)
			return -1;
		if(Math.abs(x1-x2)==Math.abs(y1-y2))
			return 1;
		return 2;
	}
}