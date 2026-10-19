package org.graph.dfs;
import java.util.*;

class IterativeDFS {
    public void dfsIterative(int start, List<List<Integer>> graph) {
    	
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

               
                for (int i = graph.get(node).size() - 1; i >= 0; i--) {
		                int neighbor = graph.get(node).get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}