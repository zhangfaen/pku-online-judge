import java.io.*;
import java.util.*;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader cin=new BufferedReader(new InputStreamReader(new FileInputStream("c:\\in.txt")));
		String s=cin.readLine();
		int T=Integer.valueOf(s);
		while(T--!=0)
		{
			int x=0,y=0;
			int xx,yy;
			long area=0;
			long half=0;
			while(true)
			{
				char c=(char)cin.read();
				if(c=='5') break;
				else if(c=='8') {xx=x; yy=y+1;}
				else if(c=='2') {xx=x; yy=y-1;}
				else if(c=='6') {xx=x+1; yy=y;}
				else if(c=='4') {xx=x-1; yy=y;}
				else if(c=='9') {xx=x+1; yy=y+1;}
				else if(c=='7') {xx=x-1; yy=y+1;}
				else if(c=='3') {xx=x+1; yy=y-1;}
				else {xx=x-1; yy=y-1;}
				
				int t=x*yy-xx*y;
				area=area+t;

				x=xx;
				y=yy;
			}
			area=Math.abs(area);
			if(area%2==0)
			{
				System.out.println(area/2);
			}					
			else
				System.out.println((area/2)+".5");
					
		}
		
	}

}