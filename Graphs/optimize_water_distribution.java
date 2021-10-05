import java.util.*;


public class optimize_water_distribution {
    static class Pair implements Comparable<Pair>{
        int vtx;
        int wt;
        
        Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
        
        @Override
        public int compareTo(Pair p) {
            return this.wt - p.wt;
        }
    }
  
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<List<Pair>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++)
          graph.add(new ArrayList<>());
          
        for(int i = 0; i < pipes.length; i++) {
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];
            
            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }
        
        for(int i = 1; i <= n; i++) {
            graph.get(i).add(new Pair(0, wells[i - 1]));
            graph.get(0).add(new Pair(i, wells[i - 1]));
        }
        
        int ans = 0;
        boolean[] visited = new boolean[n + 1];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        
        while(!pq.isEmpty()) {
            Pair rem = pq.remove();
            
            if(visited[rem.vtx] == false) {
                visited[rem.vtx] = true;
                ans += rem.wt;
            }
            
            List<Pair> nbrs = graph.get(rem.vtx);
            for(Pair nbr : nbrs) {
                if(visited[nbr.vtx] == false)
                  pq.add(nbr);
            }
        }
        
        return ans;
    }
    
    // Time complexity = O(ElogV) -> BFS with a priority queue (Prims Algo to obtain MST)
    // Space complexity = O(V + E) -> to create a graph
}
