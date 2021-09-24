import java.io.*;
import java.util.*;


public class mother_vertex{
    	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}
    
    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> graph){
		boolean[] visited = new boolean[V];
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < V; i++) {
		    if(visited[i] == false)
		        DFS(graph, i, visited, st);
		}
		
		int src = st.pop();
		
		visited = new boolean[V];
		
		DFS(graph, src, visited);
		
		for(boolean v : visited) {
		    if(v == false)
		        return -1;
		}
		
		return src + 1; // since it is 1-based indexing
    }
    
    public static void DFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        
        for(int e : graph.get(src)) {
            if(visited[e] == false)
                DFS(graph, e, visited, st);
        }
        
        st.push(src); // add the elements into the stack in postorder while backtracking
    }
    
    public static void DFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
        visited[src] = true;
        
        for(int e : graph.get(src)) {
            if(visited[e] == false)
                DFS(graph, e, visited);
        }
    }
}

// Time complexity = O(V + E)
// Space complexity = O(V)