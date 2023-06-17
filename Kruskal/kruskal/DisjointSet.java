package kruskal;
import java.util.*;
import kruskal.Edge;

public class DisjointSet {

	Map<Integer, Integer> parent = new HashMap();


	public void makeSet(int n) {
		// Create 'n' disjoint sets (one for each vertex)
		for (int i = 0; i < n; i++) {
			parent.put(i, i);
		}

	}

	// Find the root of the set to which k belongs
	public int Find(int k) {
		if(parent.get(k) == k) {
			return k;
		}

		// recur for the parent until we find the root

		return Find(parent.get(k));
	}

	// Perform union of two subsets
	public void Union(int a, int b) {
		int x = Find(a);
		int y = Find(b);

		parent.put(a, b);
	}

	//
	public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {

		// Stores edges in parent MST
		List<Edge> MST = new ArrayList<>();

		// Initialize disjoint class
		// Create a singleton set for each element in the universe
		DisjointSet ds = new DisjointSet();
		ds.makeSet(n);

		int index = 0;

		// Sort edges by increasing weight
		Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

		// MST contains exactly V-1 values
		while (MST.size() != n - 1) {

			// Consider next edge with minimum weight from the graph
			Edge next_edge = edges.get(index++);

			// Find the root of the two sets to which two end points 			// Vertices of the next edge belongs
			int x = ds.Find(next_edge.src);
			int y = ds.Find(next_edge.dest);

			// If both end points have different parents, they belong 
			// to different connected components and can be included in the MST
			if (x != y) {
				MST.add(next_edge);
				ds.Union(x, y);
			}

		}

		return MST;
	}
}
