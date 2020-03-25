import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		while(cin.hasNextInt())
		{
			int n=cin.nextInt();
			int [][]p=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					p[i][j]=cin.nextInt();
			List<Integer> left=new ArrayList<Integer>();
			List<Integer> right=new ArrayList<Integer>();
			left.add(0);
			for(int i=1;i<n;i++)
				right.add(i);
			int sum=0;
			while(right.size()>0)
			{
				int min=Integer.MAX_VALUE;
				int index=-1;
				for(int i=0;i<left.size();i++)
				{
					for(int j=0;j<right.size();j++)
					{
						if(p[left.get(i)][right.get(j)]<min)
						{
							min=p[left.get(i)][right.get(j)];
							index=j;
						}
					}
				}
				sum+=min;
				left.add(right.remove(index));
			}
			System.out.println(sum);
		}
		
	
	}

}