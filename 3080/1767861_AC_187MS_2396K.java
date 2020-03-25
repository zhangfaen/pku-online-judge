import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int ts=cin.nextInt();
		while(ts-->0)
		{
			int n=cin.nextInt();
			String [] ds=new String[n];
			for(int i=0;i<n;i++)
				ds[i]=cin.next();
			String res="Z";
			for(int i=0;i<60;i++)
			{
				for(int j=i+2;j<60;j++)
				{
					String tpl=ds[0].substring(i,j+1);
					boolean ok=true;
					for(int k=1;k<n;k++)
					{
						if(ds[k].indexOf(tpl)<0)
						{
							ok=false;
							break;
						}
					}
					if(ok)
					{
						if(tpl.length()>res.length())
							res=tpl;
						else if(tpl.length()==res.length())
						{
							int cmp=res.compareTo(tpl);
							if(cmp>0)
							{
								res=tpl;
							}
						}
							
					}
				}
			}
			if(res.length()>=3)
			{
				System.out.println(res);
			}
			else
			{
				System.out.println("no significant commonalities");
			}
		}
	}
}
