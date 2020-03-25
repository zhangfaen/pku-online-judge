import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		while(n--!=0)
		{
			HashSet<Character> full=new HashSet<Character>();
			for(int i=0;i<12;i++)
				full.add((char)('A'+i));
			HashSet<Character> light=new HashSet<Character>();
			HashSet<Character> heavy=new HashSet<Character>();
			HashSet<Character> ok=new HashSet<Character>();
			for(int j=0;j<3;j++)
			{
				String sl=cin.next();
				String sr=cin.next();
				String slr=cin.next();
				if(slr.equals("even"))
				{
					for(int i=0;i<sl.length();i++)
					{
						ok.add(sl.charAt(i));
						ok.add(sr.charAt(i));
					}
				}
				else
				if(slr.equals("up"))
				{
					for(int i=0;i<sl.length();i++)
					{
						char c=sl.charAt(i);
						if(light.contains(c))
						{
							ok.add(c);
							light.remove(c);
						}
						else
						{
							heavy.add(c);
						}
					}
					for(int i=0;i<sr.length();i++)
					{
						char c=sr.charAt(i);
						if(heavy.contains(c))
						{
							ok.add(c);
							heavy.remove(c);
						}
						else
						{
							light.add(c);
						}
					}
				}
				else
				{
					String t=sl;
					sl=sr;
					sr=t;
					
					for(int i=0;i<sl.length();i++)
					{
						char c=sl.charAt(i);
						if(light.contains(c))
						{
							ok.add(c);
							light.remove(c);
						}
						else
						{
							heavy.add(c);
						}
					}
					for(int i=0;i<sr.length();i++)
					{
						char c=sr.charAt(i);
						if(heavy.contains(c))
						{
							ok.add(c);
							heavy.remove(c);
						}
						else
						{
							light.add(c);
						}
					}
					
				}
				
				
			}
			
			light.removeAll(ok);
			heavy.removeAll(ok);
			light.removeAll(full);
			heavy.removeAll(full);
			if(light.size()>1&&heavy.size()>1)
				throw new IOException();
			if(light.size()==1)
			{
				Iterator it=light.iterator();
				System.out.println(it.next()+" is the counterfeit coin and it is light.");
			}
			else
			if(heavy.size()==1)
			{
				Iterator it=heavy.iterator();
				System.out.println(it.next()+" is the counterfeit coin and it is heavy.");
			}
		
		}
	
	}
}
