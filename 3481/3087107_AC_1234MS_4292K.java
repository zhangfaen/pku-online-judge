import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    static class Client {
	int id, p;
	public Client(int id, int p) {
	    this.id = id;
	    this.p = p;
	}
    }
    public static void main(String[] args) throws IOException {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	PriorityQueue<Client> q1 = new PriorityQueue<Client>(100,
		new Comparator<Client>() {
		    public int compare(Client o1, Client o2) {
			return o1.p - o2.p;
		    }
		});
	PriorityQueue<Client> q2 = new PriorityQueue<Client>(100,
		new Comparator<Client>() {
		    public int compare(Client o1, Client o2) {
			return o2.p - o1.p;
		    }
		});
	while (true) {
	    String s = cin.readLine();
	    if (s.equals("0"))
		break;
	    StringTokenizer st = new StringTokenizer(s);
	    int code = Integer.parseInt(st.nextToken());
	    if (code == 1) {
		Client c = new Client(Integer.parseInt(st.nextToken()), Integer
			.parseInt(st.nextToken()));
		q1.add(c);
		q2.add(c);
	    }
	    else if (code == 3) {
		if (q1.size() == 0) {
		    out.println(0);
		    continue;
		}
		Client c = q1.poll();
		out.println(c.id);
		q2.remove(c);
	    }
	    else {
		if (q2.size() == 0) {
		    out.println(0);
		    continue;
		}
		Client c = q2.poll();
		out.println(c.id);
		q1.remove(c);
	    }
	}
	out.flush();
    }
}
