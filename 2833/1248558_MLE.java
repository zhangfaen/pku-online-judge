import java.io.*;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
public class Main
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String [] sa=br.readLine().split(" +");
			int n1=Integer.parseInt(sa[0]);
			int n2=Integer.parseInt(sa[1]);
			int n=Integer.parseInt(sa[2]);
			if(n1==0&&n2==0&&n==0)
				break;
			sa=br.readLine().split(" +");
			BigDecimal [] bd=new BigDecimal[n];
			for(int i=0;i<n;i++)
				bd[i]=new BigDecimal(sa[i]);
System.gc();
			Arrays.sort(bd);
			int end=n-n1;
			BigDecimal re=new BigDecimal("0");
			for(int i=n2;i<end;i++)
				re=re.add(bd[i]);
			re=re.divide(new BigDecimal(""+(n-n1-n2)),6,BigDecimal.ROUND_HALF_UP);
			System.out.println(re);

		}
	}
	
}
