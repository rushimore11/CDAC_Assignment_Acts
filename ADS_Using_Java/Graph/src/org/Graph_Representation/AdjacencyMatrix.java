package org.Graph_Representation;

import java.util.Arrays;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        int V = 5;
        int[][] matrix = new int[V][V];

        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 4}, {3, 4}};

        // Undirected edge: mark both directions
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        // Print the matrix row by row
        for (int i = 0; i < V; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}