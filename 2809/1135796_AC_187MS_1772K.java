import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		int num=cin.nextInt();
		for(int count=1;count<=num;count++)
		{
			int value=cin.nextInt();
			String exp=cin.next();
			String [] expa=(exp.charAt(0)+exp.substring(1).replaceAll("-", "\\+-")).split("\\+");
			List<Term> lt=new ArrayList<Term>();
			for(int i=0;i<expa.length;i++)
			{
				String t=expa[i];
				int a,b;
				if(t.matches("-?[\\d]+"))
				{
					a=Integer.parseInt(t);
					b=0;
				}
				else
				{
					t=t.replaceAll("-x", "-1x");
					t=t.replaceAll("x$", "x1");
					t=t.replaceAll("^x", "1x");
					t=t.replaceAll("\\^", "");
					a=Integer.parseInt(t.split("x")[0]);
					b=Integer.parseInt(t.split("x")[1]);
				}
				lt.add(new Term(a,b));
			}
			for(int i=0;i<lt.size();i++)
			{
				pterm(lt.get(i));
			}
			for(int i=0;i<lt.size();i++)
			{
				if(lt.get(i).cff==0)
				{
					lt.remove(i);
					i--;
				}
			}
			System.out.println("POLYNOMIAL "+count);
			System.out.println(exp);
			print1(lt,value);
		}
	}
	public static void print1(List<Term> lt,int value)
	{
		String re="";
		for(int i=0;i<lt.size();i++)
			re+="+"+lt.get(i);
		if(re.length()>0)
			re=re.substring(1);
		re=re.replaceAll("\\+-", "-");
		if(re.length()>0)
			System.out.println(re);
		else
			System.out.println("0");
		re=re.replaceAll("x", "("+value+")");
		
		if(re.length()>0)
			System.out.println(re);
		else
			System.out.println("0");
		
		re="";
		for(int i=0;i<lt.size();i++)
			re+="+"+lt.get(i).toString(value);
		if(re.length()>0)
			re=re.substring(1);
		else
			re="0";
		re=re.replaceAll("\\+-", "-");
		System.out.println(re);
		int renum=0;
		for(int i=0;i<lt.size();i++)
		{
			Term t=lt.get(i);
			renum+=t.cff*(int)Math.pow(value,t.pow);
		}
		System.out.println(renum);
	}
	public static void pterm(Term term)
	{
		term.cff=term.cff*term.pow;
		term.pow-=1;
	}
}
class Term
{
	int cff;
	int pow;
	public Term(int a,int b)
	{
		cff=a;
		pow=b;
	}
	public String toString()
	{
		String re="";
		if(pow==0)
		{
			re+=cff;
			return re;
		}
		if(cff==1)
			;
		else
		if(cff==-1)
			re+="-";
		else
			re+=cff;
		re+="x";
		if(pow!=1)
			re+="^"+pow;
		return re;
	}
	public String toString(int value)
	{
		return (cff*(int)Math.pow(value, pow))+"";
	}
}