import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	static char [][] map;
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		while(true)
		{
			int s=cin.nextInt();
			String n=cin.next();
			if(s==0)break;
			map=new char[s*2+3][(s+2)*n.length()+n.length()-1];
			for(int i=0;i<map.length;i++)
				for(int j=0;j<map[i].length;j++)
					map[i][j]=' ';
			for(int i=0;i<n.length();i++)
			{
				switch(n.charAt(i))
				{
					case '0':
						print0(0,(s+3)*i,s);
						break;
					case '1':
						print1(0,(s+3)*i,s);
						break;
					case '2':
						print2(0,(s+3)*i,s);
						break;
					case '3':
						print3(0,(s+3)*i,s);
						break;
					case '4':
						print4(0,(s+3)*i,s);
						break;
					case '5':
						print5(0,(s+3)*i,s);
						break;
					case '6':
						print6(0,(s+3)*i,s);
						break;
					case '7':
						print7(0,(s+3)*i,s);
						break;
					case '8':
						print8(0,(s+3)*i,s);
						break;
					case '9':
						print9(0,(s+3)*i,s);
						break;
						
				}
			}
			for(int i=0;i<map.length;i++)
			{
				for(int j=0;j<map[i].length;j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
			System.out.println();
		}
	}
	public static void ps(int x,int y,int s)
	{
		for(int i=x;i<x+s;i++)
			map[i][y]='|';
	}
	public static void ph(int x,int y,int s)
	{
		for(int i=y;i<y+s;i++)
			map[x][i]='-';	
	}
	public static void print1(int x,int y,int s)
	{
		//ph(x,y+1,s);
		//ph(x+s+1,y+1,s);
		//ph(x+s+s+2,y+1,s);
		//ps(x+1,y,s);
		ps(x+1,y+s+1,s);
		//ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
	}
	public static void print2(int x,int y,int s)
	{
		
		ph(x,y+1,s);
		ph(x+s+1,y+1,s);
		ph(x+s+s+2,y+1,s);
		//ps(x+1,y,s);
		ps(x+1,y+s+1,s);
		ps(x+s+2,y,s);
		//ps(x+s+2,y+s+1,s);
	}
	public static void print3(int x,int y,int s)
	{
		ph(x,y+1,s);
		ph(x+s+1,y+1,s);
		ph(x+s+s+2,y+1,s);
		//ps(x+1,y,s);
		ps(x+1,y+s+1,s);
		//ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
	}
	public static void print4(int x,int y,int s)
	{
		//ph(x,y+1,s);
		ph(x+s+1,y+1,s);
		//ph(x+s+s+2,y+1,s);
		ps(x+1,y,s);
		ps(x+1,y+s+1,s);
		//ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
		
	}
	public static void print5(int x,int y,int s)
	{
		ph(x,y+1,s);
		ph(x+s+1,y+1,s);
		ph(x+s+s+2,y+1,s);
		ps(x+1,y,s);
		//ps(x+1,y+s+1,s);
		//ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
	}
	public static void print6(int x,int y,int s)
	{
		ph(x,y+1,s);
		ph(x+s+1,y+1,s);
		ph(x+s+s+2,y+1,s);
		ps(x+1,y,s);
		//ps(x+1,y+s+1,s);
		ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
	}
	public static void print7(int x,int y,int s)
	{
		ph(x,y+1,s);
		//ph(x+s+1,y+1,s);
		//ph(x+s+s+2,y+1,s);
		//ps(x+1,y,s);
		ps(x+1,y+s+1,s);
		//ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
	}
	public static void print8(int x,int y,int s)
	{
		ph(x,y+1,s);
		ph(x+s+1,y+1,s);
		ph(x+s+s+2,y+1,s);
		ps(x+1,y,s);
		ps(x+1,y+s+1,s);
		ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
	}
	public static void print9(int x,int y,int s)
	{
		ph(x,y+1,s);
		ph(x+s+1,y+1,s);
		ph(x+s+s+2,y+1,s);
		ps(x+1,y,s);
		ps(x+1,y+s+1,s);
		//ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
	}
	public static void print0(int x,int y,int s)
	{
		ph(x,y+1,s);
		//ph(x+s+1,y+1,s);
		ph(x+s+s+2,y+1,s);
		ps(x+1,y,s);
		ps(x+1,y+s+1,s);
		ps(x+s+2,y,s);
		ps(x+s+2,y+s+1,s);
	}
}
