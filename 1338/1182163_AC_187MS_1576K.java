import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		List<Long> li=new ArrayList<Long>();
		PriorityQueue<Long> pqi=new PriorityQueue<Long>();
		pqi.add((long)1);
		long t,tf=-1;
		while(li.size()<1500)
		{
			t=pqi.remove();
			if(t==tf)
				continue;
			
			li.add(t);
			pqi.add(t*2);
			pqi.add(t*3);
			pqi.add(t*5);
			tf=t;
		}
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)
				break;
			System.out.println(li.get(n-1));
	
		}
	}



}
