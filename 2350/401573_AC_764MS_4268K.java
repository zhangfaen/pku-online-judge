import java.io.*;
import java.util.*;
import java.lang.Integer;
import java.math.*;
public class Main
{
            public static void main(String args[]) throws Exception
            {
                    Scanner cin=new Scanner(System.in);
                   	int C;
                   	C=cin.nextInt();
                   	while(C--!=0)
                   	{
                   		int N=cin.nextInt();
                   		int a[]=new int[N];
                   		double sum=0,avg;
                   		for(int i=0;i<N;i++)
                   		{
                   			a[i]=cin.nextInt();
                   			sum+=a[i];
                   		}
                   		avg=sum/N;
                   		int num=0;
                   		for(int i=0;i<N;i++)
                   			if(a[i]>avg)
                   				num++;
						System.out.printf("%.3f",100*(double)num/N);
						System.out.println("%");
						
						
                   	}
            }
}