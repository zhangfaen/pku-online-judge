import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.NumberFormat;
public class Main
{

	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==-1)break;
			HashSet<Integer>hi=new HashSet<Integer>();
			hi.add(n);
			while(true)
			{
				n=cin.nextInt();
				if(n==0)break;
				hi.add(n);
			}
			int sum=0;
			Iterator<Integer>it=hi.iterator();
			while(it.hasNext())
			{
				int t=it.next()*2;
				if(hi.contains(t))
					sum++;
			}
			System.out.println(sum);
		}
		
	}
}