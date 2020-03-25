import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class Main
{
	
	public static void main(String[] args) throws Exception
	{
		
		Scanner cin = new Scanner(System.in);
		int n=cin.nextInt();
		int k=cin.nextInt();
		
		TreeSet<Integer> hi=new TreeSet<Integer>();
		int [] map=new int[n];
		for(int i=0;i<n;i++)
			map[i]=cin.nextInt();
		hi.add(((map[0]%k)+k)%k);
		boolean isok=false;
		while(hi.size()>0)
		{
			int t=hi.last();
			hi.remove(t);
			int hou=t%1000;
			int qian=t/1000;
			if(qian==n-1)
			{
				if(hou==0)
				{
					isok=true;
					break;
				}
				
			}
			else
			{
				qian++;
				hi.add(qian*1000+(((hou+map[qian])%k+k)%k));
				hi.add(qian*1000+(((hou-map[qian])%k+k)%k));
			}
			
			
		}
		
		if(isok)
			System.out.println("Divisible");
		else
			System.out.println("Not divisible");
	}
}
