import java.io.*;
import java.util.*;
import java.lang.Integer;
import java.math.*;
public class Main
{
            public static void main(String args[]) throws Exception
            {
                    Scanner cin=new Scanner(System.in);
                    String in1=cin.next();
                    String in2=cin.next();
                    BigInteger a=new BigInteger(in1);
                    BigInteger b=new BigInteger(in2);
                    BigInteger c=a.multiply(b);
                    System.out.println(c.toString());
            }
}