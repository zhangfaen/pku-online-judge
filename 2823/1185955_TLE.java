import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[] data = new int[m];
		for(int i = 0; i < m; i++){
			data[i] = in.nextInt();
		}
		LinkedList<Integer> res1 = new LinkedList<Integer>();
		LinkedList<Integer> res2 = new LinkedList<Integer>();
		for(int i = 0; i <= m - n; i++){
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int j = i; j < i + n; j++){
				max = Math.max(max, data[j]);
				min = Math.min(min, data[j]);
			}
			res1.add(min);
			res2.add(max);
		}
		System.out.print(res1.get(0));
		for(int i = 1; i < res1.size(); i++){
			System.out.print(" " + res1.get(i));
		}
		System.out.println();
		System.out.print(res2.get(0));
		for(int i = 1; i < res2.size(); i++){
			System.out.print(" " + res2.get(i));
		}
		System.out.println();
	}
}

