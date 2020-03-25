import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		// InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin = new Scanner(System.in);
		String exp = null;
		int sum = 0;
		while (cin.hasNextLine()) {
			exp = cin.nextLine();
			sum++;
			String re = "";
			boolean ok = ExpressionProcessor.go(exp);
			if (ok)
				re = "V";
			else
				re = "F";
			System.out.println("Expression " + sum + ": " + re);

		}
	}
}
class AndExpression implements Expression {
	private Expression path1;
	private Expression path2;
	public AndExpression(Expression path1,Expression path2)
	{
		this.path1=path1;
		this.path2=path2;
	}
	public boolean calc() {
		// TODO Auto-generated method stub
		return path1.calc()&path2.calc();
	}
	public String toString()
	{
		String re="( ";
		re+=path1+" & "+path2+" )";
		return re;
	}
}
class AtomicExpression implements Expression {
	private String path;

	public AtomicExpression(String path) {
		this.path = path;
	}

	public boolean calc() {
		if (path.equals("F"))
			return false;
		else
			return true;
	}

	public String toString() {
		return path;
	}
}interface Expression {
	public boolean calc();
}

import java.util.LinkedList;

/**
 * 
 * @author fafa
 * 
 */
 class ExpressionProcessor {
	/**
	 * <exp> = (<path>)； <exp> = (<exp> | <exp>)； <exp> = (<exp> & <exp>)；
	 * 
	 * 非终结符<path>就不给出明确的定义了，它的格式类似于： elementName/elementName/elementName
	 * 
	 * @param exp
	 * @return
	 */
	public static Expression get(String exp) {
		try {

			IntWrapper iw = new IntWrapper(0);
			LinkedList<Operation> operStack = new LinkedList<Operation>();
			LinkedList<Expression> pathStack = new LinkedList<Expression>();
			Operation base = new Operation(Token.BASE, "");
			operStack.addFirst(base);
			while (true) {
				Token ct = Token.nextToken(exp, iw);
				if (ct == null)
					break;
				if (ct.type == Token.PATH) {
					pathStack.addFirst(new AtomicExpression(ct.content));
				} else {
					Operation oper = (Operation) ct;
					if (oper.type == Token.LEFTBRAKET) {
						operStack.addFirst(oper);
					}
					if (oper.type == Token.RIGHTBRAKET) {
						while (true) {
							Operation cop = operStack.peekFirst();
							if (cop.type == Token.LEFTBRAKET) {
								operStack.pollFirst();
								break;
							}
							f(operStack, pathStack);
						}
					}
					if (oper.type == Token.AND) {
						if (operStack.size() == 0)
							operStack.addFirst(oper);
						else
							while (operStack.size() > 0) {
								Operation cop = operStack.peekFirst();
								if (oper.level > cop.level) {
									operStack.addFirst(oper);
									break;
								}
								f(operStack, pathStack);

							}
					}
					if (oper.type == Token.OR) {
						if (operStack.size() == 0)
							operStack.addFirst(oper);
						else
							while (operStack.size() > 0) {
								Operation cop = operStack.peekFirst();
								if (oper.level > cop.level) {
									operStack.addFirst(oper);
									break;
								}
								f(operStack, pathStack);

							}
					}
					if (oper.type == Token.NOT) {
						if (operStack.size() == 0)
							operStack.addFirst(oper);
						else
							while (operStack.size() > 0) {
								Operation cop = operStack.peekFirst();
								if (oper.level > cop.level) {
									operStack.addFirst(oper);
									break;
								}
								f(operStack, pathStack);

							}
					}
				}
			}
			while (operStack.size() > 1) {
				Operation oper = operStack.pollFirst();
				Expression e1 = pathStack.pollFirst();
				Expression e2 = pathStack.pollFirst();
				checkNull(e1);
				checkNull(e2);
				if (oper.type == Token.LEFTBRAKET)
					throw new Exception();
				Expression ne = null;
				if (oper.type == Token.AND)
					ne = new AndExpression(e2, e1);
				if (oper.type == Token.OR)
					ne = new OrExpression(e2, e1);
				pathStack.addFirst(ne);
			}
			if (operStack.size() > 1 || pathStack.size() != 1)
				throw new Exception();
			return pathStack.getFirst();
		} catch (Exception e) {
			return null;
		}
	}

	public static void f(LinkedList<Operation> operStack,
			LinkedList<Expression> pathStack) throws Exception {
		Operation cop = operStack.pollFirst();
		if (cop.type == Token.NOT) {
			Expression e1 = pathStack.pollFirst();
			checkNull(e1);
			Expression ne = new NotExpression(e1);
			pathStack.addFirst(ne);
		} else {
			Expression e1 = pathStack.pollFirst();
			Expression e2 = pathStack.pollFirst();
			checkNull(e1);
			checkNull(e2);
			Expression ne = null;
			if (cop.type == Token.AND)
				ne = new AndExpression(e2, e1);
			if (cop.type == Token.OR)
				ne = new OrExpression(e2, e1);
			pathStack.addFirst(ne);
		}

	}

	public static void checkNull(Object o) throws Exception {
		if (o == null)
			throw new Exception();
	}

	public static boolean go(String s) {
		s = s.trim().replaceAll(" ", "");
		Expression exp = get(s);
		return exp.calc();
	}

}
 class IntWrapper {
		private int v=0;
		public IntWrapper(int value)
		{
			v=value;
		}
		public int increase(int fac)
		{
			int re=v;
			v+=fac;
			return re;
		}
		public int getV()
		{
			return v;
		}
	}
 class NotExpression implements Expression{
		private Expression path;
		public NotExpression(Expression path)
		{
			this.path=path;
		}
		public boolean calc() {
			
			return !path.calc();
		}
		public String toString()
		{
			return "!"+path;
		}

	}
 class Operation extends Token{
		/*
		 * 定义运算符的优先级，级别分别如下 '(' 1 ;'&' 3 ; '|' 2 ;'!' 4 ; ')'5
		 */
		public int level=0;
		public Operation(int type, String content) {
			super(type, content);
			if(type==Token.LEFTBRAKET)
				level=1;
			if(type==Token.RIGHTBRAKET)
				level=5;
			if(type==Token.AND)
				level=3;
			if(type==Token.OR)
				level=2;
			if(type==Token.BASE)
				level=-1;
			if(type==Token.NOT)
				level=4;
		}
		

	}
 class OrExpression implements Expression{
		private Expression path1;
		private Expression path2;
		public OrExpression(Expression path1,Expression path2)
		{
			this.path1=path1;
			this.path2=path2;
		}
		public boolean calc() {
			// TODO Auto-generated method stub
			return path1.calc()|path2.calc();
		}
		public String toString()
		{
			String re="( ";
			re+=path1+" | "+path2+" )";
			return re;
		}
	}
 class Token {
		public int type;
		public String content;
		
		public Token(int type,String content)
		{
			this.type=type;
			this.content=content;
		}
		public static final int LEFTBRAKET=1;
		public static final int RIGHTBRAKET=2;
		public static final int NOT=7;
		public static final int OR=3;
		public static final int AND=4;
		public static final int PATH=5;
		public static final int BASE=6;
		private static LinkedList<Token> back=new LinkedList<Token>();
		public static Token nextToken(String s,IntWrapper ci)
		{
			if(back.size()>0)
			{
				return back.pollLast();
			}
			if(ci.getV()>=s.length())return null;
			char c=s.charAt(ci.increase(1));
			if(c=='(')
				return new Operation(Token.LEFTBRAKET,"(");
			else if(c==')')
				return new Operation(Token.RIGHTBRAKET,")");
			else if(c=='|')
				return new Operation(Token.OR,"|");
			else if(c=='&')
				return new Operation(Token.AND,"&");
			else if(c=='!')
				return new Operation(Token.NOT,"!");
			{
				String content=""+c;
				while(ci.getV()!=s.length())
				{
					char next=s.charAt(ci.increase(1));
					if(next=='('||next==')'||next=='|'||next=='&')
					{
						ci.increase(-1);
						break;
					}
					content+=next;
				}
				return new Token(Token.PATH,content);
			}
		}
		public static void back(Token token)
		{
			back.addLast(token);
		}
		public String toString()
		{
			String re="";
			if(type==1)
				re="(";
			if(type==2)
				re=")";
			if(type==3)
				re="|";
			if(type==4)
				re="&";
			if(type==5)
				re="path:"+content;
			return re;
		}
	}