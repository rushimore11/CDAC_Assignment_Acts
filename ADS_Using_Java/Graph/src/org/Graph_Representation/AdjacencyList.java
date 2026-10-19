package org.Graph_Representation;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 4}, {3, 4}};

        
        for (int[] edge : edges) {
        	
            int u = edge[0], v = edge[1];
            
            adj.get(u).add(v); // u --> v
            adj.get(v).add(u); // v --> u
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}