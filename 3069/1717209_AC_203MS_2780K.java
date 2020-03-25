import java.io.*;
import java.util.*;
import java.math.*;
public class Main {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while(true){
			String[] t = in.readLine().split(" ");
			int R = Integer.parseInt(t[0]);
			int N = Integer.parseInt(t[1]);
			if(R == -1 && N == -1)
				break;
			int[] x = new int[N];
			t = in.readLine().split(" ");
			for(int i = 0; i < N; i++){
				x[i] = Integer.parseInt(t[i]);
			}
			Arrays.sort(x);
			int count = 0;
			int cur = 0;
			while(cur < N){
				count++;
				boolean flag2 = true;
				for(int i=cur;i<N;i++)
				{
					if(x[cur]+ R < x[i])
					{
						boolean flag = false;
						for(int j = i; j < N; j++){
							if(x[i - 1] + R < x[j]){
								cur = j;
								flag = true;
								break;
							}
						}
						if(!flag){
							cur = N;
						}
						flag2 = false;
						break;
					}
				}
				if(flag2)
					break;
			}
			System.out.println(count);
		}
	}

}


