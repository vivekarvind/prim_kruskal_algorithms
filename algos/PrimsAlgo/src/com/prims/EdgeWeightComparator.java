package com.prims;

import java.util.Comparator;

public class EdgeWeightComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
		if (e1.getWeight() > e2.getWeight()) {
			return +1;
		} else if (e1.getWeight() < e2.getWeight()) {
			return -1;
		} else { // equal
			return 0;
		}
	}

}
