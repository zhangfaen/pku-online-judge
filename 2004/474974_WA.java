import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		ArrayList[] asp=new ArrayList[21];
		HashMap hmsi=new HashMap();
		HashMap hmss=new HashMap();
		for(int i=0;i<21;i++)
			asp[i]=new ArrayList();
		
		int rmax=0;
		String smax="";
		while(cin.hasNext())
		{
			String s=cin.next();
			char [] tc=s.toCharArray();
			Arrays.sort(tc);
			s=String.valueOf(tc);
			int length=s.length();
			asp[length].add(s);
			if(length==1)
			{
				hmsi.put(s,1);
				hmss.put(s,s);
				rmax=1;
				smax=s;
			}
		}
		
		for(int i=2;i<21;i++)
		{
				for(int j=0;j<asp[i].size();j++)
				{
					int tmax=0;
					String ts="$$";
					boolean flag=false;
					for(int k=0;k<asp[i-1].size();k++)
					{
						if(isOk(asp[i].get(j),asp[i-1].get(k)))
						{
							flag=true;
							if(tmax<=((Integer)hmsi.get(asp[i-1].get(k))).intValue())
							{
								tmax=((Integer)hmsi.get(asp[i-1].get(k))).intValue();
								ts=(String)asp[i-1].get(k);
							}
								
						}
							
					}
					if(flag)
					{
						hmsi.put(asp[i].get(j),tmax+1);
						hmss.put(asp[i].get(j),(String)hmss.get(ts)+"#"+(String)asp[i].get(j));
							
						if(tmax+1>=rmax)
						{
							rmax=tmax+1;
							smax=(String)asp[i].get(j);
						}
					}
					else
					{
						hmsi.put(asp[i].get(j),1);
						hmss.put(asp[i].get(j),(String)asp[i].get(j));
						
						if(1>=rmax)
						{
							rmax=1;
							smax=(String)asp[i].get(j);
						}
					}
						
					
				}
			
		}
		String rrs=(String)hmss.get(smax);
		String [] rras=rrs.split("#");
		for(int i=0;i<rras.length;i++)
		{
			System.out.println(rras[i]);
		}
	}
	private static boolean isOk(Object obig,Object osmall)
	{
		String big=(String)obig;
		String small=(String)osmall;
		int begin=0;
		for(int i=0;i<small.length();i++)
		{
			char c=small.charAt(i);
			int index=big.indexOf(c,begin);
			if(index<0)
				return false;
			else
				begin=index+1;

		}
		
		return true;
	}
	
}

