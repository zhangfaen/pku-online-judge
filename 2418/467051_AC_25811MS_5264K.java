import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int sum=0;
		Map<String,Integer> ms=new TreeMap<String,Integer>();
		while(cin.hasNextLine())
		{
			sum++;
			String t=cin.nextLine();
			Integer d=ms.get(t);
			if(d==null)d=new Integer(0);
			ms.put(t,d+1);
		}
		Set<Map.Entry<String,Integer> > rs=ms.entrySet();
		Iterator<Map.Entry<String,Integer>> it=rs.iterator();
		while(it.hasNext())
		{
			Map.Entry entry=it.next();
			System.out.printf("%s %.4f\n",entry.getKey(),((Integer)(entry.getValue())).intValue()/(double)sum*100);
		}
		
	}
}