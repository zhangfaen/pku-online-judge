import java.io.*;
import java.util.*;
import java.math.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
	Scanner cin = new Scanner(new BufferedInputStream(System.in));
	while (cin.hasNextInt())
	{
	    int n, m;
	    n = cin.nextInt();
	    m = cin.nextInt();
	    int[][] p = new int[m][m];
	    for (int i = 0; i < n; i++)
	    {
		int x = cin.nextInt() - 1;
		int y = cin.nextInt() - 1;
		p[x][y] += cin.nextInt();
	    }
	    MaxFlowOfImprovedShortestAugmentingPath mf = new MaxFlowOfImprovedShortestAugmentingPath(
		    p, 0, m - 1);
	    System.out.println(mf.find_max_flow());
	}
    }
    static class MaxFlowOfImprovedShortestAugmentingPath
    {
	private int INF = Integer.MAX_VALUE; // Infinity
	// Nodes, Arcs, the source node and the sink node
	private int n, source, sink;
	// Matrixes for maintaining
	// Graph and Flow
	int[][] G;
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
	    pi = new int[n + 1];
	    currentNode = new int[n + 1];
	    queue = new int[(n + 1) * (n + 1) + 10];
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
	    int i, j, tmp, width = INF;
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
		G[i][j] += width;
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
