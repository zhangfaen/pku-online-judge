import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int filedX=cin.nextInt();
		int filedY=cin.nextInt();
		int n=cin.nextInt();
		int leftX=Integer.MAX_VALUE;
		int downY=Integer.MAX_VALUE;
		int rightX=Integer.MIN_VALUE;
		int upY=Integer.MIN_VALUE;
		while(n--!=0)
		{
			int x=cin.nextInt();
			int y=cin.nextInt();
			int r=cin.nextInt();
			if(leftX>x-r)
				leftX=x-r;
			if(downY>y-r)
				downY=y-r;
			if(rightX<x+r)
				rightX=x+r;
			if(upY<y+r)
				upY=y+r;
		}
		System.out.println((filedX*filedY)-(rightX-leftX)*(upY-downY));
	}
}

