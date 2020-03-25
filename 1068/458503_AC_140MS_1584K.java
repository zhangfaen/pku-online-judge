import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int t=cin.nextInt();
		while(t--!=0)
		{
			int n=cin.nextInt();
			String s="";
			int p=0;
			for(int i=0;i<n;i++)
			{
				int q=cin.nextInt();
				for(int j=0;j<q-p;j++)
					s+="(";
				s+=")";
				p=q;
			}
		//	System.out.println(s);
			LinkedList<Char> lc=new LinkedList<Char>();
			int level=1;
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='(')
				{
					lc.addFirst(new Char(s.charAt(i),i));
				}
				else
				{
					int index=lc.removeFirst().index;;
					System.out.print((i-index+1)/2+" ");
					
				}
					
			}
			System.out.println();
		}
	}

}
class Char
{
	char c;
	int index;
	public Char(char a,int b)
	{
		c=a;
		index=b;
	}
}
