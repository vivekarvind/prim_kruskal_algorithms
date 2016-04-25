package kruskal;

public class Edge implements Comparable<Edge> {
	node startvertex, endvertex;
	int weight;

	public node getStartvertex() {
		return startvertex;
	}

	public node getEndvertex() {
		return endvertex;
	}

	public int getWeight() {
		return weight;
	}

	public Edge(node startvertex, node endvertex, int weight) {
		this.startvertex = startvertex;
		this.endvertex = endvertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge edge) {
		return (this.weight < edge.weight) ? -1 : 1;
	}
}
