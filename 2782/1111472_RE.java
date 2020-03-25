package fafa;
import java.io.File;
import java.util.*;
public class Main
{
	public static void main(String [] args) throws Exception
	{
	
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int len=cin.nextInt();
		List<Integer> p=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
			p.add(cin.nextInt());
		Collections.sort(p);
		int sum=0;
		while(p.size()>0)
		{
			int t=p.remove(p.size()-1);
			sum++;
			if(p.size()==0)
				break;
			
			int tl=len-t;
			int index=Collections.binarySearch(p,tl);
			if(index>=0)
			{
				p.remove(index);
			}
			else
			{
				index=Math.abs(index)-2;
				if(index>=0)
					p.remove(index);
			}
		}
		System.out.println(sum);
		
		
	}
}


