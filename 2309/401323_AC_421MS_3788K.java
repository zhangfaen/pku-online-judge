import java.io.*;
import java.util.*;
public class Main
{
            public static void main(String args[]) throws Exception
            {
                    Scanner cin=new Scanner(System.in);
                    int n;
                    n=cin.nextInt();
                    while(n--!=0)
                    {
                    	int t=cin.nextInt();
                    	int high=0;
                    	int min=t,max=t;
                    	while(t%2==0&&t>0)
                    	{
                    		t/=2;
                    		high++;
                    	}
                    	for(int i=0;i<high;i++)
                    	{
                    		min-=Math.pow(2,i);
                    		max+=Math.pow(2,i);
                    	}
                    	System.out.println(min+" "+max);
                    }
            }
}