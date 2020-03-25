import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
public class Main
{
	public static void main(String [] args) throws FileNotFoundException
	{
	
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			String[] tmp = in.next().split(":");
			int mm = Integer.parseInt(tmp[0]);
			int ss = Integer.parseInt(tmp[1]);
			if(ss != 0){
				System.out.println("0");
				continue;
			}
			int res = 0;
			if((mm + 12) % 24 == 0){
				res = 24;
			}
			else{
				res = (mm + 12) % 24;
			}
			System.out.println(res);			
		}
	}
}