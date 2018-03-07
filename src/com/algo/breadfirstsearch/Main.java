package com.algo.breadfirstsearch;

public class Main {
	public static void main(String[] args) {
		
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		v1.addNeighbours(v2);
		v1.addNeighbours(v4);
		v2.addNeighbours(v3);
		v2.addNeighbours(v5);
		v3.addNeighbours(v6);
		BFS bfs = new BFS();
		bfs.bfs(v1);
	}
}

