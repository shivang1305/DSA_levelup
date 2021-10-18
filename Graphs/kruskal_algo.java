import java.util.*;


public class kruskal_algo {
    static int[] parent;
    static int[] rank;

    public static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
            public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static int minCostToSupplyWater(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        Pair[] arr = new Pair[edges.length];
            
        for(int i = 0; i < edges.length; i++)
            arr[i] = new Pair(edges[i][0], edges[i][1], edges[i][2]);
            
        Arrays.sort(arr);
        int ans = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(union(arr[i].u, arr[i].v))
                ans += arr[i].wt;
        }
        
        return ans;
    }
    
    public static int find(int x) {
        if(parent[x] == x)
            return x;
            
        return parent[x] = find(parent[x]); // path compression
    }
    
    public static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        
        if(u == v) // if they belong to same group (i.e. the edges are already connected)
            return false; // no need to reconnect them again so simply return false
            
        // if they are not connected
        // connect or put those edges into the same group by union by rank method
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
}
