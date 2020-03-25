import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String [] args)throws Exception
	{
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		Matrix [] p=new Matrix[26];
		for(int i=0;i<n;i++)
		{
			char c=cin.next().charAt(0);
			p[c-'A']=new Matrix(cin.nextInt(),cin.nextInt());
		}
		while(cin.hasNext())
		{
			String exp=cin.next();
			LinkedList<Matrix> matrix_stack=new LinkedList<Matrix>();
			LinkedList<Character> c_stack=new LinkedList<Character>();
			int sum=0;
			boolean error=false;
			for(int i=0;i<exp.length();i++)
			{
				if(exp.charAt(i)=='(')
				{
					c_stack.addFirst(')');
				}
				else
				if(exp.charAt(i)==')')
				{
					Matrix first=matrix_stack.removeFirst();
					Matrix second=matrix_stack.removeFirst();
					c_stack.removeFirst();
					if(!second.isCan(first))
					{
						error=true;
						break;
					}
					sum+=second.multInt(first);
					matrix_stack.addFirst(second.multMatrix(first));
				}
				else
				{
					matrix_stack.addFirst(p[exp.charAt(i)-'A']);
				}
			}
			if(error)
				System.out.println("error");
			else
			{
				if(matrix_stack.size()==1)
				{
					System.out.println(sum);
				}
				else
				{
					Matrix first=matrix_stack.removeFirst();
					Matrix second=matrix_stack.removeFirst();
					if(!second.isCan(first))
					{
						System.out.println("error");
					}
					else
					{
						
						sum+=second.multInt(first);
						System.out.println(sum);
					}
				}
			}
		}
	}
			
	
}
class Matrix
{
	public int m,n;
	public Matrix(int x,int y)
	{
		m=x;n=y;	
	}
	public int multInt(Matrix t)
	{
		return m*n*t.n;
	}
	public Matrix multMatrix(Matrix t)
	{
		return new Matrix(m,t.n);
	}
	public boolean isCan(Matrix t)
	{
		return n==t.m;
	}
	
}