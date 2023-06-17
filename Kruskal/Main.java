import kruskal.DisjointSet;
import kruskal.Edge;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Random random = new Random();

		List<Edge> edges = Arrays.asList(
			new Edge(0, 1, 7), new Edge(1, 2, 8), new Edge(0, 3, 5),
			new Edge(1, 3, 9), new Edge(1, 4, 7), new Edge(2, 4, 5),
			new Edge(3, 4, 15), new Edge(3, 5, 6), new Edge(4, 5, 8),
			new Edge(4, 6, 9), new Edge(5, 6, 1));

		for(Edge edge : edges) {
			edge.setWeight(random.nextInt(20));
		}

		System.out.println(edges);

		// total number of nodes in the graph (labelled 0 to 6)
		int n = 7;

		// Construct graph
		List<Edge> e = DisjointSet.runKruskalAlgorithm(edges, n);
		System.out.println("MST:");
		System.out.println(e);
	}

}
