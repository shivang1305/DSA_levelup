import java.util.*;


public class shortest_path_in_weighted_DAG {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < vtces; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < edges; i++) {
            String[] line = scn.next().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int wt = Integer.parseInt(line[2]);

            // since this is a directed graph so there is only a edge from u -> v and not v -> u.
            graph.get(u).add(new Edge(u, v, wt)); 
            // graph.get(v).add(new Edge(v, u, wt)); 
        }

        int src = scn.nextInt();
        scn.close();

        int[] dist = shortestPathDAG(graph, src, vtces);

        for(int d : dist) 
            System.out.println(d + " ");
    }

    public static void topoSort(List<List<Edge>> graph, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;

        for(Edge e : graph.get(src)) {
            if(visited[e.nbr] == false)
                topoSort(graph, e.nbr, visited, st);
        }

        st.push(src);
    }

    public static int[] shortestPathDAG(List<List<Edge>> graph, int src, int vtces) {
        int[] dist = new int[vtces];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[vtces];

        for(int i = 0; i < vtces; i++) {
            if(visited[i] == false)
                topoSort(graph, i, visited, st);
        }

        dist[src] = 0;

        while(!st.isEmpty()) {
            int rem = st.pop();

            for(Edge e : graph.get(rem)) {
                if(dist[e.src] > dist[rem] + e.wt)
                    dist[e.src] = dist[rem] + e.wt;
            }
        }

        return dist;
    }
}
