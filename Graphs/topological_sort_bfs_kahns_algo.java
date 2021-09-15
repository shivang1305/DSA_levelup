import java.util.*;

public class topological_sort_bfs_kahns_algo {
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
        scn.close();

        int[] topoSort = kahnAlgo(vtces, adj);

        for(int val : topoSort)
            System.out.print(val + " ");
    }

    // BFS 
    public static int[] kahnAlgo(int vtces, List<List<Integer>> adj) {
        int[] indegree = new int[vtces];

        // obtaining the indegree of all vtces of the graph
        for(int i = 0; i < vtces; i++) {
            for(int nbr : adj.get(i))
                indegree[nbr]++;
        }

        Queue<Integer> que = new ArrayDeque<>();

        for(int i = 0; i < vtces; i++) {
            if(indegree[i] == 0)
                que.add(i); // initially adding all 0 indegree vtces of graph
        }

        int[] ans = new int[vtces];
        int idx = 0;

        while(!que.isEmpty()) {
            int rem = que.remove();

            ans[idx++] = rem;

            for(int e : adj.get(rem)) { 
                indegree[e]--;
                if(indegree[e] == 0)
                    que.add(e);
            }
        }

        // here -1 represents that topological sort of the given graph is not possible because the graph is not DAG(Directed Acyclic Graph)
        return (idx == vtces) ? ans : new int[]{-1}; 
    }
}