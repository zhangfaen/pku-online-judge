import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
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
				int a=0,b=0;
				if(t.matches("-?[\\d]+"))
					a=Integer.parseInt(t);
				else
				{
					t=t.replaceAll("-x", "-1x");
					t=t.replaceAll("x$", "x1");
					t=t.replaceAll("^x", "1x");
					t=t.replaceAll("\\^", "");
					a=Integer.parseInt(t.split("x")[0]);
					b=Integer.parseInt(t.split("x")[1]);
				}
				Term mt=new Term(a,b);
				mt.cff=mt.cff*mt.pow;
				mt.pow-=1;
				lt.add(mt);
			}
			for(int i=0;i<lt.size();i++)
				if(lt.get(i).cff==0)
					lt.remove(i--);
			System.out.println("POLYNOMIAL "+count+"\n"+exp);
			print(lt,value);
		}
	}
	public static void print(List<Term> lt,int value)
	{
		String re="";
		for(int i=0;i<lt.size();i++)
			re+="+"+lt.get(i);
		if(re.length()>0)
			re=re.substring(1);
		re=re.replaceAll("\\+-", "-");
		System.out.println(re.length()>0?re:0);
		re=re.replaceAll("x", "("+value+")");
		System.out.println(re.length()>0?re:0);
		re="";
		for(int i=0;i<lt.size();i++)
			re+="+"+lt.get(i).toString(value);
		re=re.length()>0?re.substring(1):"0";
		re=re.replaceAll("\\+-", "-");
		System.out.println(re);
		int renum=0;
		for(int i=0;i<lt.size();i++)
			renum+=lt.get(i).cff*(int)Math.pow(value,lt.get(i).pow);
		System.out.println(renum);
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
		if(cff==1);
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