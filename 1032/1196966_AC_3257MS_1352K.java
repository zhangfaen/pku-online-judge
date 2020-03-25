import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main
{
	static int [] dx={1,1,-1,-1,0,0,1,-1};
	static int [] dy={1,-1,1,-1,1,-1,0,0};
	public static void main(String[] args) throws Exception
	{
		Scanner cin = new Scanner(System.in);
		int [] p=new int[1000];
		int tag=0;
		int n=cin.nextInt();
		for(int i=2;;i++)
		{
			if(n>=i)
			{
				p[tag++]=i;
				n-=i;
			}
			else
			{
				for(int j=tag-1;j>=0;j--)
				{
					if(n>0)
					{
						p[j]++;
						n--;
					}
				}
				if(n>0)
					p[tag-1]++;
				break;
			}
		}
		for(int i=0;i<tag;i++)
			System.out.print(p[i]+" ");
		
	}		
}



