package com.prims;

public class Edge {
	private String node1;
	private String node2;
	private double weight;

	public Edge() {
		this.node1 = null;
		this.node2 = null;
		this.weight = 0;
	}

	public void setNode1(String node1) {
		this.node1 = node1;
	}

	public String getNode1() {
		return node1;
	}

	public void setNode2(String node2) {
		this.node2 = node2;
	}

	public String getNode2() {
		return node2;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}
}
