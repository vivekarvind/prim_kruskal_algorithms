package com.prims;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.apache.commons.collections.BinaryHeap;

public class PrimsMST {
	public PrimsMST() {
		super();
	}

	BinaryHeap storingHeap = new BinaryHeap();

	public void createGraphFromInputFile(String inputFile, String outputfile) {
		try {
			File file = new File(inputFile);
			BufferedReader br = new BufferedReader(new FileReader(file));
			int totalVertices, i;
			String line;
			String vertex[];
			totalVertices = Integer.parseInt(br.readLine());

			InputGraph G = new InputGraph(totalVertices);
			MyVertex V[] = new MyVertex[totalVertices];
			for (i = 0; i < totalVertices; i++) {
				line = br.readLine();
				vertex = line.split(",");
				V[i] = new MyVertex();
				V[i].setNode(vertex[0].substring(1));
				V[i].setXcoord(Float.parseFloat(vertex[1]));
				V[i].setYcoord(Float.parseFloat(vertex[2].substring(0,
						vertex[2].length() - 1)));
			}

			br.close();
			G.V = V;

			storingHeap = G.constructEdgesInBinaryHeap(V);

			String sourceNode = null;
			if (V.length > 0) {
				sourceNode = V[0].getNode();
			}
			this.createMSTUsingPrims(G, sourceNode, outputfile);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void createMSTUsingPrims(InputGraph G, String r, String outputfile) throws IOException {
		
		int i, j;
		MyVertex source = new MyVertex();
		MyVertex[] visited = new MyVertex[G.V.length];
		double costOfMST;

		for (i = 0; i < G.V.length; i++) {
			if (G.V[i].getNode().equalsIgnoreCase(r)) {
				G.V[i].setKey(0);
				source = G.V[i];
				break;
			}
		}

		j = 0;
		visited[j] = source;

		Comparator<MyVertex> comparator = new VertexKeyComparator();
		PriorityQueue<MyVertex> Q = new PriorityQueue<MyVertex>(G.V.length - 1,
				comparator);

		for (i = 0; i < G.V.length; i++) {
			if (!G.V[i].getNode().equalsIgnoreCase(r)) {
				G.V[i].setKey(G.calculateEdgeWeight(source, G.V[i]));
				G.V[i].setParent(source.getNode());
				Q.add(G.V[i]);
			}
		}

		MyVertex u, v;
		double newKey;
		Iterator<MyVertex> Qiterator;

		costOfMST = 0;
		while (Q.size() != 0) {
			u = Q.remove();
			visited[++j] = u;
			costOfMST += u.getKey();

			Qiterator = Q.iterator();

			while (Qiterator.hasNext()) {
				v = Qiterator.next();
				newKey = this.getEdgeWeightFromHeap(u.getNode(),
							v.getNode(), storingHeap);
				if (newKey < v.getKey()) {
					v.setKey(newKey);
					v.setParent(u.getNode());
				}
			}
		}

		costOfMST = Math.round(costOfMST );
		printMST(visited, costOfMST, outputfile);
	}

	public double getEdgeWeightFromHeap(String u, String v, BinaryHeap E) {
		double weight = 0;

		for (Object e : E) {
			Edge localEdge = (Edge) e;
			if (localEdge != null
					&& (localEdge.getNode1().equalsIgnoreCase(u) && localEdge
							.getNode2().equalsIgnoreCase(v))
					|| (localEdge.getNode1().equalsIgnoreCase(v) && localEdge
							.getNode2().equalsIgnoreCase(u))) {
				weight = localEdge.getWeight();
				break;
			}
		}
		return weight;
	}

	public void printMST(MyVertex[] v, double costOfMST, String outputfile)
			throws IOException {

		File file1 = new File(outputfile);
		BufferedWriter bw;
		if (!file1.exists()) {
			file1.createNewFile();
		}
		FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),true);
		bw = new BufferedWriter(fw1);
		bw.write("Cost of MST is " + costOfMST
				+ " and below are the list of branches\n");
		bw.newLine();
		bw.write("  Branch              Cost\n");
		bw.newLine();

		for (int i = 1; i < v.length; i++) {
			bw.newLine();
			bw.write(" " + v[i].getParent() + " --- " + v[i].getNode()
					+ "              " + v[i].getKey());
			bw.newLine();
		}
		bw.close();
	}

	public static void main(String[] args) {
		PrimsMST mst1 = new PrimsMST();
		//int ch;
		//ch = Integer.parseInt(args[2]);
		mst1.createGraphFromInputFile(args[0], args[1]);
	}
}
