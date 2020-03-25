import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    static BufferedReader cin;
    static List<List<Integer>> map;

    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	double a = 0, b = 0, c = 0;
	double x1, x2, x3, y1, y2, y3;
	double sinA, cosA, r;
	while (true)
	{
	    String s = cin.readLine();
	    if(s==null)break;
	    String[] sa = s.split(" ");
	    x1=Double.parseDouble(sa[0]);
	    y1=Double.parseDouble(sa[1]);
	    x2=Double.parseDouble(sa[2]);
	    y2=Double.parseDouble(sa[3]);
	    x3=Double.parseDouble(sa[4]);
	    y3=Double.parseDouble(sa[5]);
	    a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	    b = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
	    c = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
	    cosA = (b * b + c * c - a * a) / (2 * b * c);
	    sinA = Math.sqrt(1 - cosA * cosA);
	    r = a / sinA;
	    System.out.printf("%.2f\n", 3.141592653589793 * r);
	}

    }

}
