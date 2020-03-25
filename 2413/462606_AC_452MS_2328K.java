import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		Scanner cin=new Scanner(System.in);
		LinkedList<BigInteger> lb=new LinkedList<BigInteger>();
		lb.addLast(new BigInteger("1"));
		lb.addLast(new BigInteger("2"));
		String ss="1";
		for(int i=0;i<100;i++)
			ss+="0";
		BigInteger end=new BigInteger(ss);
		while(true)
		{
			BigInteger t=(lb.get(lb.size()-1)).add(lb.get(lb.size()-2));
			if(t.compareTo(end)<0)
				lb.addLast(t);
			else
				break;
		}		
		while(true)
		{
			String s=cin.next();
			String t=cin.next();
			if(s.equals("0")&&t.equals("0"))break;
			BigInteger bs=new BigInteger(s);
			BigInteger bt=new BigInteger(t);
			int sum=0;
			int i,j;
			for(i=0;i<lb.size();i++)
				if(lb.get(i).compareTo(bs)<0);
				else break;
			for(j=i;j<lb.size();j++)
				if(bt.compareTo(lb.get(j))>=0);
				else break;
			System.out.println(j-i);
		}
	}



	
}