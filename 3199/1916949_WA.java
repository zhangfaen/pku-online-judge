import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		String[] sa = null;
		while (true)
		{
			s = in.readLine();
			sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int d=Integer.parseInt(sa[1]);
			if(n+d==0)break;
			long re=1;
			while(d-->0)
				re*=n;
			System.out.println(re);
		}
	}
	
}
