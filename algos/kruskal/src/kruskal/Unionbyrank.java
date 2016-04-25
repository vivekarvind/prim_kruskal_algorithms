package kruskal;

public class Unionbyrank {
	// no path compression
	public int find(node curr, Graph g) {

		if (curr.parent != curr.getNodeid()) {
			return find(g.vertices.get(curr.parent), g);
		} else {
			return curr.parent;
		}
	}

	public void union(node x, node y, Graph g) {
		// using union by rank
		int parentx = find(x, g);
		int parenty = find(y, g);
		node parentnodex = g.vertices.get(parentx);
		node parentnodey = g.vertices.get(parenty);

		if (parentnodex.rank < parentnodey.rank) {

			parentnodex.parent = parentnodey.parent;

		} else if (parentnodey.rank < parentnodex.rank) {

			parentnodey.parent = parentnodex.parent;

		} else {

			parentnodey.parent = parentx;
			parentnodex.rank++;

		}

	}
}
