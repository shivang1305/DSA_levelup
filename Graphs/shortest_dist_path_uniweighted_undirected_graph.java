import java.util.*;

public class shortest_dist_path_uniweighted_undirected_graph {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < vtces; i++)
            adj.add(new ArrayList<>());

        for(int i = 0; i < edges; i++) {
            String line = scn.next();
            String[] word = line.split(" ");

            int u = Integer.parseInt(word[0]);
            int v = Integer.parseInt(word[1]);

            // adjacency list creation
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int src = scn.nextInt();
        scn.close();

        int[] dist = shortestPath(vtces, src, adj);

        for(int d : dist)
            System.out.print(d + " ");
    }

    // this func will return the shortest path of all vtces from src in the given uniweighted graph (simple BFS algo)
    public static int[] shortestPath(int vtces, int src, List<List<Integer>> adj) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(src);

        int[] dist = new int[vtces];
        Arrays.fill(dist, Integer.MAX_VALUE); // initially the dist of all nodes from src is infinity
        
        dist[src] = 0; // this is very imp step to mark dist of the src vertex as 0 

        while(!que.isEmpty()) {
            int rem = que.remove();

            for(int e : adj.get(rem)) {
                // when the curr dist is more than the obtained dist then we will update the dist because we need to obtain the shortest dist
                if(dist[e] > dist[rem] + 1) { 
                    dist[e] =  dist[rem] + 1;
                    que.add(e);
                }
            }
        }

        return dist;
    }
}