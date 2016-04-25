package com.prims;

public class MyVertex {
	private String node;
	private float xcoord;
	private float ycoord;
	private double key;
	private String parent;

	public MyVertex() {
		this.key = -1;
		this.parent = null;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getNode() {
		return node;
	}

	public void setXcoord(float xcoord) {
		this.xcoord = xcoord;
	}

	public float getXcoord() {
		return xcoord;
	}

	public void setYcoord(float ycoord) {
		this.ycoord = ycoord;
	}

	public float getYcoord() {
		return ycoord;
	}

	public void setKey(double key) {
		this.key = key;
	}

	public double getKey() {
		return key;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getParent() {
		return parent;
	}
}
