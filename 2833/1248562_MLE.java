import java.io.*;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
public class Main
{

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br=new BufferedReader(new FileReader("c:\\in.txt"));
		Scanner cin=new Scanner(new BufferedInputStream(System.in));
		while(true)
		{
	
			int n1=cin.nextInt();
			int n2=cin.nextInt();
			int n=cin.nextInt();
			if(n1==0&&n2==0&&n==0)
				break;
			BigDecimal [] bd=new BigDecimal[n];
			for(int i=0;i<n;i++)
				bd[i]=new BigDecimal(cin.next());
			Arrays.sort(bd);
			int end=n-n1;
			BigDecimal re=new BigDecimal("0");
			for(int i=n2;i<end;i++)
				re=re.add(bd[i]);
			re=re.divide(new BigDecimal(""+(n-n1-n2)),6,BigDecimal.ROUND_HALF_UP);
			System.out.println(re);
			System.gc();
		}
	}
	
}
