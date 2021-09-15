import java.util.*;

public class shortest_dist_undirected_unweighted_graph {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int V = scn.nextInt();

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            String line = scn.next();
            String[] words = line.split(" ");
            int u = Integer.parseInt(words[0]);
            int v = Integer.parseInt(words[1]);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int src = scn.nextInt();
        scn.close();

        int[] distance = new int[V]; // wil give the shortest distance of all the vertices from the src node
        Arrays.fill(distance, -1); // intitially distance will be -1 which represents infinity

        shortestPath(adj, src, distance);

        for(int d : distance)
            System.out.print(d + " ");
    }

    // BFS Algo with updating the distance array instead of visited array
    private static void shortestPath(List<List<Integer>> adj, int src, int[] distance) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(src);

        while(!que.isEmpty()) {
            int node = que.remove();

            for(int e : adj.get(node)) {
                if(distance[e] == -1 || distance[node] + 1 < distance[e]) {
                    distance[e] = distance[node] + 1;
                    que.add(e);
                }
            }
        }
    }
}
