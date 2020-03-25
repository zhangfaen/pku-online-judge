import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)break;
			while(true)
			{
				LinkedList<Integer>pre=new LinkedList<Integer>();
				LinkedList<Integer>stack=new LinkedList<Integer>();
				int t=cin.nextInt();
				if(t==0)
					break;
				pre.addLast(t);
				for(int i=1;i<n;i++)
					pre.addLast(cin.nextInt());
				for(int i=1;i<=n;i++)
				{
					if(new Integer(i).equals(pre.getFirst()))
					{
						pre.removeFirst();
					}
					else
						stack.addFirst(i);
				}
				if(stack.equals(pre))
					System.out.println("Yes");
				else
					System.out.println("No");
				
			}
			System.out.println();
		}
	}

	
}
