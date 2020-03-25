import java.io.*;
import java.util.LinkedList;
import java.util.*;
import java.util.Scanner;
public class Main
{
	static int [] dx={1,1,-1,-1,0,0,1,-1};
	static int [] dy={1,-1,1,-1,1,-1,0,0};
	public static void main(String[] args) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(br.readLine());
		int [] mp=new int[m];
		for(int i=0;i<m;i++)
		{
			mp[i]=Integer.parseInt(br.readLine());
		}
		int n=Integer.parseInt(br.readLine());
		int [] np=new int[n];
		for(int i=n-1;i>=0;i--)
		{
			np[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<m;i++)
		{
			int t=10000-mp[i];
			int index=Arrays.binarySearch(np,t);
			if(index>=0)
			{
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}		
}



