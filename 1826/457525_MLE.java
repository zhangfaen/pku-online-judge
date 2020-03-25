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
			HashMap<Cor,Short> p=new HashMap<Cor,Short>();
			HashSet<Cor> hs=new HashSet<Cor>();
			for(int i=0;i<n;i++)
			{
				short x=cin.nextShort();
				short y=cin.nextShort();
				short value=cin.nextShort();
				p.put(new Cor(x,y),new Short(value));
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
					Cor icu=new Cor(ic.x,(short)(ic.y+1));
					Cor icd=new Cor(ic.x,(short)(ic.y-1));
					Cor icl=new Cor((short)(ic.x-1),(short)(ic.y));
					Cor icr=new Cor((short)(ic.x+1),(short)(ic.y));
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
	public short x,y;
	public Cor(short x,short y)
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
		return new Short(x).hashCode();
	}
}