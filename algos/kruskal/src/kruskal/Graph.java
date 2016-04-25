package kruskal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Graph {

	HashMap<Integer, node> vertices = new HashMap<Integer, node>();
	ArrayList<node> nodes = new ArrayList<node>();
	TreeSet<Edge> TE = new TreeSet<Edge>();
	TreeSet<Edge> KE = new TreeSet<Edge>();

}
