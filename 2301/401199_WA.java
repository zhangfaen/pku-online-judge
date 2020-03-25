import java.io.*;
import java.util.*;
public class Main
{
            public static void main(String args[]) throws Exception
            {
                    Scanner cin=new Scanner(System.in);
                    int n=cin.nextInt();
                    while(n--!=0)
                    {
                    	int s=cin.nextInt();
                    	int d=cin.nextInt();
                    	int x,y;
                    	x=(s+d)/2;
                    	y=(s-d)/2;
                    	if(x>0&&y>0&&x*2==(s+d)&&y*2==(s-d))
                    	{
                    		if(x>y)
                    			System.out.println(""+x+" "+y);
                    		else
                    			System.out.println(""+y+" "+x);
                    		continue;
                    	}
                    	x=(s-d)/2;
                    	y=(s+d)/2;
                    	if(x>0&&y>0&&x*2==(s-d)&&y*2==(s+d))
                    	{
                    		if(x>y)
                    			System.out.println(""+x+" "+y);
                    		else
                    			System.out.println(""+y+" "+x);
                    		continue;
                    	}
                    	System.out.println("impossible");
                    }
            }
}
