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
		//BufferedReader br=new BufferedReader(new FileReader("/home/input"));
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
			int index1 = Arrays.binarySearch(sort, all[i - w]);			
			int index2 = Arrays.binarySearch(sort, all[i]);
			if(index2 < 0)
				index2 = 0 - index2 - 1;
			if(index1 == index2)
				sort[index2] = all[i];
			else if(index1 < index2){
				index2--;
				for(int j = index1; j < index2; j++)
					sort[j] = sort[j + 1];
				sort[index2] = all[i];
			}
			else{
				for(int j = index1; j > index2; j--)
					sort[j] = sort[j - 1];
				sort[index2] = all[i];
			}
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
