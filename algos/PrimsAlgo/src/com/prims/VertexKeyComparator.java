package com.prims;

import java.util.Comparator;

public class VertexKeyComparator implements Comparator<MyVertex> {

	@Override
	public int compare(MyVertex v1, MyVertex v2) {
		if (v1.getKey() > v2.getKey()) {
			return +1;
		} else if (v1.getKey() < v2.getKey()) {
			return -1;
		} else { 
			return 0;
		}
	}
}
