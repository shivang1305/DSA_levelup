import java.util.*;


public class redundant_connection_2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        
        for(int i = 0; i <= n; i++)
            parent[i] = i;
        
        int[] indegree = new int[n + 1];
        Arrays.fill(indegree, -1);
        
        int blackList1 = -1, blackList2 = -1;
        
        for(int i = 0; i < n; i++) {
            // int u = edges[i][0];
            int v = edges[i][1];
            
            if(indegree[v] == -1)
                indegree[v] = i;
            
            else { // we have found the node with 2 parent or having indegree as 2
                blackList1 = i;
                blackList2 = indegree[v];
                break;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(i == blackList1) // ignoring the curr blacklist edge
                continue;
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            // check for cycle in the graph by DSU
            if(union(u, v, parent, rank)) {
                if(blackList1 == -1) // case 2: no node with 2 parents but a cycle 
                    return edges[i];
                else // case 3: 2 parents + cycle
                    return edges[blackList2];
            }
        }
        
        return edges[blackList1]; // case 1: 2 parents
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
        
        return true;
    }
    
    // Time complexity = O(n)
    // Space complexity = O(3n)
}