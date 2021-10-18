import java.util.*;


public class remove_max_no_of_edges_to_keep_graph_fully_traversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // sort the edges accorting to their types in the descending order
        // give the preference to those edges which are of type 3
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0])); // O(n.logn)  
          
        int[] parentAlis = new int[n + 1];
        int[] parentBob = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            parentAlis[i] = i;
            parentBob[i] = i;
        }
        
        int[] rankAlis = new int[n + 1];
        int[] rankBob = new int[n + 1];
        
        int mergedAlis = 1, mergedBob = 1;
        int removeEdgeCount = 0;
        
        for(int[] edge : edges) { // O(n)
            if(edge[0] == 3) { 
                boolean temp1 = union(edge[1], edge[2], parentAlis, rankAlis);
                boolean temp2 = union(edge[1], edge[2], parentBob, rankBob);
                
                if(temp1)
                    mergedAlis++;
                if(temp2)
                    mergedBob++;
                    
                if(temp1 == false && temp2 == false)
                    removeEdgeCount++;
            }
            
            else if(edge[0] == 1) {
                boolean temp = union(edge[1], edge[2], parentAlis, rankAlis);
                
                if(temp)
                    mergedAlis++;
                    
                else
                    removeEdgeCount++;
            }
            
            else if(edge[0] == 2) {
                boolean temp = union(edge[1], edge[2], parentBob, rankBob);
                
                if(temp)
                    mergedBob++;
                    
                else
                    removeEdgeCount++;
            }
        }
        
        // check that even after removing the max possible edges the graph remains connected or not
        return (mergedAlis != n || mergedBob != n) ? -1 : removeEdgeCount;
        
      }
      
      public static boolean union(int u, int v, int[] parent, int[] rank) {
          u = find(u, parent);
          v = find(v, parent);
          
          if(u == v)
            return false;
            
          if(rank[u] > rank[v])
            parent[v] = u;
          else if(rank[u] < rank[v])
            parent[u] = v;
          else {
              parent[u] = v;
              rank[v]++;
          }
          
          return true;
      }
      
      public static int find(int x, int[] parent) {
          if(parent[x] == x)
            return x;
            
          return parent[x] = find(parent[x], parent);
      }

      // Time complexity = O(n.logn)
      // Space complexity = O(4n)
    
}