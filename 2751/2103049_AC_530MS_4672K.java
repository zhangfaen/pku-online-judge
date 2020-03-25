import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{
	
	static class Task
	{
		int index;
		int t1;
		int t2;
		public Task(int index,int t1,int t2)
		{
			this.index=index;
			this.t1=t1;
			this.t2=t2;
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String s=cin.readLine();
			int n=Integer.parseInt(s);
			if(n==0)break;
			List<Task> list1=new ArrayList<Task>(n);
			List<Task> list2=new ArrayList<Task>(n);
			for(int i=0;i<n;i++)
			{
				s=cin.readLine();
				String [] sa=s.split(" ");
				int t1=Integer.parseInt(sa[0]);
				int t2=Integer.parseInt(sa[1]);
				Task task=new Task(i,t1,t2);
				if(t1<t2)
				{
					list1.add(task);
				}
				else
					list2.add(task);
			}
			Collections.sort(list1,new Comparator<Task>() {

				public int compare(Task o1, Task o2)
				{
					return o1.t1-o2.t1;
				}});
			Collections.sort(list2,new Comparator<Task>() {

				public int compare(Task o1, Task o2)
				{
					return o2.t2-o1.t2;
				}});
			List<Task>list=new ArrayList<Task>(n);
			for(Task t:list1)list.add(t);
			for(Task t:list2)list.add(t);
			int [] start=new int[list.size()];
			start[0]=list.get(0).t1;
			for(int i=1;i<list.size();i++)
				start[i]=start[i-1]+list.get(i).t1;
			int cur=0;
			for(int i=0;i<list.size();i++)
			{
				int s2=Math.max(cur, start[i]);
				s2+=list.get(i).t2;
				cur=s2;
			}
			System.out.println(cur);
		}
		out.flush();
		out.close();
	}
}