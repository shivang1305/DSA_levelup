/*
Find the number of strongly connected components in the given directed graph
*/

import java.util.*;

public class kosaraju_algo {
	public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int V = scn.nextInt();
        int E = scn.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<>());
            
        for(int i = 0; i < E; i++) {
            int u = scn.nextInt() - 1;
            int v = scn.nextInt() - 1;
            
            graph.get(u).add(v);
            // graph.get(v).add(u);  // since it is a directed graph
        }
        scn.close();
        
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == false)
                DFS1(graph, i, st, visited);
        }
        
        List<List<Integer>> nGraph = new ArrayList<>();
        for(int i = 0; i < V; i++)
            nGraph.add(new ArrayList<>());
            
        for(int i = 0; i < V; i++) {
            List<Integer> nbrs = graph.get(i);
            for(int nbr : nbrs)
                nGraph.get(nbr).add(i); // reversing the edges of the graph in the new graph
        }
        
        visited = new boolean[V];
        int count = 0;
        
        while(!st.isEmpty()) {
            int rem = st.pop();
            if(visited[rem] == false) {
                DFS2(nGraph, rem, visited);
                count++;
            }
        }
        
        System.out.println(count); // number of strongly connected components in the given directed graph
	}
	
	public static void DFS1(List<List<Integer>> graph, int src, Stack<Integer> st, boolean[] visited) {
	    visited[src] = true;
	    
	    for(int e : graph.get(src)) {
	        if(visited[e] == false) 
	            DFS1(graph, e, st, visited);
	    }
	    
	    st.push(src);
	}
	
	public static void DFS2(List<List<Integer>> graph, int src, boolean[] visited) {
	    visited[src] = true;
	    
	    for(int e : graph.get(src)) {
	        if(visited[e] == false) 
	            DFS2(graph, e, visited);
	    }
	}

}
