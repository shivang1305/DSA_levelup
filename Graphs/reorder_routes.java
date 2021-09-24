// Leetcode - Medium (Que. 1466 -> Reorder Routes to Make All Paths Lead to the City Zero)

import java.util.*;


public class reorder_routes {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) 
            graph.add(new ArrayList<>());
        
        for(int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            
            graph.get(u).add(v);
            graph.get(v).add(-u); // -ve sign indicates that this edge is reversed
        }
        
        return DFS(graph, 0, new boolean[n]);
    }
    
    public int DFS(List<List<Integer>> graph, int src, boolean[] visited) {
        visited[src] = true;
        int change = 0;
        
        for(int e : graph.get(src)) {
            if(visited[Math.abs(e)] == false)
                change += DFS(graph, Math.abs(e), visited) + (e > 0 ? 1 : 0); // for the current edge
            // if we travelled on a edge with positive weight then we need to change that edge
        }
        return change;
    }
}
