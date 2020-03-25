import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		//Scanner cin=new Scanner(new File("c:\\fafa.txt"));
		int n=cin.nextInt();
		while(n--!=0)
		{
			Set<Character> heavy=new HashSet<Character>();
			Set<Character> light=new HashSet<Character>();
			Set<Character> ok=new HashSet<Character>();
			for(int i=0;i<3;i++)
			{
				String left=cin.next();
				String right=cin.next();
				String result=cin.next();
				if(result.equals("even"))
				{
					even(left,right,heavy,light,ok);
				}
				if(result.equals("up"))
				{
					up(left,right,heavy,light,ok);
				}
				if(result.equals("down"))
				{
					String temp=left;
					left=right;
					right=temp;
					up(left,right,heavy,light,ok);
				}
			//	System.out.println(heavy+"  "+light+"  "+ok);
				
			}
			if(light.size()>0)
			{
				System.out.println(light.iterator().next()+" is the counterfeit coin and it is light.");
			}
			if(heavy.size()>0)
			{
				System.out.println(heavy.iterator().next()+" is the counterfeit coin and it is heavy.");
			}
		}
	}
	public static void even(String left,String right,Set<Character> heavy,Set<Character> light,Set<Character> ok)
	{
		for(int i=0;i<left.length();i++)
		{
			ok.add(left.charAt(i));
			ok.add(right.charAt(i));
		}
		for(Iterator ito=ok.iterator();ito.hasNext();)
		{
			Character c=(Character)ito.next();
			for(Iterator ith=heavy.iterator();ith.hasNext();)
			{
				if(ith.next().equals(c))
					ith.remove();
			}
			for(Iterator itl=light.iterator();itl.hasNext();)
			{
				if(itl.next().equals(c))
					itl.remove();
			}
			
		}
	}
	public static void up(String left,String right,Set<Character> heavy,Set<Character> light,Set<Character> ok)
	{
		for(int i=0;i<right.length();i++)
		{
			if(ok.contains(new Character(right.charAt(i))))
				continue;
			if(heavy.contains(new Character(right.charAt(i))))	
			{
				ok.add(right.charAt(i));
				heavy.remove(new Character(right.charAt(i)));
			}
			else
				light.add(right.charAt(i));
		}
		for(int i=0;i<left.length();i++)
		{
			if(ok.contains(new Character(left.charAt(i))))
				continue;
			if(light.contains(new Character(left.charAt(i))))	
			{
				ok.add(left.charAt(i));
				light.remove(new Character(left.charAt(i)));
			}
			else
				heavy.add(left.charAt(i));
		}
	}

	
	
}
