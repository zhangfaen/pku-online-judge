import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int m,n;
		m=cin.nextInt();
		n=cin.nextInt();
		Map<String,Integer> ms=new HashMap<String,Integer>();
		while(m--!=0)
		{
			String s=cin.next();
			int d=cin.nextInt();
			ms.put(s,d);
		}
		while(n--!=0)
		{
			int sum=0;
			while(true)
			{
				String next=cin.next();
				if(next.equals("."))break;
				Integer t=null;
				t=ms.get(next);
				if(t!=null)
					sum+=t;
			}
			System.out.println(sum);
		}
	}
}