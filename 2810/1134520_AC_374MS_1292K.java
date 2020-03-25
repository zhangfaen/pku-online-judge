import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int[] par;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String tar = in.nextLine();
		String a = "";
		String b = "";
		String c = "";
		for(int i = 0; i < tar.length(); i++){
			if(tar.charAt(i) == ' '){
				tar = tar.substring(i + 1);
				break;
			}
			a += tar.charAt(i);
		}
		for(int i = 0; i < tar.length(); i++){
			if(tar.charAt(i) == ' '){
				tar = tar.substring(i + 1);
				break;
			}
			b += tar.charAt(i);
		}
		for(int i = 0; i < tar.length(); i++){
			if(tar.charAt(i) == ' '){
				tar = tar.substring(i + 1);
				break;
			}
			c += tar.charAt(i);
		}
		LinkedList<String> res1 = new LinkedList<String>();
		LinkedList<String> res2 = new LinkedList<String>();
		while (Double.parseDouble(a) >= 0.0) {
			String lab = tar;
			int val = (int)Math.round(Double.parseDouble(a)
					/ Double.parseDouble(c) * 100.0);
			int t = (int) Math.round(Double.parseDouble(a) * 10);
			if (Double.parseDouble(a)
				/ Double.parseDouble(c)>=0.01) {
				lab += " ";
				double val2 = t / 10.0;
				lab += val2 + " ";
				lab += b + " ";
				lab += val + "%";
				res1.add(lab);
			} else {
				res2.add(lab);
			}
			tar = in.nextLine();
			a = "";
			b = "";
			c = "";
			for(int i = 0; i < tar.length(); i++){
				if(tar.charAt(i) == ' '){
					tar = tar.substring(i + 1);
					break;
				}
				a += tar.charAt(i);
			}
			for(int i = 0; i < tar.length(); i++){
				if(tar.charAt(i) == ' '){
					tar = tar.substring(i + 1);
					break;
				}
				b += tar.charAt(i);
			}
			for(int i = 0; i < tar.length(); i++){
				if(tar.charAt(i) == ' '){
					tar = tar.substring(i + 1);
					break;
				}
				c += tar.charAt(i);
			}
		}
		for (int i = 0; i < res1.size(); i++) {
			System.out.println(res1.get(i));
		}
		System.out.println("Provides no significant amount of: ");
		for (int i = 0; i < res2.size(); i++) {
			System.out.println(res2.get(i));
		}
	}
}


