import java.util.*;


public class articulation_point {
    static int[] par, disc, low;
    static boolean[] visited, artiPt;
    static int time; // it symbolizes that at which pt the node is discorvered 

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int V = scn.nextInt();
        int E = scn.nextInt();
        
        // creating the graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<>());
            
        for(int i = 0; i < E; i++) {
            int u = scn.nextInt() - 1;
            int v = scn.nextInt() - 1;
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        scn.close();
        
        par = new int[V];
        disc = new int[V];
        low = new int[V];
        
        visited = new boolean[V];
        artiPt = new boolean[V];
        
        time = 0;
        par[0] = -1;
        
        dfs(graph, 0);
        
        int ans = 0;
        for(int i = 0; i < V; i++) {
            if(artiPt[i] == true)
                ans++;
        }
        
        System.out.println(ans);
        
    }
    
    public static void dfs(List<List<Integer>> graph, int src) {
        // in starting the discovery and the low array will have same value as when it is discovered
        disc[src] = time;
        low[src] = time;
        time++;
        
        int count = 0; // it is useful for the source node (i.e. 0) from where dfs is started
        
        visited[src] = true; // marking the curr node as visited
        
        for(int nbr: graph.get(src)) {
            if(par[src] == nbr) // if the nbr is parent of curr node
                continue;
                
            else if(visited[nbr] == true) // if the nbr is already visited
                low[src] = Math.min(low[src], disc[nbr]); // update the low value in comparsion with discovery of nbr node
            
            else {
                par[nbr] = src; // marking the parent of curr node 
                
                count++; // counting how many dfs calls can be made from the curr src
                dfs(graph, nbr);
                
                low[src] = Math.min(low[src], low[nbr]); // update the low value for curr src while backtracking
                
                if(par[src] == -1) { // exceptional case for actual source
                    if(count >= 2) // if there are more than 1 way to reach the actual src (i.e. 0th node) then 0 is artiPt
                        artiPt[src] = true;
                }
                
                else {
                    if(low[nbr] >= disc[src]) // condition for curr src to be articulation pt
                        artiPt[src] = true; 
                }
            }
        }
    }
    
    // Time complexity = O(V + E) -> single DFS can obatain the articulation pts in the graph
    // Space complexity = O(V)
}