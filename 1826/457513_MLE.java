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
			HashMap<Cor,Integer> p=new HashMap<Cor,Integer>();
			HashSet<Cor> hs=new HashSet<Cor>();
			for(int i=0;i<n;i++)
			{
				int x=cin.nextInt();
				int y=cin.nextInt();
				int value=cin.nextInt();
				p.put(new Cor(x,y),new Integer(value));
				hs.add(new Cor(x,y));	
			}
			int max=0;
			while(hs.size()>0)
			{
				Cor wc=hs.iterator().next();
				hs.remove(wc);
				LinkedList<Cor>deque=new LinkedList<Cor>();
				int tsum=0;
				deque.addLast(wc);
				while(deque.size()>0)
				{
					Cor ic=deque.removeFirst();
					tsum+=p.get(ic);
					Cor icu=new Cor(ic.x,ic.y+1);
					Cor icd=new Cor(ic.x,ic.y-1);
					Cor icl=new Cor(ic.x-1,ic.y);
					Cor icr=new Cor(ic.x+1,ic.y);
					if(hs.contains(icu))
					{
						hs.remove(icu);
						deque.add(icu);
					}
					if(hs.contains(icd))
					{
						hs.remove(icd);
						deque.add(icd);
					}
					if(hs.contains(icl))
					{
						hs.remove(icl);
						deque.add(icl);
					}
					if(hs.contains(icr))
					{
						hs.remove(icr);
						deque.add(icr);
					}
				}
				if(tsum>max)max=tsum;
				
			}
			System.out.println(max);	
		}
		
	
	
	}

}
class Cor
{
	public int x,y;
	public Cor(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public boolean equals(Object o)
	{
		Cor t=(Cor)o;
		return x==t.x&&y==t.y;
	}
	public int hashCode()
	{
		return new Integer(x).hashCode();
	}
}