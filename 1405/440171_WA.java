import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		Fen [] p=new Fen[n];
		p[0]=new Fen(1,2);
		Fen sum=new Fen(1,2);
		for(int i=1;i<n;i++)
		{
			for(int j=p[i-1].b;true;j++)
			{
				Fen t=sum.add(1,j);
				if(!t.isDayu1())
				{
					p[i]=new Fen(1,j);
					sum=t;
					break;
				}
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(p[i].b);
	}
	
}
class Fen
{
	int a;
	int b;
	public Fen()
	{
		
	}
	public Fen(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	public boolean isDayu1()
	{
		if(a>=b)return true;
		return false;
	}
	public Fen add(int c,int d)
	{
		int bei=Yue.bei(b,d);
		return new Fen(a*bei/b+c*bei/d,bei);
	}
	public String toString()
	{
		return ""+a+"/"+b;
	}

}
class Yue
{
	public static int yue(int a,int b)
	{
		if(a<b){
			int t=a;a=b;b=t;
		}
		while(b!=0)
		{
			int t=a%b;
			a=b;
			b=t;
		}
		return a;
	}
	public static int bei(int a,int b)
	{
		return a*b/yue(a,b);
	}
}