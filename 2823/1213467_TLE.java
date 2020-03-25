import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;
;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		
		//Scanner cin = new Scanner(new File("c:\\in.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br=new BufferedReader(new FileReader("c:\\in.txt"));
		String [] ss=br.readLine().trim().split(" +");
		int n,w;
		n=Integer.parseInt(ss[0]);
		w=Integer.parseInt(ss[1]);
		int [] max=new int[n];
		int [] min=new int[n];
		int [] all=new int[n];
		ss=br.readLine().trim().split(" +");
		for(int i=0;i<n;i++)
			all[i]=Integer.parseInt(ss[i]);
		ss=null;
		int tag=0;
		int[] sort = new int[w];
		for(int i=0;i<w;i++)
		{
			sort[i] = all[i];
		}
		Arrays.sort(sort);
		for(int i=w;i<n;i++)
		{
			max[tag]=sort[0];
			min[tag]=sort[w - 1];
			tag++;
			int index = Arrays.binarySearch(sort, all[i - w]);
			for(int j = index + 1; j < w; j++)
				sort[j - 1] = sort[j];
			sort[w - 1] = Integer.MAX_VALUE;
			index = Arrays.binarySearch(sort, all[i]);
			
			if(index < 0)
				index = -(index + 1);
			for(int j = w - 1; j > index; j--)
				sort[j] = sort[j - 1];
			sort[index] = all[i];
		}
		max[tag]=sort[0];
		min[tag]=sort[w - 1];
		tag++;
		for(int i=0;i<tag;i++)
		{
			System.out.print(max[i]+" ");
		}
		System.out.println();
		for(int i=0;i<tag;i++)
		{
			System.out.print(min[i]+" ");
		}
		
	}
}

