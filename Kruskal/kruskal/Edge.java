package kruskal;

public class Edge
{
	int src, dest, weight;
	
	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;

	}

	@Override
	public String toString() {

		return "(" + src + ", " + dest + ", " + weight + ")";
	}

	public void setWeight(int w) {
		this.weight = w;
	}

}
