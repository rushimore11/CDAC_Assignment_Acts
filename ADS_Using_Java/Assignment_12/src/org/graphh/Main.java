package org.graphh;

import java.util.Arrays;
import org.graphh.AdjListGraph;
public class Main {
 public static void main(String[] args) {
	
     System.out.println("   PART 1: GRAPH CONNECTIVITY TESTING     ");
     
     int vertices = 6;
     AdjListGraph graph = new AdjListGraph(vertices, false);

     graph.addEdge(0, 1, 1);
     graph.addEdge(1, 2, 1);
    
     graph.addEdge(3, 4, 1);

     System.out.println("[Testing Disconnected Graph]");
     System.out.println("Is the graph fully connected? -> " + graph.isConnected()); 
     System.out.println("Total connected components    -> " + graph.connectedComponentCount());
     System.out.println();

     System.out.println("[Adding edges to connect the whole graph...]");
     graph.addEdge(2, 3, 1); 
     graph.addEdge(4, 5, 1); 

     System.out.println("Is the graph fully connected now? -> " + graph.isConnected()); 
     System.out.println("Total connected components        -> " + graph.connectedComponentCount());
     
    
     System.out.println("   PART 2: RANDOMIZED QUICKSORT TESTING  ");
 
     int[] data = {80, 10, 50, 30, 90, 30, 40, 20, 70, 0};
     
     System.out.println("Original Array: " + Arrays.toString(data));
     
     RandomizedQuicksort.sort(data);
     
     System.out.println("Sorted Array:   " + Arrays.toString(data));
     System.out.println("\nExecution completed successfully.");
     
 }
}



