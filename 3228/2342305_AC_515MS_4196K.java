import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Main
{
    static BufferedReader cin;
    static class E implements Comparable<E>
    {
	int x, y, len;
	public int compareTo(E o)
	{
	    return len - o.len;
	}
	public E(int x, int y, int len)
	{
	    this.x = x;
	    this.y = y;
	    this.len = len;
	}
    }
    public static void main(String[] args) throws IOException
    {
	cin = new BufferedReader(new InputStreamReader(System.in));
	while (true)
	{
	    String s = cin.readLine();
	    int n = Integer.parseInt(s);
	    if (n == 0)
		break;
	    int[] supply = new int[n];
	    int[] demand = new int[n];
	    s = cin.readLine();
	    String[] sa = s.split(" ");
	    for (int i = 0; i < n; i++)
		supply[i] = Integer.parseInt(sa[i]);
	    s = cin.readLine();
	    sa = s.split(" ");
	    for (int i = 0; i < n; i++)
		demand[i] = Integer.parseInt(sa[i]);
	    for (int i = 0; i < n; i++)
		if (demand[i] >= supply[i])
		{
		    demand[i] -= supply[i];
		    supply[i] = 0;
		}
		else
		{
		    supply[i] -= demand[i];
		    demand[i] = 0;
		}
	    int totalSupply = 0;
	    for (int d : supply)
		totalSupply += d;
	    int totalDemand = 0;
	    for (int d : demand)
		totalDemand += d;
	    s = cin.readLine();
	    int m = Integer.parseInt(s);
	    E[] es = new E[m];
	    for (int i = 0; i < m; i++)
	    {
		sa = cin.readLine().split(" ");
		int len = Integer.parseInt(sa[2]);
		es[i] = new E(Integer.parseInt(sa[0]) - 1, Integer
			.parseInt(sa[1]) - 1, len);
	    }
	    Arrays.sort(es);
	    if (totalDemand < totalSupply
		    || check(supply, demand, n, es, m - 1, totalSupply) == false)
	    {
		System.out.println("No Solution");
		continue;
	    }
	    int left = 0, right = es.length - 1;
	    int res = Integer.MAX_VALUE;
	    while (left < right)
	    {
		int mid = (left + right) / 2;
		if (check(supply, demand, n, es, mid, totalSupply))
		{
		    right = mid;
		}
		else
		{
		    left = mid + 1;
		}
	    }
	    res = es[right].len;
	    System.out.println(res);
	}
    }
    public static boolean check(int[] supply, int[] demand, int n, E[] es,
	    int end, int sum)
    {
	int size = n + 2;
	int[][] cap = new int[size][size];
	for (int i = 0; i <= end; i++)
	{
	    int x = es[i].x, y = es[i].y;
	    cap[x][y] = cap[y][x] = Integer.MAX_VALUE / 10;
	}
	for (int i = 0; i < n; i++)
	{
	    cap[n][i] = supply[i];
	    cap[i][n + 1] = demand[i];
	}
	MaxFlowOfImprovedShortestAugmentingPath mf = new MaxFlowOfImprovedShortestAugmentingPath(
		cap, n, n + 1);
	int re = mf.find_max_flow();
	if (re == sum)
	    return true;
	return false;
    }
    static class MaxFlowOfImprovedShortestAugmentingPath
    {
	private int oo = 1000000000; // Infinity
	// Nodes, Arcs, the source node and the sink node
	private int n, source, sink;
	// Matrixes for maintaining
	// Graph and Flow
	int[][] G;
	int[][] F;
	int[] pi; // predecessor list
	int[] currentNode; // Current edge for each node
	int[] queue; // Queue for reverse BFS
	int[] d; // Distance function
	int[] numbs; // numbs[k] is the number of nodes i with
	// d[i]==k
	// Reverse breadth-first search
	// to establish distance function d
	public MaxFlowOfImprovedShortestAugmentingPath(int[][] cap, int source,
		int sink)
	{
	    n = cap.length;
	    G = new int[n + 1][n + 1];
	    for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		    G[i + 1][j + 1] = cap[i][j];
	    F = new int[n + 1][n + 1];
	    pi = new int[n + 1];
	    currentNode = new int[n + 1];
	    queue = new int[n * n + 100];
	    d = new int[n + 1];
	    numbs = new int[n + 1];
	    this.source = source + 1;
	    this.sink = sink + 1;
	}
	private int rev_BFS()
	{
	    int i, j, head = 0, tail = 0;
	    // Initially, all d[i]=n
	    for (i = 1; i <= n; i++)
		numbs[d[i] = n]++;
	    // Start from the sink
	    numbs[n]--;
	    d[sink] = 0;
	    numbs[0]++;
	    queue[++tail] = sink;
	    // While queue is not empty
	    while (head != tail)
	    {
		i = queue[++head]; // Get the next node
		// Check all adjacent nodes
		for (j = 1; j <= n; j++)
		{
		    // If it was reached before or there is no edge
		    // then continue
		    if (d[j] < n || G[j][i] == 0)
			continue;
		    // j is reached first time
		    // put it into queue
		    queue[++tail] = j;
		    // Update distance function
		    numbs[n]--;
		    d[j] = d[i] + 1;
		    numbs[d[j]]++;
		}
	    }
	    return 0;
	}
	// Augmenting the flow using predecessor list pi[]
	private int Augment()
	{
	    int i, j, tmp, width = oo;
	    // Find the capacity of the path
	    for (i = sink, j = pi[i]; i != source; i = j, j = pi[j])
	    {
		tmp = G[j][i];
		if (tmp < width)
		    width = tmp;
	    }
	    // Augmentation itself
	    for (i = sink, j = pi[i]; i != source; i = j, j = pi[j])
	    {
		G[j][i] -= width;
		F[j][i] += width;
		G[i][j] += width;
		F[i][j] -= width;
	    }
	    return width;
	}
	// Main procedure
	public int find_max_flow()
	{
	    int flow = 0, i, j;
	    rev_BFS(); // Establish exact distance function
	    // For each node current arc is the first arc
	    for (i = 1; i <= n; i++)
		currentNode[i] = 1;
	    // Begin searching from the source
	    i = source;
	    // The main cycle (while the source is not "far" from the sink)
	    for (; d[source] < n;)
	    {
		// Start searching an admissible arc from the current arc
		for (j = currentNode[i]; j <= n; j++)
		    // If the arc exists in the residual network
		    // and if it is an admissible
		    if (G[i][j] > 0 && d[i] == d[j] + 1)
			// Then finish searhing
			break;
		// If the admissible arc is found
		if (j <= n)
		{
		    currentNode[i] = j; // Mark the arc as "current"
		    pi[j] = i; // j is reachable from i
		    i = j; // Go forward
		    // If we found an augmenting path
		    if (i == sink)
		    {
			flow += Augment(); // Augment the flow
			i = source; // Begin from the source again
		    }
		}
		// If no an admissible arc found
		else
		{
		    currentNode[i] = 1; // Current arc is the first arc again
		    // If numbs[ d[i] ] == 0 then the flow is the maximal
		    // Relabel and backtrack
		    int tmp;
		    int k, mind = n - 1;
		    // Check all adkacent edges
		    // to find nearest
		    for (k = 1; k <= n; k++)
			// If there is an arc
			// and k is "nearer"
			if (G[i][k] > 0 && d[k] < mind)
			    mind = d[k];
		    tmp = d[i]; // Save previous distance
		    // Relabel procedure itself
		    numbs[d[i]]--;
		    d[i] = 1 + mind;
		    numbs[d[i]]++;
		    // Backtrack, if possible (i is not a local variable! )
		    if (i != source)
			i = pi[i];
		    // If numbs[ tmp ] is zero, algorithm will stop
		    if (numbs[tmp] == 0)
			break;
		}
	    } // End of the main cycle
	    // We return flow value
	    return flow;
	}
    }
}
