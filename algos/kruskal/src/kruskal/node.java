package kruskal;

public class node {

	int nodeid;
	int y;
	int x;

	int rank = 0;
	int parent;

	public node(int nodeid, int x, int y) {
		this.nodeid = nodeid;
		this.x = x;
		this.y = y;
		this.parent = nodeid;
	}

	public int getNodeid() {
		return nodeid;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
