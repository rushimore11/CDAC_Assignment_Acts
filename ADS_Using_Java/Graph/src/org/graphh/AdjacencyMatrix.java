package org.graphh;

public class AdjacencyMatrix {
 private final int[][] matrix;
 private final boolean isDirected;
 private final int vertices;

 public AdjacencyMatrix(int vertices, boolean isDirected) {
     this.vertices = vertices;
     this.isDirected = isDirected;
     this.matrix = new int[vertices][vertices];
 }

 public void addEdge(int src, int dest, int weight) {
     matrix[src][dest] = weight;
     if (!isDirected) {
         matrix[dest][src] = weight;
     }
 }
 public void printDFS(int startVertex) {
     if (startVertex < 0 || startVertex >= vertices) {
         throw new IllegalArgumentException("Vertex out of bounds");
     }

     boolean[] visited = new boolean[vertices];
     System.out.print("DFS Traversal starting from vertex " + startVertex + ": ");
     
     dfsHelper(startVertex, visited);
     System.out.println();
 }

 private void dfsHelper(int curr, boolean[] visited) {
     visited[curr] = true;
     System.out.print(curr + " ");

     for (int i = 0; i < vertices; i++) {
         if (matrix[curr][i] != 0 && !visited[i]) {
             dfsHelper(i, visited);
         }
     }
 }
}




