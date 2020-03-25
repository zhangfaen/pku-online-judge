import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for(int num = 1; num <= n; num++){
			String[] t = in.readLine().split(" ");
			int a = Integer.parseInt(t[0]);
			int b = Integer.parseInt(t[1]);
			int c = Integer.parseInt(t[2]);
			if(a + c == b){
				System.out.println("does not matter");
			}
			else if(a + c < b){
				System.out.println("advertise");
			}
			else{
				System.out.println("do not advertise");
			}
		}
	}

}