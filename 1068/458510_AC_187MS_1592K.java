import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)
	{
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
			LinkedList<Integer> lc=new LinkedList<Integer>();
			int level=1;
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='(')
					lc.addFirst(i);
				else
				{
					int index=lc.removeFirst();
					System.out.print((i-index+1)/2+" ");
					
				}
					
			}
			System.out.println();
		}
	}

}

