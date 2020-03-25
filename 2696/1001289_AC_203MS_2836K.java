import java.util.*;
import java.io.*;
public class Main
{
	static int a,b,c,d,e,f,g,h,i;
	static int [] p=new int[1001] ;
	public static void main(String [] args) throws FileNotFoundException
	{
		
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			for(int i=0;i<1001;i++)
				p[i]=-11111;
			a=cin.nextInt();b=cin.nextInt();c=cin.nextInt();
			d=cin.nextInt();e=cin.nextInt();f=cin.nextInt();
			g=cin.nextInt();h=cin.nextInt();i=cin.nextInt();
			System.out.println(get(i));
		}
		
	}
	public static int get(int x)
	{
		if(p[x]!=-11111)
			return p[x];
		if(x==0)
			return a;
		if(x==1)
			return b;
		if(x==2)
			return c;
		if(x%2==0)
		{
			p[x]=(f*get(x-1)-d*get(x-2)+e*get(x-3))%h;
			if(p[x]<0)
				p[x]+=h;
			return p[x];
		}
		p[x]=(d*get(x-1)+e*get(x-2)-f*get(x-3))%g;
		if(p[x]<0)
			p[x]+=g;
		return p[x];
	}
}
