import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		String exp=null;
		int sum=0;
		while(cin.hasNextLine())
		{
			exp=cin.nextLine();
			sum++;
			LinkedList<Character>numStack=new LinkedList<Character>();
			LinkedList<Oper>operStack=new LinkedList<Oper>();
			operStack.addFirst(new Oper('b'));
			for(int i=0;i<exp.length();i++)
			{
				char c=exp.charAt(i);
				if(c=='F'||c=='V')
				{
					numStack.addFirst(c);
				}
				if(c=='(')
				{
					operStack.addFirst(new Oper(c));
				}
				if(c==')')
				{
					while(operStack.getFirst().c!='(')
					{
						char oper=operStack.removeFirst().c;
						if(oper=='!')
						{
							char num=numStack.removeFirst();
							if(num=='F')
								numStack.addFirst('V');
							else
								numStack.addFirst('F');
						}
						if(oper=='&')
						{
							char num1=numStack.removeFirst();
							char num2=numStack.removeFirst();
							if(num1=='V'&&num2=='V')
								numStack.addFirst('V');
							else
								numStack.addFirst('F');
						}
						if(oper=='|')
						{
							char num1=numStack.removeFirst();
							char num2=numStack.removeFirst();
							if(num1=='V'||num2=='V')
								numStack.addFirst('V');
							else
								numStack.addFirst('F');
						}
					}
					operStack.removeFirst();//remove '(';
				}
				if(c=='&'||c=='!'||c=='|')
				{
					Oper operNew=new Oper(c);
					while(operNew.level<operStack.getFirst().level)
					{
						char oper=operStack.removeFirst().c;
						if(oper=='!')
						{
							char num=numStack.removeFirst();
							if(num=='F')
								numStack.addFirst('V');
							else
								numStack.addFirst('F');
						}
						if(oper=='&')
						{
							char num1=numStack.removeFirst();
							char num2=numStack.removeFirst();
							if(num1=='V'&&num2=='V')
								numStack.addFirst('V');
							else
								numStack.addFirst('F');
						}
						if(oper=='|')
						{
							char num1=numStack.removeFirst();
							char num2=numStack.removeFirst();
							if(num1=='V'||num2=='V')
								numStack.addFirst('V');
							else
								numStack.addFirst('F');
						}
					}
					operStack.addFirst(operNew);
				}
			}
			
			while(operStack.size()>1)
			{
				char oper=operStack.removeFirst().c;
				if(oper=='!')
				{
					char num=numStack.removeFirst();
					if(num=='F')
						numStack.addFirst('V');
					else
						numStack.addFirst('F');
				}
				if(oper=='&')
				{
					char num1=numStack.removeFirst();
					char num2=numStack.removeFirst();
					if(num1=='V'&&num2=='V')
						numStack.addFirst('V');
					else
						numStack.addFirst('F');
				}
				if(oper=='|')
				{
					char num1=numStack.removeFirst();
					char num2=numStack.removeFirst();
					if(num1=='V'||num2=='V')
						numStack.addFirst('V');
					else
						numStack.addFirst('F');
				}
			}
			System.out.println("Expression "+sum+": "+numStack.getFirst());
			
		}
	}
}
class Oper
{
	public char c;
	public int level;//! 3,& 2,| 1,( 0,)4
	public Oper(char c)
	{
		this.c=c;
		if(c=='!')
			level=3;
		if(c=='&')
			level=2;
		if(c=='|')
			level=1;
		if(c=='(')
			level=0;
		if(c==')')
			level=4;
		if(c=='b')
			level=-1;
	}
}