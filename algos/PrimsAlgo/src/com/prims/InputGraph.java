package com.prims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.collections.BinaryHeap;

public class InputGraph {
	int vertexCount;
	int edgeCount;
	MyVertex[] V;
	Edge[] E;

	public InputGraph(int vertexCount) {
		this.vertexCount = vertexCount;

		this.edgeCount = (vertexCount * (vertexCount - 1)) / 2;

		this.V = new MyVertex[vertexCount];
		this.E = new Edge[edgeCount];

		for (int i = 0; i < vertexCount; i++)
			V[i] = new MyVertex();

		for (int i = 0; i < edgeCount; i++)
			E[i] = new Edge();
	}

	public BinaryHeap constructEdgesInBinaryHeap(MyVertex[] v) {

		Comparator<Edge> comparator = new EdgeWeightComparator();
		BinaryHeap minHeap = new BinaryHeap(comparator);
		int i, j;
		for (i = 0; i < v.length - 1; i++) {
			for (j = i + 1; j < v.length; j++) {
				Edge temp = new Edge();
				temp.setNode1(v[i].getNode());
				temp.setNode2(v[j].getNode());
				temp.setWeight(calculateEdgeWeight(v[i], v[j]));
				minHeap.add(temp);

			}
		}
		return minHeap;

	}

	public double calculateEdgeWeight(MyVertex v1, MyVertex v2) {
		double part1, part2;

		part1 = Math.pow((v1.getXcoord() - v2.getXcoord()), 2);
		part2 = Math.pow((v1.getYcoord() - v2.getYcoord()), 2);

		return Math.round(Math.sqrt(part1 + part2));
	}
}
