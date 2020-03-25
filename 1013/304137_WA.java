import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static Set<Character> heavy=new HashSet<Character>();
	public static Set<Character> light=new HashSet<Character>();
	public static Set<Character> ok=new HashSet<Character>();
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
	//	Scanner cin=new Scanner(new File("c:\\fafa.txt"));
		int n=cin.nextInt();
		while(n--!=0)
		{
			heavy.clear();
			ok.clear();
			light.clear();

			for(int i=0;i<3;i++)
			{
				String left=cin.next();
				String right=cin.next();
				String result=cin.next();
				if(left.equals(right))
					continue;
				if(result.equals("even"))
				{
					even(left,right);
				}
				if(result.equals("up"))
				{
					up(left,right);
				}
				if(result.equals("down"))
				{
					String temp=left;
					left=right;
					right=temp;
					up(left,right);
				}
				//System.out.println(light+"  "+heavy+"  "+ok);
				
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
	public static void even(String left,String right)
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
	public static void up(String left,String right)
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
		Set<Character>tmp_l=new HashSet<Character>();
		Set<Character>tmp_r=new HashSet<Character>();
		for(int i=0;i<left.length();i++)
			tmp_l.add(left.charAt(i));
		for(int i=0;i<right.length();i++)
			tmp_r.add(right.charAt(i));
		ok.addAll(huan_he(tmp_r,light));
		ok.addAll(huan_he(tmp_l,heavy));
		light=intersect(tmp_r,light);
		heavy=intersect(tmp_l,heavy);
			
				
		
	}
	public static Set<Character> intersect(Set<Character>sc1,Set<Character>sc2)
	{
		Set<Character> temp=new HashSet<Character>();
		Iterator it=sc1.iterator();
		while(it.hasNext())
		{
			Character o=(Character)it.next();
			if(sc2.contains(o))
			{
				temp.add(o);
			}
		}
		return temp;
	}
	public static Set<Character> huan_he(Set<Character>sc1,Set<Character>sc2)
	{
		Set<Character> temp=new HashSet<Character>();
		temp.addAll(sc1);
		temp.addAll(sc2);
		temp.removeAll(intersect(sc1,sc2));
		return temp;
	}


	
	
}
