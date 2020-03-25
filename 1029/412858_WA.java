import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int k=cin.nextInt();
		HashSet<Integer>heavy=new HashSet<Integer>();
		HashSet<Integer>light=new HashSet<Integer>();
		HashSet<Integer>ok=new HashSet<Integer>();
		HashSet<Integer>total=new HashSet<Integer>();
		for(int i=1;i<=n;i++)
			total.add(i);
		while(k--!=0)
		{
			int num=cin.nextInt();
			HashSet<Integer>left=new HashSet<Integer>();
			HashSet<Integer>right=new HashSet<Integer>();
			for(int i=0;i<num;i++)
			{
				left.add(cin.nextInt());
			}
			for(int i=0;i<num;i++)
			{
				right.add(cin.nextInt());
			}
			String s=cin.next();
			if(s.equals(">"))
			{
				heavy.addAll(left);
				light.addAll(right);
			}
			else
				if(s.equals("<"))
				{
					heavy.addAll(right);
					light.addAll(left);
				}
				else
				{
					ok.addAll(left);
					ok.addAll(right);
				}
			HashSet<Integer>inter=intersect(heavy,light);
			heavy.removeAll(inter);
			light.removeAll(inter);
			ok.addAll(inter);
			
			inter=intersect(ok,heavy);
			ok.addAll(inter);
			heavy.removeAll(inter);
			
			inter=intersect(ok,light);
			ok.addAll(inter);
			light.removeAll(inter);
		}
		if(light.size()==1&&heavy.size()==0)
		{
			System.out.println(light.iterator().next());
		}
		else
			if(light.size()==0&&heavy.size()==1)
			{
				System.out.println(heavy.iterator().next());
			}
			else
				if(total.size()-ok.size()==1)
				{
					total.removeAll(ok);
					System.out.println(total.iterator().next());
				}
				else
					System.out.println(0);
	}
	public static HashSet<Integer> intersect(HashSet<Integer>a,HashSet<Integer>b)
	{
		HashSet<Integer>back=(HashSet<Integer>)a.clone();
		back.retainAll(b);
		return back;
		
	}
}
