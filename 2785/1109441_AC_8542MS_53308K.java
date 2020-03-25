import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner cin = new Scanner(System.in);
		int n=cin.nextInt();
		int [] A=new int[n];
		int [] B=new int[n];
		int [] C=new int[n];
		int [] D=new int[n];
		for(int i=0;i<n;i++)
		{

			A[i]=cin.nextInt();
			B[i]=cin.nextInt();
			C[i]=cin.nextInt();
			D[i]=cin.nextInt();
		}
		int [] left =new int[n*n];
		int [] right=new int[n*n];
		int index=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				left[index++]=A[i]+B[j];
		index=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				right[index++]=C[i]+D[j];
		Arrays.sort(left);
		Arrays.sort(right);
		long re=0;
		for(int i=0;i<left.length;)
		{
			int tL=left[i];
			int numL=get(tL,left,i);
			int tRindex=Arrays.binarySearch(right, 0-tL);
			if(tRindex>=0)
			{
				int tR=right[tRindex];
				int numR=get(tR,right,tRindex);
				re+=numL*numR;
			}
			i+=numL;
				
		}
		System.out.println(re);
	}
	public static int get(int d,int [] arr,int start)
	{
		int re=1;
		for(int i=start+1;i<arr.length;i++)
			if(arr[i]==d)
				re++;
			else
				break;
		for(int i=start-1;i>=0;i--)
			if(arr[i]==d)
				re++;
			else break;
		return re;
	}
}
