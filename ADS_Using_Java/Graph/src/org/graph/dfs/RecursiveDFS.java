package org.graph.dfs;
import java.util.*;

public class RecursiveDFS {
    
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int source, int destination) {
        adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    }
     

    public void dfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("Recursive DFS Traversal starting from node " + startNode + ": ");
        dfsRecursive(startNode, visited);
        System.out.println();
    }

    private void dfsRecursive(int currentNode, Set<Integer> visited) {
    
        visited.add(currentNode);
        System.out.print(currentNode + " ");

        List<Integer> neighbors = adjList.getOrDefault(currentNode, new ArrayList<>());

        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        RecursiveDFS graph = new RecursiveDFS();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        graph.dfs(0);
    }
}
