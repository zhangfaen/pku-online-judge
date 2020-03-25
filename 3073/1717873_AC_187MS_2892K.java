import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	static int n;
	static int [] best;
	static String data;
	static HashMap<String, Character> map = new HashMap<String, Character>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter out = new PrintWriter(new
		// OutputStreamWriter(System.out));
		map.put("4", 'A');
		map.put("|3", 'B');	map.put("(", 'C');map.put("|)", 'D');map.put("3", 'E');map.put("|=", 'F');map.put("6", 'G');
		map.put("#", 'H');map.put("|", 'I');map.put("_|", 'J');map.put("|<", 'K');map.put("|_", 'L');map.put("|\\/|", 'M');
		map.put("|\\|", 'N');map.put("0", 'O');map.put("|0", 'P');map.put("(,)", 'Q');map.put("|?", 'R');map.put("5", 'S');
		map.put("7", 'T');map.put("|_|", 'U');map.put("\\/", 'V');map.put("\\/\\/", 'W');map.put("><", 'X');map.put("-/", 'Y');
		map.put("2", 'Z');

		while (true) {
			String s;
			s = in.readLine();
			if(s.equals("end")){
				break;
			}
			data="";
			for(int i=0;i<s.length();i++)
			{
				for(String key:map.keySet())
				{
					char c=map.get(key);
					if(c==s.charAt(i))
					{
						data+=key;
						break;
					}
				}
			}
			n = data.length();
			best = new int[n + 1];
			for(int i = 0; i <= n; i++){
				best[i] = -1;
			}
			best[n] = 1;
			System.out.println(dp(0));
			//System.out.println(res);
			
		}
	}
	public static int dp(int cur)
	{
		if(best[cur] >= 0)
			return best[cur];
		int res = 0;
		for(int i = 1; i <= 4 && cur + i <= n; i++){
			String str = data.substring(cur, cur + i);
			if(map.containsKey(str)){
				res += dp(cur + i);
			}
		}
		return best[cur] = res;
	}
}
