import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	

	public static void main(String[] args) throws Exception
	{
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		
		int testcase=1;
		while(true)
		{
			String s=cin.readLine();
			String [] sa=s.split(" +");
			int n=Integer.parseInt(sa[0]);
			int lucky=Integer.parseInt(sa[1]);
			int [] deck=new int[20];
			for(int i=2;i<sa.length;i++)
				deck[i-2]=Integer.parseInt(sa[i]);
			List<Integer> li=new ArrayList<Integer>();
			for(int i=1;i<=n;i++)
				li.add(i);
			int cur=0;
			int curP=0;
			while(li.size()>lucky)
			{
				int cnt=deck[cur];
				cur=(cur+1)%20;
				int ri=cnt-1;
				while(ri<li.size())
				{
					li.remove(ri);
					ri+=cnt-1;
				}
			}
			System.out.println("Selection #"+testcase);
			for(int d:li)System.out.print(d+" ");
			System.out.println();
			testcase++;
		}
		
		
	}

	
}