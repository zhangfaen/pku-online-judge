import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
public class Main {
    static class MyNode {
	int v;
	MyNode next = null;
	public MyNode(int v) {
	    this.v = v;
	}
    }
    static class MyList {
	MyNode head = null, tail = null;
	int size = 0;
	public void append(int value) {
	    MyNode tmp = new MyNode(value);
	    if (head == null) {
		head = tail = tmp;
		size = 1;
	    }
	    else {
		size++;
		tail.next = tmp;
		tail = tmp;
	    }
	}
	public void append(MyList ml) {
	    size += ml.size;
	    tail.next = ml.head;
	    tail = ml.tail;
	}
    }
    static class Node implements Comparable<Node> {
	char color;
	Node pre = null, next = null;
	MyList ml = new MyList();
	public Node(char color) {
	    this.color = color;
	}
	public int compareTo(Node o) {
	    if (this.ml.size > o.ml.size)
		return -1;
	    if (this.ml.size < o.ml.size)
		return 1;
	    return this.ml.head.v - o.ml.head.v;
	}
    }
    public static void main(String[] args) throws IOException {
	BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String cs = cin.readLine();
	char[] ca = cs.toCharArray();
	Node pre = null, next = null;
	PriorityQueue<Node> q = new PriorityQueue<Node>();
	for (int i = 0; i < ca.length; i++) {
	    int j;
	    for (j = i; j < cs.length(); j++) {
		if (ca[j] != ca[i])
		    break;
	    }
	    Node cur = new Node(ca[i]);
	    for (int k = i; k < j; k++)
		cur.ml.append(k);
	    cur.pre = pre;
	    if (pre != null)
		pre.next = cur;
	    q.add(cur);
	    pre = cur;
	    i = j - 1;
	}
	while (q.isEmpty() == false) {
	    Node cur = q.poll();
	    if (cur.ml.size <= 1)
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
			pre.ml.append(next.ml);
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
	    for (MyNode mn = cur.ml.head; mn != null; mn = mn.next) {
		out.print(" ");
		out.print(mn.v + 1);
	    }
	    out.println();
	}
	out.flush();
    }
}
