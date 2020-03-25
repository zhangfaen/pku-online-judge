import java.io.*;
import java.util.*;
public class Main
{
            public static void main(String args[]) throws Exception
            {
                    Scanner cin=new Scanner(System.in);
                    double R;
                    int M,Y;
                    R=cin.nextInt()/100.0+1.0;
                    M=cin.nextInt();
                    Y=cin.nextInt();
                    double sum=M;
                    for(int i=0;i<Y;i++)
                    {
                    	sum*=R;
                    }
                    M=(int)sum;
                    System.out.println(M);
            }
}
