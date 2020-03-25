import java.util.*;
import java.io.*;
import java.text.*;
public class Main
{
	private static long [] p;
	public static void main(String [] args)throws Exception
	{
	
		String [] p={"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		//InputStream in=new FileInputStream("c:\\in.txt");
		Scanner cin=new Scanner(System.in);
		Calendar pre=Calendar.getInstance();
		pre.set(2000,0,1);
		while(true)
		{
			int days=cin.nextInt();
			if(days==-1)
				break;
			Calendar now=(Calendar)pre.clone();
			now.add(Calendar.DAY_OF_MONTH,days);
			
			SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd EEEEEEEEEEEE",Locale.US);
			System.out.println(formate.format(now.getTime()));
		}
	}

	
	
}


