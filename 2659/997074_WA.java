import java.util.*;
import java.io.*;
public class Main
{
	public static int A,B,K;;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner cin=new Scanner(System.in);
		
		A=cin.nextInt();
		B=cin.nextInt();
		K=cin.nextInt();
		Cor.A=A;
		HashSet<Cor> s=new HashSet<Cor>();
		for(int i=0;i<A;i++)
			for(int j=0;j<B;j++)
				s.add(new Cor(i,j));
		
		for(int i=0;i<K;i++)
		{
			int R,S,P,T;
			R=cin.nextInt();
			S=cin.nextInt();
			P=cin.nextInt();
			T=cin.nextInt();
			P=(P-1)/2;
			HashSet<Cor> t=new HashSet<Cor>();
			int xs,ys,xe,ye;
			xs=R-P;
			ys=S-P;
			xe=R+P;
			ye=S+P;
			if(xs<0)
				xs=0;
			if(ys<0)
				ys=0;
			if(xe>=A)
				xe=A-1;
			if(ye>=B)
				ye=B-1;

			for(int m=xs;m<=xe;m++)
				for(int n=ys;n<=ye;n++)
					t.add(new Cor(m,n));
			if(T==1)
				inter(s,t);
			else
				subs(s,t);

		}
		System.out.println(s.size());
		
		
	}
	@SuppressWarnings("unchecked")
	public static void inter(HashSet<Cor> s,HashSet<Cor>t)
	{
		HashSet<Cor> st=(HashSet<Cor>)s.clone();
		st.removeAll(t);
		s.removeAll(st);
	}
	public static void subs(HashSet<Cor> s,HashSet<Cor>t)
	{
		s.removeAll(t);
	}
}
class Cor
{
	int x,y;
	static int A;
	public Cor(int i,int j)
	{
		x=i;
		y=j;
	}
	public int hashCode()
	{
		return x*A+y;
	}
	public boolean equals(Object o)	
	{
		Cor t=(Cor)o;
		return t.x==x&&t.y==y;
	}
}