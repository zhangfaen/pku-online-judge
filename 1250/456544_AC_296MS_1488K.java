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
			int n=cin.nextInt();
			if(n==0)break;
			String s=cin.next();
			LinkedList<Character>cus=new LinkedList<Character>();
			for(int i=0;i<s.length();i++)
				cus.addLast(s.charAt(i));
			LinkedList<Character>tan=new LinkedList<Character>();
			int sum=0;
			while(cus.size()>0)
			{
				char c=cus.removeFirst();
				if(tan.indexOf(new Character(c))>=0)
				{
					tan.remove(new Character(c));
				}
				else
					if(tan.size()<n)
						tan.addLast(c);
					else
					{
						cus.remove(new Character(c));
						sum++;
					}
			}
			if(sum==0)
				System.out.println("All customers tanned successfully.");
			else
				System.out.println(sum+" customer(s) walked away.");
			
		}
	} 

	
}
