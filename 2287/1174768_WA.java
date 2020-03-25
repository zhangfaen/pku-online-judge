import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			int n=cin.nextInt();
			if(n==0)
				break;
			List<Integer> li1=new ArrayList<Integer>();
			List<Integer> li2=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				li1.add(cin.nextInt());
			}
			for(int i=0;i<n;i++)
			{
				li2.add(cin.nextInt());
			}
			Collections.sort(li1);
			Collections.sort(li2);
			while(li1.size()>0)
			{
				boolean isok=false;
				for(int i=li1.size()-1;i>=0;i--)
				{
					if(li1.get(i)<li2.get(i))
					{
						isok=true;
						break;
					}
				}
				if(isok)
				{
					li1.remove(0);
					li2.remove(li2.size()-1);
				}
				else
					break;
			}
			int t=0;
			for(int i=0;i<li1.size();i++)
				if(li1.get(i)!=li2.get(i))
					t++;
			System.out.println((t+li1.size()-n)*200);
		}
	}
	
}
