// Leetcode - Medium (Que. 684)

import java.util.*;

class redundant_connection {
    /* Approach 1 - Using DFS
    since graph is dynamic we have to give the last edge which is responsible for creating the cycle in the graph so applying DFS by adding each edge in the graph is very costly in terms of time so this approach using DFS results in very high TC
    */
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
    
    /* Approach 2 - Using DSU 
    since for dynamic graph DSU can find things quicker by its union() & find() function which runs in constant time i.e. O(1)
    */
    
    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        
        int[] parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        int[] rank = new int[n];
        
        for(int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            
            if(union(u, v, parent, rank))
                return new int[] {edge[0], edge[1]};
        }
        
         return new int[] {-1, -1};
    }
    
    public int find(int x, int[] parent) {
        if(parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x], parent);
    }
    
    public boolean union(int u, int v, int[] parent, int[] rank) {
        u = find(u, parent);
        v = find(v, parent);
        
        if(u != v) {
           if(rank[u] > rank[v])
                parent[v] = u;
            else if(rank[u] < rank[v])
                parent[u] = v;
            else {
                parent[u] = v;
                rank[v]++;
            } 
            return false;
        }
        
        else
            return true;
    }
    
    // Time complexity = O(n) -> union() & find() works in O(1)
    // Space complexity = O(n) -> for parent and rank arrray
}