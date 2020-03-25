import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int maxw=cin.nextInt();
			if(maxw==0)break;
			int rw=0,rh=0;
			int cw=0,ch=0;
			while(true)
			{
				int w=cin.nextInt();
				int h=cin.nextInt();
				if(w==-1)break;
				if(cw+w<=maxw)
				{
					cw+=w;
					rw=rw>cw?rw:cw;
					ch=ch<h?h:ch;
				}
				else
				{
					rh+=ch;
					cw=w;
					ch=h;
					rw=rw>cw?rw:cw;

				}
				
			}
			rh+=ch;
			System.out.println(rw+" x "+rh);
		}
	}
	
}

