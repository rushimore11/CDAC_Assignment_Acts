package org.graphh;

import org.graphh.AdjListGraph;
import org.graphh.AdjacencyMatrix;

public class Main {
 public static void main(String[] args) {
     int vertices = 5;
     
     System.out.println("--- Testing Adjacency List (BFS) ---");
     AdjListGraph listGraph = new AdjListGraph(vertices, false);
     listGraph.addEdge(0, 1, 1);
     listGraph.addEdge(0, 2, 1);
     listGraph.addEdge(1, 3, 1);
     listGraph.addEdge(2, 4, 1);
     
     listGraph.printBFS(0); 
     
     System.out.println("\n--- Testing Adjacency Matrix (DFS) ---");
     AdjacencyMatrix matrixGraph = new AdjacencyMatrix(vertices, false);
     matrixGraph.addEdge(0, 1, 1);
     matrixGraph.addEdge(0, 2, 1);
     matrixGraph.addEdge(1, 3, 1);
     matrixGraph.addEdge(2, 4, 1);
     
     matrixGraph.printDFS(0); 
 }
}



