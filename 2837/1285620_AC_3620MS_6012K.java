import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		int k=cin.nextInt();
		k=(int)Math.pow(2,k);
		int [][] re=get(k);
		for(int i=0;i<re.length;i++)
		{
			 for(int j=0;j<re.length;j++)
			 {
				 System.out.print(re[i][j]+" ");
			 }
			 System.out.println();
		}
	}
	public static int [][] get(int k)
	{
		if(k==2)
		{
			int [][] p={{1,2},{3,1}};
			return p;
		}
		int [][] a=get(k/2);
		int len=a.length;
		int [][]c=new int[len][len];
		int [][] re=new int[len*2][len*2];
		int [][] b=new int[len][len];
		for(int i=0;i<len;i++)
			for(int j=0;j<len;j++)
				c[i][j]=b[i][j]=a[i][j]+k;
		for(int i=0;i<len;i++)
			c[i][i]=k;
		for(int i=0;i<len;i++)
			for(int j=0;j<len;j++)
				re[i][j]=re[i+k/2][j+k/2]=a[i][j];
		for(int i=0;i<len;i++)
			for(int j=len;j<2*len;j++)
				re[i][j]=b[i][j-len];
		for(int i=len;i<2*len;i++)
			for(int j=0;j<len;j++)
				re[i][j]=c[i-len][j];
		return re;
	}
} 
