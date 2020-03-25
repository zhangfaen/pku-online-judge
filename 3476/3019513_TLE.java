import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
public class Main {
    static class Node implements Comparable<Node> {
	char color;
	Node pre = null, next = null;
	List<Integer> li = new ArrayList<Integer>();
	public Node(char color, List<Integer> li) {
	    this.color = color;
	    this.li = li;
	}
	public int compareTo(Node o) {
	    if (li.size() > o.li.size())
		return -1;
	    if (li.size() < o.li.size())
		return 1;
	    return li.get(0) - o.li.get(0);
	}
    }
    public static void main(String[] args) throws IOException {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String cs = cin.readLine();
	Node pre = null, next = null;
	PriorityQueue<Node> q = new PriorityQueue<Node>();
	for (int i = 0; i < cs.length(); i++) {
	    int cnt = 0, j;
	    for (j = i; j < cs.length(); j++) {
		if (cs.charAt(j) == cs.charAt(i)) {
		    cnt++;
		}
		else
		    break;
	    }
	    List<Integer> li = new ArrayList<Integer>();
	    for (int k = i; k < j; k++)
		li.add(k);
	    Node cur = new Node(cs.charAt(i), li);
	    cur.pre = pre;
	    if (pre != null)
		pre.next = cur;
	    q.add(cur);
	    pre = cur;
	    i = j - 1;
	}
	while (q.isEmpty() == false) {
	    Node cur = q.poll();
	    if (cur.li.size() <= 1)
		break;
	    pre = cur.pre;
	    next = cur.next;
	    if (next == null) {
		if (pre != null)
		    pre.next = null;
	    }
	    else {
		if (pre != null) {
		    if (pre.color != next.color) {
			pre.next = next;
			next.pre = pre;
		    }
		    else {
			q.remove(next);
			q.remove(pre);
			pre.li.addAll(next.li);
			if (next.next != null) {
			    next.next.pre = pre;
			    pre.next = next.next;
			}
			else
			    pre.next = null;
			q.add(pre);
		    }
		}
		else {
		    next.pre = null;
		}
	    }
	    out.print(cur.color);
	    for (int i = 0; i < cur.li.size(); i++) {
		out.print(" ");
		out.print(cur.li.get(i) + 1);
	    }
	    out.println();
	}
	out.flush();
    }
}
