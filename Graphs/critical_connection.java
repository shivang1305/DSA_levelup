import java.util.*;


public class critical_connection {
    int[] parent, discovery, low;
    boolean[] visited;
    int time;
    
    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<>());
        
        for(List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        parent = new int[V];
        discovery = new int[V];
        low = new int[V];
        
        visited = new boolean[V];
        time = 0;
        
        parent[0] = -1;
        DFS(graph, 0);
        
        return bridges;
    }
    
    List<List<Integer>> bridges = new ArrayList<>();
    
    public void DFS(List<List<Integer>> graph, int src) {
        discovery[src] = time;
        low[src] = time;
        time++;
        
        visited[src] = true;
        
        for(int nbr : graph.get(src)) {
            if(parent[src] == nbr)
                continue;
            
            else if(visited[nbr] == true)
                low[src] = Math.min(low[src], discovery[nbr]);
            
            else {
                parent[nbr] = src;
                DFS(graph, nbr);
                
                low[src] = Math.min(low[src], low[nbr]);
                
                // strictly decreasing (only diff b/w articulation point and bridge is that in articulation pt we keep '=' sign which indicates that articulation point is evaluated on nodes while critical connectection or bridges is evaluated on bridges)
                
                // When we calc Articulation pt in terms of vertices then we assume that when we remove the vertex all edges attached with that vertex will automatically be removed, but this will not be the same in case of bridges, that's why this condition is slightly modified
                
                if(low[nbr] > discovery[src]) { 
                    List<Integer> edge = new ArrayList<>();
                    edge.add(src);
                    edge.add(nbr);
                    
                    bridges.add(edge);
                }
            }
        }
    }
    
    // Time complexity = O(V + E) (i.e. Time complexity of a single DFS)
    // Space complexity = O(V) -> recursive stack space
}
