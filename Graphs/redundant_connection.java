// Leetcode - Medium (Que. 684)

import java.util.*;

class redundant_connection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        int[] ans = new int[2];
        
        for(int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            
            graph.get(u).add(v);
            graph.get(v).add(u); // since the graph is undirected
            
            // check for cycle after adding each edge in the graph
            if(DFS(graph, u, -1, new boolean[n])) {
                ans = edge; // as soon as we find a cycle in the graph we got our ans
                break;
            }
        }
        
        return ans;
    }
    
    public boolean DFS(List<List<Integer>> graph, int src, int par, boolean[] visited) {
        if(visited[src] == true) 
            return true;
        
        visited[src] = true;
        
        for(int e : graph.get(src)) {
            if(e != par) 
                if(DFS(graph, e, src, visited))
                    return true;
        }
        
        return false;
    }
    
    // Time complexity = O(n*(V + E))
    // Space complexity = O(n)
}