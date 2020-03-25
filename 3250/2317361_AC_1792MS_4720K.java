import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Main
{
	static BufferedReader cin = null;
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception
	{
		cin = new BufferedReader(new InputStreamReader(System.in));
		String s=cin.readLine();
		int n=Integer.parseInt(s);
		int [] p=new int[n];
		for(int i=0;i<n;i++)
		{
			s=cin.readLine();
			p[i]=Integer.parseInt(s);
		}
		List<Integer> stack=new LinkedList<Integer>();
		long res=0;
		for(int i=0;i<n;i++)
		{
			if(stack.size()==0)
			{
				stack.add(0, p[i]);
			}
			else
			{
				while(stack.size()>0&&stack.get(0)<=p[i])
					stack.remove(0);
				res+=stack.size();
				stack.add(0,p[i]);
			}
		}
		System.out.println(res);
	}
	
}
