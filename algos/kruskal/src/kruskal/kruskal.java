package kruskal;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class kruskal {
	public int edgecost(node a, node b) {

		int dist = (int) Math.sqrt(Math.pow((a.getX() - b.getX()), 2)
				+ Math.pow((a.getX() - b.getY()), 2));
		return dist;
	}

	public static void main(String[] args) throws IOException {
		kruskal k = new kruskal();
		Graph g = new Graph();
		BufferedWriter bw;

		//int choice = Integer.parseInt(args[2]);

		int numofnodes = 0;
		try {

			FileInputStream fis = new FileInputStream(args[0]);
			DataInputStream input = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(input));

			File file = new File(args[1]);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);

			String readline;
			numofnodes = Integer.parseInt(br.readLine());

			while ((readline = br.readLine()) != null) {

				readline = readline.substring(1, readline.length() - 1);
				String[] ip = readline.split(",");

				int x = Integer.parseInt(ip[2]);
				int y = Integer.parseInt(ip[1]);
				int nodeid = Integer.parseInt(ip[0]);

				node n = new node(nodeid, x, y);
				g.vertices.put(n.getNodeid(), n);
				g.nodes.add(n);
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < g.nodes.size(); i++) {
			for (int j = i + 1; j < g.nodes.size(); j++) {

				int wieght = k.edgecost(g.nodes.get(i), g.nodes.get(j));

				g.TE.add(new Edge(g.nodes.get(i), g.nodes.get(j), wieght));
				//d.Edges.add(new Edge(g.nodes.get(i), g.nodes.get(j), wieght));
			}

		}
		Unionbyrank UR = new Unionbyrank();
		File file = new File(args[1]);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		for (Edge edge : g.TE) {
			int x = UR.find(edge.getStartvertex(), g);
			int y = UR.find(edge.getEndvertex(), g);
			if (x != y) {
				UR.union(g.vertices.get(edge.getStartvertex().getNodeid()),
						g.vertices.get(edge.getEndvertex().getNodeid()), g);
				g.KE.add(edge);
			}
		}
		bw.write("KRUSKAL'S USING UNION FIND");
		bw.newLine();
		int cost = 0;
		for (Edge edge : g.KE) {
			cost += edge.getWeight();
			bw.write("\nEdge " + edge.getStartvertex().getNodeid() + "-"
					+ edge.getEndvertex().getNodeid());
			bw.newLine();
			bw.write("Edge cost" + cost);
			bw.newLine();

		}

		bw.write("\nMinimum Spanning tree Cost" + cost);
		bw.newLine();
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		bw.write("Duration for MST without path compression in milliseconds: " + duration);
		bw.newLine();
		bw.close();
	}
}
