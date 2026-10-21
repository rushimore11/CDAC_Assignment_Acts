package org.graphh;
import org.graphh.Edge;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjListGraph {
 private final List<List<Edge>> adjacencyList;
 private final boolean isDirected;
 private final int vertices;

 public AdjListGraph(int vertices, boolean isDirected) {
     this.isDirected = isDirected;
     this.vertices = vertices;
     this.adjacencyList = new ArrayList<>(vertices);
     
     for (int i = 0; i < vertices; i++) {
         this.adjacencyList.add(new ArrayList<>());
     }
 }

 public void addEdge(int src, int dest, int weight) {
     this.adjacencyList.get(src).add(new Edge(src, dest, weight));
     if (!isDirected) {
         this.adjacencyList.get(dest).add(new Edge(dest, src, weight));
     }
 }

 public void printBFS(int startVertex) {
     if (startVertex < 0 || startVertex >= vertices) {
         throw new IllegalArgumentException("Vertex out of bounds");
     }

     boolean[] visited = new boolean[vertices];
     Queue<Integer> queue = new LinkedList<>();

     visited[startVertex] = true;
     queue.add(startVertex);

     System.out.print("BFS Traversal starting from vertex " + startVertex + ": ");

     while (!queue.isEmpty()) {
         int curr = queue.poll();
         System.out.print(curr + " ");

         for (Edge edge : adjacencyList.get(curr)) {
             if (!visited[edge.dest]) {
                 visited[edge.dest] = true;
                 queue.add(edge.dest);
             }
         }
     }
     System.out.println();
 }
 
 public boolean isConnected() {
	    if (vertices == 0) return true;

	    boolean[] visited = new boolean[vertices];
	    
	   
	    ccDFS(0, visited);

	    
	    for (boolean v : visited) {
	        if (!v) {
	            return false;
	        }
	    }
	    return true;
	}
 
 public int connectedComponentCount() {
	    boolean[] visited = new boolean[vertices];
	    int count = 0;

	   
	    for (int i = 0; i < vertices; i++) {
	        if (!visited[i]) {
	            count++; 
	            ccDFS(i, visited); 
	        }
	    }
	    return count;
	}
 
 private void ccDFS(int curr, boolean[] visited) {
	    visited[curr] = true;
	    for (Edge edge : adjacencyList.get(curr)) {
	        if (!visited[edge.dest]) {
	            ccDFS(edge.dest, visited);
	        }
	    }
	}
}
