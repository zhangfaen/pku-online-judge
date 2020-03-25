import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main
{

	
	public static void main(String[] args) throws Exception
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s=cin.readLine();
		String [] sa=s.split(" ");
		int a,b,c;
		a=Integer.parseInt(sa[0]);
		b=Integer.parseInt(sa[1]);
		c=Integer.parseInt(sa[2]);
		int re=Math.min(Math.min(a, b), c);
		out.println(re);
		out.flush();
	}
	

	
}
